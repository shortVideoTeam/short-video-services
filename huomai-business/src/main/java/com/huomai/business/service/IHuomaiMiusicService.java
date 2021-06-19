package com.huomai.business.service;

import com.huomai.business.bo.HuomaiMiusicAddBo;
import com.huomai.business.bo.HuomaiMiusicEditBo;
import com.huomai.business.bo.HuomaiMiusicQueryBo;
import com.huomai.business.domain.HuomaiMiusic;
import com.huomai.business.vo.HuomaiMiusicVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 音乐模板Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiMiusicService extends IServicePlus<HuomaiMiusic> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiMiusicVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiMiusicVo> queryPageList(HuomaiMiusicQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiMiusicVo> queryList(HuomaiMiusicQueryBo bo);

	/**
	 * 根据新增业务对象插入音乐模板
	 *
	 * @param bo 音乐模板新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiMiusicAddBo bo);

	/**
	 * 根据编辑业务对象修改音乐模板
	 *
	 * @param bo 音乐模板编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiMiusicEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
