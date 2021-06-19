package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiOrderAddBo;
import com.huomai.business.bo.HuomaiOrderEditBo;
import com.huomai.business.bo.HuomaiOrderQueryBo;
import com.huomai.business.domain.HuomaiOrder;
import com.huomai.business.mapper.HuomaiOrderMapper;
import com.huomai.business.service.IHuomaiOrderService;
import com.huomai.business.vo.HuomaiOrderVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 订单记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiOrderServiceImpl extends ServiceImpl<HuomaiOrderMapper, HuomaiOrder> implements IHuomaiOrderService {

	@Override
	public HuomaiOrderVo queryById(Long id) {
		return getVoById(id, HuomaiOrderVo.class);
	}

	@Override
	public TableDataInfo<HuomaiOrderVo> queryPageList(HuomaiOrderQueryBo bo) {
		PagePlus<HuomaiOrder, HuomaiOrderVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiOrderVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiOrderVo> queryList(HuomaiOrderQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiOrderVo.class);
	}

	private LambdaQueryWrapper<HuomaiOrder> buildQueryWrapper(HuomaiOrderQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiOrder> lqw = Wrappers.lambdaQuery();
		lqw.eq(StrUtil.isNotBlank(bo.getOrderNo()), HuomaiOrder::getOrderNo, bo.getOrderNo());
		lqw.eq(bo.getUserId() != null, HuomaiOrder::getUserId, bo.getUserId());
		lqw.eq(bo.getTime() != null, HuomaiOrder::getTime, bo.getTime());
		lqw.eq(StrUtil.isNotBlank(bo.getPage()), HuomaiOrder::getPage, bo.getPage());
		lqw.eq(bo.getAmount() != null, HuomaiOrder::getAmount, bo.getAmount());
		lqw.eq(bo.getPayTime() != null, HuomaiOrder::getPayTime, bo.getPayTime());
		lqw.eq(StrUtil.isNotBlank(bo.getStatus()), HuomaiOrder::getStatus, bo.getStatus());
		lqw.eq(StrUtil.isNotBlank(bo.getPayWay()), HuomaiOrder::getPayWay, bo.getPayWay());
		return lqw;
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
}
