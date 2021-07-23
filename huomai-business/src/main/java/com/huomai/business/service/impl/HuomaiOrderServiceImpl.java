package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.binarywang.wxpay.bean.entpay.EntPayRequest;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.huomai.business.bo.*;
import com.huomai.business.domain.*;
import com.huomai.business.mapper.*;
import com.huomai.business.service.*;
import com.huomai.business.vo.HuomaiOrderDetailVo;
import com.huomai.business.vo.HuomaiOrderVo;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.exception.BaseException;
import com.huomai.common.utils.DateUtils;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import com.huomai.common.utils.ip.IpUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiOrderServiceImpl extends ServiceImpl<HuomaiOrderMapper, HuomaiOrder> implements IHuomaiOrderService {

	@Autowired
	private HuomaiOrderMapper orderMapper;

	@Autowired
	private HuomaiOrderItemMapper orderItemMapper;

	@Autowired
	private WxPayService wxService;

	@Autowired
	private IHuomaiUserService userService;

	@Autowired
	private IHuomaiOrderItemService itemService;

	@Autowired
	private IHuomaiUserInviteService inviteService;

	@Autowired
	private IHuomaiGiftConfigService configService;

	@Autowired
	private HuomaiPromoteConfigMapper promoteConfigMapper;

	@Autowired
	private HuomaiUserPromoteMapper userPromoteMapper;

	@Autowired
	private HuomaiVideoMapper videoMapper;


	@Override
	public HuomaiOrderVo queryById(Long id) {
		return getVoById(id, HuomaiOrderVo.class);
	}

	/***
	 * @description: 订单列表
	 * @author chenshufeng
	 * @date: 2021/6/26 9:47 下午
	 */
	@Override
	public TableDataInfo<HuomaiOrderVo> queryPageList(HuomaiOrderQueryBo bo) {
		List<HuomaiOrderVo> vos = orderMapper.queryList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(vos);
	}

	@Override
	public List<HuomaiOrderVo> queryList(HuomaiOrderQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiOrderVo.class);
	}


	@Override
	public Boolean insertByAddBo(HuomaiOrderAddBo bo) {
		HuomaiOrder add = BeanUtil.toBean(bo, HuomaiOrder.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiOrderEditBo bo) {
		HuomaiOrder update = BeanUtil.toBean(bo, HuomaiOrder.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiOrder entity) {
		//TODO 做一些数据校验,如唯一约束
	}

	@Override
	public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
		if (isValid) {
			//TODO 做一些业务上的校验,判断是否需要校验
		}
		return removeByIds(ids);
	}

	/***
	 * @description: 订单详情
	 * @author chenshufeng
	 * @date: 2021/6/26 9:51 下午
	 */
	@Override
	public HuomaiOrderDetailVo getInfo(Long id) {
		return getVoById(id, HuomaiOrderDetailVo.class);
	}

	/**
	 * 下单接口
	 *
	 * @param bo
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public AjaxResult createOrder(HuomaiOrderAddBo bo) {
		String payWay = bo.getPayWay();
		Long userId = SecurityUtils.getUserId();
		String orderNo = String.valueOf(System.currentTimeMillis());
		Date nowDate = DateUtils.getNowDate();
		HuomaiOrder add = BeanUtil.toBean(bo, HuomaiOrder.class);
		add.setOrderType(1);
		add.setUserId(userId);
		add.setOrderNo(orderNo);

		//获取推广配置
		List<HuomaiPromoteConfig> promoteConfigs = promoteConfigMapper.selectList(Wrappers.emptyWrapper());
		if (promoteConfigs == null) {
			throw new BaseException("请先设置推广配置信息");
		}
		HuomaiPromoteConfig promoteConfig = promoteConfigs.get(0);
		Long inviteNum = promoteConfig.getInviteNum();
		if (null != inviteNum && inviteNum > 0) {
			//邀请人数限制
			int count = inviteService.count(Wrappers.<HuomaiUserInvite>lambdaQuery().eq(HuomaiUserInvite::getUserId, userId));
			if (count < inviteNum) {
				throw new BaseException(String.format("您邀请的人数必须满【%s】人才能推广作品", inviteNum));
			}
		}
		//热门人数限制
		Long maxNum = promoteConfig.getMaxNum();
		//热门日期列表
		List<Map<String, Long>> maps = orderMapper.groupOrderByTime();

		//T+1天开开始计算，如果哪天满足上热门的条件，那就在哪天
		int days = 1;
		if (maps != null && maps.size() > 0) {
			for (Map<String, Long> map : maps) {
				String curDay = DateFormatUtils.format(DateUtils.addDays(nowDate, days), DateUtils.YYYY_MM_DD);
				Long hotNum = map.getOrDefault(curDay, 0L);
				if (hotNum > maxNum) {
					days++;
				} else {
					add.setHotStartTime(getStartTime(nowDate, days));
					add.setHotEndTime(getEndTime(nowDate, days));
				}
			}
		} else {
			//从明天开始
			add.setHotStartTime(getStartTime(nowDate, days));
			add.setHotEndTime(getEndTime(nowDate, days));
		}


		//新增订单项
		Date date = DateUtils.getNowDate();
		List<Long> videoList = bo.getVideoList();
		if (videoList != null && videoList.size() > 0) {
			List<HuomaiOrderItem> items = videoList.stream().map(videoId -> HuomaiOrderItem.builder().orderNo(orderNo).videoId(videoId).createTime(date).build()).collect(Collectors.toList());
			itemService.saveBatch(items);
		}

		//微信支付
		if ("1".equals(payWay)) {
			add.setStatus("1");
			//插入订单记录
			save(add);
			return wxPay(add.getOrderNo(), bo.getAmount(), "作品推广购买", bo.getDomain());
		} else if ("2".equals(payWay)) {
			//余额支付
			add.setStatus("2");
			add.setPayTime(DateUtils.getNowDate());
			//插入订单记录
			save(add);

			//扣减用户金额
			subtractUserAccount(bo);
		}

		return AjaxResult.success();
	}

	/**
	 * 扣减用户金额
	 *
	 * @param bo
	 */
	public void subtractUserAccount(HuomaiOrderAddBo bo) {
		HuomaiUser user = userService.getById(SecurityUtils.getUserId());
		BigDecimal subtract = Optional.ofNullable(user.getTotalAmount()).orElse(BigDecimal.ZERO).subtract(bo.getAmount());
		if (subtract.doubleValue() < 0) {
			throw new BaseException("账户余额不足,请先充值后购买");
		}
		HuomaiUser upt = new HuomaiUser();
		upt.setUserId(user.getUserId());
		upt.setTotalAmount(subtract);
		userService.updateById(upt);
	}

	/**
	 * 微信支付回调处理
	 *
	 * @param payNo
	 * @param bizPayNo
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void paySuccess(String payNo, String bizPayNo) {
		LambdaQueryWrapper<HuomaiOrder> wrapper = Wrappers.lambdaQuery();
		wrapper.eq(HuomaiOrder::getOrderNo, payNo);
		HuomaiOrder order = orderMapper.selectOne(wrapper);
		BigDecimal amount = order.getAmount();
		//已支付不处理
		if (order == null || "2".equals(order.getStatus())) {
			return;
		}
		Integer orderType = order.getOrderType();
		//充值
		if ("2".equals(String.valueOf(orderType))) {
			changeUserMoney(order.getUserId(), amount, "+");
		}
		HuomaiOrder opt = new HuomaiOrder();
		opt.setId(order.getId());
		opt.setPayTime(DateUtils.getNowDate());
		opt.setStatus("2");//支付成功
		orderMapper.updateById(opt);


		//给对应的视频设置热门时间
		List<HuomaiOrderItem> orderItems = orderItemMapper.selectList(Wrappers.<HuomaiOrderItem>lambdaQuery().eq(HuomaiOrderItem::getOrderNo, payNo));
		if (orderItems.size() > 0) {
			Date hotStartTime = order.getHotStartTime();
			Date hotEndTime = order.getHotEndTime();

			for (HuomaiOrderItem item : orderItems
			) {
				Long videoId = item.getVideoId();
				HuomaiVideo video = videoMapper.selectById(videoId);
				HuomaiVideo uptVideo = new HuomaiVideo();
				uptVideo.setHotStartTime(hotStartTime);
				uptVideo.setHotEndTime(hotEndTime);
				uptVideo.setHotNum(Optional.ofNullable(video.getHotNum()).orElse(0L) + 1);
				videoMapper.updateById(uptVideo);
			}

			//推广分账
			Long userId = order.getUserId();//下单用户
			Long inviteUserId = null;
			List<HuomaiUserInvite> userInvites = inviteService.getBaseMapper().selectList(Wrappers.<HuomaiUserInvite>lambdaQuery().eq(HuomaiUserInvite::getByUserId, userId));
			if (userInvites.size() > 0) {
				inviteUserId = userInvites.get(0).getUserId();
			}
			//上一个购买人
			Long preUserId = orderMapper.preUser(order.getUserId(), order.getPayTime());


			//获取推广配置
			List<HuomaiPromoteConfig> promoteConfigs = promoteConfigMapper.selectList(Wrappers.emptyWrapper());
			if (promoteConfigs.size() > 0) {
				Date nowDate = DateUtils.getNowDate();
				for (HuomaiOrderItem item : orderItems
				) {
					Long videoId = item.getVideoId();
					HuomaiPromoteConfig config = promoteConfigs.get(0);
					//邀请人和被助推人按比例分账
					BigDecimal inviteMoney = amount.multiply(config.getInviteRate().divide(BigDecimal.valueOf(100), RoundingMode.DOWN));
					BigDecimal boosterMoney = amount.multiply(config.getBoosterRate().divide(BigDecimal.valueOf(100), RoundingMode.DOWN));
					if (inviteUserId != null) {
						HuomaiUserPromote iUser = new HuomaiUserPromote();
						iUser.setUserId(inviteUserId);
						iUser.setVideoId(videoId);
						iUser.setReceivedVal(inviteMoney);
						iUser.setProfit(inviteMoney);
						iUser.setCreateTime(nowDate);
						userPromoteMapper.insert(iUser);
						//余额增加
						changeUserMoney(userId, inviteMoney, "+");
					}

					if (preUserId != null) {
						HuomaiUserPromote bUser = new HuomaiUserPromote();
						bUser.setUserId(preUserId);
						bUser.setVideoId(videoId);
						bUser.setReceivedVal(boosterMoney);
						bUser.setProfit(boosterMoney);
						bUser.setCreateTime(nowDate);
						userPromoteMapper.insert(bUser);
						changeUserMoney(userId, boosterMoney, "-");
					}


					//下单人
					HuomaiUserPromote buyUser = new HuomaiUserPromote();
					buyUser.setUserId(userId);
					buyUser.setVideoId(videoId);
					buyUser.setSendVal(inviteMoney);
					buyUser.setCreateTime(nowDate);
					userPromoteMapper.insert(buyUser);
					changeUserMoney(userId, amount, "-");
				}
			}
		}

	}

	/**
	 * 更新用户余额
	 *
	 * @param userId
	 * @param amount
	 * @param opt
	 */
	public void changeUserMoney(Long userId, BigDecimal amount, String opt) {
		HuomaiUser user = userService.getById(userId);
		HuomaiUser upt = new HuomaiUser();
		upt.setUserId(userId);
		if ("+".equals(opt)) {
			upt.setTotalAmount(Optional.ofNullable(user.getTotalAmount()).orElse(BigDecimal.ZERO).add(amount));
			upt.setCashAmount(Optional.ofNullable(user.getCashAmount()).orElse(BigDecimal.ZERO).add(amount));
		} else if ("-".equals(opt)) {
			upt.setTotalAmount(Optional.ofNullable(user.getTotalAmount()).orElse(BigDecimal.ZERO).subtract(amount));
			upt.setCashAmount(Optional.ofNullable(user.getCashAmount()).orElse(BigDecimal.ZERO).subtract(amount));
		}
		userService.updateById(upt);
	}

	/**
	 * 充值
	 *
	 * @param bo
	 * @return
	 */
	@Override
	public AjaxResult recharge(HuomaiRechargeAddBo bo) {
		String payWay = bo.getPayWay();
		HuomaiOrder add = BeanUtil.toBean(bo, HuomaiOrder.class);
		add.setOrderNo(String.valueOf(System.currentTimeMillis()));
		add.setUserId(SecurityUtils.getUserId());
		//微信支付
		if ("1".equals(payWay)) {
			add.setStatus("1");
			add.setOrderType(2);
			//插入订单记录
			save(add);
			return wxPay(add.getOrderNo(), bo.getAmount(), "充值购买", bo.getDomain());
		}
		return AjaxResult.success();
	}

	/**
	 * 提现申请,后台审核
	 *
	 * @param bo
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public AjaxResult cashApply(HuomaiCashAddBo bo) {
		HuomaiOrder add = BeanUtil.toBean(bo, HuomaiOrder.class);
		add.setOrderType(3);
		add.setOrderNo(String.valueOf(System.currentTimeMillis()));
		add.setUserId(SecurityUtils.getUserId());
		save(add);
		//打款
		EntPayRequest request = new EntPayRequest();
		try {
			HuomaiUser user = userService.getById(SecurityUtils.getUserId());
			request.setPartnerTradeNo(String.valueOf(System.currentTimeMillis()));
			request.setAppid("ww50a132e280d40c42");
			request.setCheckName("NO_CHECK");
			request.setAmount(bo.getAmount().intValue());
			request.setOpenid(user.getOpenid());
			request.setDescription("提现");
			request.setSpbillCreateIp(IpUtils.getHostIp());
			this.wxService.getEntPayService().entPay(request);
		} catch (WxPayException e) {
			log.error(e.getMessage(), e);
			throw new BaseException("提现失败" + e.getMessage());
		}
		return AjaxResult.success();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void giftOrder(HuomaiSplitGiftBo bo) {
		Long userId = bo.getUserId();
		Long userIdBy = bo.getUserIdBy();
		Double money = bo.getMoney();
		String inviteCode = bo.getInviteCode();
		//新增两条订单记录
		HuomaiOrder userOrder = new HuomaiOrder();
		userOrder.setUserId(userId);
		userOrder.setOrderType(4);
		userOrder.setStatus("2");
		userOrder.setPayTime(DateUtils.getNowDate());
		userOrder.setOrderNo(String.valueOf(System.currentTimeMillis()));
		userOrder.setAmount(BigDecimal.valueOf(money));
		orderMapper.insert(userOrder);

		HuomaiOrder userByOrder = new HuomaiOrder();
		userByOrder.setUserId(userIdBy);
		userByOrder.setOrderType(4);
		userByOrder.setStatus("2");
		userByOrder.setPayTime(DateUtils.getNowDate());
		userByOrder.setOrderNo(String.valueOf(System.currentTimeMillis()));
		userByOrder.setAmount(BigDecimal.valueOf(money));
		orderMapper.insert(userOrder);


		//生成邀请记录
		HuomaiUserInviteAddBo addBo = new HuomaiUserInviteAddBo();
		addBo.setUserId(userId);
		addBo.setByUserId(userIdBy);
		addBo.setInviteCode(inviteCode);
		inviteService.insertByAddBo(addBo);

		//扣减红包总金额

		HuomaiGiftConfig config = bo.getConfig();
		config.setTotalAmount(config.getTotalAmount().subtract(BigDecimal.valueOf(money).multiply(BigDecimal.valueOf(2))));
		configService.updateById(config);
	}

	/**
	 * 调用微信支付api
	 *
	 * @param orderNo
	 * @param money
	 * @param body
	 * @param apiDomain
	 * @return
	 */
	public AjaxResult wxPay(String orderNo, BigDecimal money, String body, String apiDomain) {

		HuomaiUser user = userService.getById(SecurityUtils.getUserId());
		WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
		orderRequest.setBody(body);
		orderRequest.setOutTradeNo(orderNo);
		orderRequest.setTotalFee(money.multiply(BigDecimal.valueOf(100)).intValue());
		orderRequest.setSpbillCreateIp(IpUtils.getHostIp());
		orderRequest.setNotifyUrl(apiDomain + "/business/wxpay/callback");
		orderRequest.setTradeType(WxPayConstants.TradeType.JSAPI);
		orderRequest.setOpenid(user.getOpenid());
		try {
			WxPayMpOrderResult order = wxService.createOrder(orderRequest);
			return AjaxResult.success(order);
		} catch (WxPayException e) {
			log.error(e.getMessage(), e);
			throw new BaseException("微信支付失败");
		}
	}

	public static void main(String[] args) {
		//2021 01-01 00.00.00
		//2021 01-01 23.59.59
		Date startTime = getStartTime(DateUtils.getNowDate(), 1);
		System.out.println(DateFormatUtils.format(startTime, DateUtils.YYYY_MM_DD_HH_MM_SS));
		Date endTime = getEndTime(DateUtils.getNowDate(), 1);
		System.out.println(DateFormatUtils.format(endTime, DateUtils.YYYY_MM_DD_HH_MM_SS));
	}

	public static Date getStartTime(Date curDate, int days) {
		return DateUtils.parseDate(DateFormatUtils.format(DateUtils.addDays(DateUtils.getNowDate(), days), DateUtils.YYYY_MM_DD) + " 00:00:00");
	}

	public static Date getEndTime(Date curDate, int days) {
		return DateUtils.parseDate(DateFormatUtils.format(DateUtils.addDays(DateUtils.getNowDate(), days), DateUtils.YYYY_MM_DD) + " 23:59:59");
	}
}
