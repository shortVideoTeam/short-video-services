package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiOrderAddBo;
import com.huomai.business.bo.HuomaiOrderEditBo;
import com.huomai.business.bo.HuomaiOrderQueryBo;
import com.huomai.business.domain.HuomaiOrder;
import com.huomai.business.mapper.HuomaiOrderMapper;
import com.huomai.business.service.IHuomaiOrderService;
import com.huomai.business.vo.HuomaiOrderDetailVo;
import com.huomai.business.vo.HuomaiOrderVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.DateUtils;
import com.huomai.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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
		add.setOrderNo(String.valueOf(System.currentTimeMillis()));
		add.setPayTime(DateUtils.getNowDate());
		//已付款
		add.setStatus("2");
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
}
