package com.huomai.business.service;

import com.huomai.business.bo.HuomaiSensitiveAddBo;
import com.huomai.business.bo.HuomaiSensitiveEditBo;
import com.huomai.business.bo.HuomaiSensitiveQueryBo;
import com.huomai.business.domain.HuomaiSensitive;
import com.huomai.business.vo.HuomaiSensitiveVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 敏感词Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiSensitiveService extends IServicePlus<HuomaiSensitive> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiSensitiveVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiSensitiveVo> queryPageList(HuomaiSensitiveQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiSensitiveVo> queryList(HuomaiSensitiveQueryBo bo);

	/**
	 * 根据新增业务对象插入敏感词
	 *
	 * @param bo 敏感词新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiSensitiveAddBo bo);

	/**
	 * 根据编辑业务对象修改敏感词
	 *
	 * @param bo 敏感词编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiSensitiveEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
