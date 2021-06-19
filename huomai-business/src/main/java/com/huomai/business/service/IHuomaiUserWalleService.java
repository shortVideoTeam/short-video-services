package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserWalleAddBo;
import com.huomai.business.bo.HuomaiUserWalleEditBo;
import com.huomai.business.bo.HuomaiUserWalleQueryBo;
import com.huomai.business.domain.HuomaiUserWalle;
import com.huomai.business.vo.HuomaiUserWalleVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 钱包明细Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiUserWalleService extends IServicePlus<HuomaiUserWalle> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiUserWalleVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiUserWalleVo> queryPageList(HuomaiUserWalleQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiUserWalleVo> queryList(HuomaiUserWalleQueryBo bo);

	/**
	 * 根据新增业务对象插入钱包明细
	 *
	 * @param bo 钱包明细新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiUserWalleAddBo bo);

	/**
	 * 根据编辑业务对象修改钱包明细
	 *
	 * @param bo 钱包明细编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiUserWalleEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
