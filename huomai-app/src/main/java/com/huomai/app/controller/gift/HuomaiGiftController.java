package com.huomai.app.controller.gift;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Maps;
import com.huomai.business.bo.HuomaiSplitGiftBo;
import com.huomai.business.domain.HuomaiGiftConfig;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.domain.HuomaiUserInvite;
import com.huomai.business.service.IHuomaiGiftConfigService;
import com.huomai.business.service.IHuomaiOrderService;
import com.huomai.business.service.IHuomaiUserInviteService;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

/**
 * 红包金额配置Controller
 *
 * @author huomai
 * @date 2021-07-18
 */
@Api(value = "红包管理", tags = {"红包管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/config")
public class HuomaiGiftController extends BaseController {

	private final IHuomaiGiftConfigService configService;
	private final IHuomaiUserInviteService inviteService;
	private final IHuomaiUserService userService;
	private final IHuomaiOrderService orderService;


	/**
	 * 新增红包金额配置
	 */
	@ApiOperation("分红包")
	@PostMapping("/splitGift")
	public AjaxResult splitGift(@Validated @RequestBody HuomaiSplitGiftBo bo) {
		HashMap<Object, Object> map = Maps.newHashMap();

		//邀请码
		String inviteCode = bo.getInviteCode();
		//查询邀请人
		HuomaiUser inviteUser = userService.getOne(Wrappers.<HuomaiUser>lambdaQuery().eq(HuomaiUser::getInviteCode, inviteCode));
		Long userId = inviteUser.getUserId();
		Long userIdBy = SecurityUtils.getUserId();
		HuomaiUserInvite invite = inviteService.getOne(Wrappers.<HuomaiUserInvite>lambdaQuery().eq(HuomaiUserInvite::getUserId, userId).eq(HuomaiUserInvite::getByUserId, userIdBy));
		if (invite != null) {
			return AjaxResult.error("您已领取过了");
		}
		//判断钱包金额是否足够
		List<HuomaiGiftConfig> list = configService.list();
		if (list != null && list.size() > 0) {
			HuomaiGiftConfig config = list.get(0);
			BigDecimal singleAmount = config.getSingleAmount();
			BigDecimal totalAmount = config.getTotalAmount();
			double money = RandomUtil.randomDouble(0.01, singleAmount.doubleValue(), 2, RoundingMode.HALF_UP);
			if (money * 2 > totalAmount.doubleValue()) {
				return AjaxResult.error("您来晚了，红包已被抢光了");
			}
			bo.setUserId(userId);
			bo.setUserIdBy(userIdBy);
			bo.setMoney(money);
			bo.setConfig(config);
			orderService.giftOrder(bo);

			map.put("money", money);

			return AjaxResult.success(map);
		} else {
			return AjaxResult.error("您来晚了，红包已被抢光了");
		}
	}
}
