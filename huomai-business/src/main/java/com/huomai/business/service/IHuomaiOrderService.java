package com.huomai.business.service;

import com.huomai.business.bo.HuomaiOrderAddBo;
import com.huomai.business.bo.HuomaiOrderEditBo;
import com.huomai.business.bo.HuomaiOrderQueryBo;
import com.huomai.business.domain.HuomaiOrder;
import com.huomai.business.vo.HuomaiOrderDetailVo;
import com.huomai.business.vo.HuomaiOrderVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 订单记录Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiOrderService extends IServicePlus<HuomaiOrder> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiOrderVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiOrderVo> queryPageList(HuomaiOrderQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiOrderVo> queryList(HuomaiOrderQueryBo bo);

	/**
	 * 根据新增业务对象插入订单记录
	 *
	 * @param bo 订单记录新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiOrderAddBo bo);

	/**
	 * 根据编辑业务对象修改订单记录
	 *
	 * @param bo 订单记录编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiOrderEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

	/***
	* @description: 订单详情
	* @author chenshufeng
	* @date: 2021/6/26 9:51 下午
	*/
	HuomaiOrderDetailVo getInfo(Long id);
}
