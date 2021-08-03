package com.huomai.business.service;

import com.huomai.business.bo.HuomaiOrderItemAddBo;
import com.huomai.business.bo.HuomaiOrderItemEditBo;
import com.huomai.business.bo.HuomaiOrderItemQueryBo;
import com.huomai.business.domain.HuomaiOrderItem;
import com.huomai.business.vo.HuomaiOrderItemVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 订单记录项Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiOrderItemService extends IServicePlus<HuomaiOrderItem> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiOrderItemVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiOrderItemVo> queryPageList(HuomaiOrderItemQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiOrderItemVo> queryList(HuomaiOrderItemQueryBo bo);

	/**
	 * 根据新增业务对象插入订单记录项
	 *
	 * @param bo 订单记录项新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiOrderItemAddBo bo);

	/**
	 * 根据编辑业务对象修改订单记录项
	 *
	 * @param bo 订单记录项编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiOrderItemEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
