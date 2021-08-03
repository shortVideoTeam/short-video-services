package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserSeachHisAddBo;
import com.huomai.business.bo.HuomaiUserSeachHisEditBo;
import com.huomai.business.bo.HuomaiUserSeachHisQueryBo;
import com.huomai.business.domain.HuomaiUserSeachHis;
import com.huomai.business.vo.HuomaiUserSeachHisVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 搜索历史记录Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiUserSeachHisService extends IServicePlus<HuomaiUserSeachHis> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiUserSeachHisVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiUserSeachHisVo> queryPageList(HuomaiUserSeachHisQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiUserSeachHisVo> queryList(HuomaiUserSeachHisQueryBo bo);

	/**
	 * 根据新增业务对象插入搜索历史记录
	 *
	 * @param bo 搜索历史记录新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiUserSeachHisAddBo bo);

	/**
	 * 根据编辑业务对象修改搜索历史记录
	 *
	 * @param bo 搜索历史记录编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiUserSeachHisEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

	/***
	* @description: 清空搜索历史
	* @author chenshufeng
	* @date: 2021/6/26 2:00 下午
	*/
	Boolean cleanHis();
}
