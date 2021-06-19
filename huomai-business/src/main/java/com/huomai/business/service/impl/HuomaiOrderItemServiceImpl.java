package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiOrderItemAddBo;
import com.huomai.business.bo.HuomaiOrderItemEditBo;
import com.huomai.business.bo.HuomaiOrderItemQueryBo;
import com.huomai.business.domain.HuomaiOrderItem;
import com.huomai.business.mapper.HuomaiOrderItemMapper;
import com.huomai.business.service.IHuomaiOrderItemService;
import com.huomai.business.vo.HuomaiOrderItemVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 订单记录项Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiOrderItemServiceImpl extends ServiceImpl<HuomaiOrderItemMapper, HuomaiOrderItem> implements IHuomaiOrderItemService {

	@Override
	public HuomaiOrderItemVo queryById(Long id) {
		return getVoById(id, HuomaiOrderItemVo.class);
	}

	@Override
	public TableDataInfo<HuomaiOrderItemVo> queryPageList(HuomaiOrderItemQueryBo bo) {
		PagePlus<HuomaiOrderItem, HuomaiOrderItemVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiOrderItemVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiOrderItemVo> queryList(HuomaiOrderItemQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiOrderItemVo.class);
	}

	private LambdaQueryWrapper<HuomaiOrderItem> buildQueryWrapper(HuomaiOrderItemQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiOrderItem> lqw = Wrappers.lambdaQuery();
		lqw.eq(StrUtil.isNotBlank(bo.getOrderNo()), HuomaiOrderItem::getOrderNo, bo.getOrderNo());
		lqw.eq(bo.getVideoId() != null, HuomaiOrderItem::getVideoId, bo.getVideoId());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiOrderItemAddBo bo) {
		HuomaiOrderItem add = BeanUtil.toBean(bo, HuomaiOrderItem.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiOrderItemEditBo bo) {
		HuomaiOrderItem update = BeanUtil.toBean(bo, HuomaiOrderItem.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiOrderItem entity) {
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
