package com.huomai.business.service;

import com.huomai.business.bo.HuomaiKeywordsAddBo;
import com.huomai.business.bo.HuomaiKeywordsEditBo;
import com.huomai.business.bo.HuomaiKeywordsQueryBo;
import com.huomai.business.domain.HuomaiKeywords;
import com.huomai.business.vo.HuomaiKeywordsVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 关键词Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiKeywordsService extends IServicePlus<HuomaiKeywords> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiKeywordsVo queryById(Long keywordId);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiKeywordsVo> queryPageList(HuomaiKeywordsQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiKeywordsVo> queryList(HuomaiKeywordsQueryBo bo);

	/**
	 * 根据新增业务对象插入关键词
	 *
	 * @param bo 关键词新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiKeywordsAddBo bo);

	/**
	 * 根据编辑业务对象修改关键词
	 *
	 * @param bo 关键词编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiKeywordsEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
