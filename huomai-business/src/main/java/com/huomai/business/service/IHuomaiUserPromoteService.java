package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.domain.HuomaiUserPromote;
import com.huomai.business.vo.HuomaiUserPromoteVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.List;

/**
 * 推广记录Service接口
 *
 * @author huomai
 * @date 2021-07-06
 */
public interface IHuomaiUserPromoteService extends IServicePlus<HuomaiUserPromote> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiUserPromoteVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiUserPromoteVo> queryPageList(HuomaiUserPromoteQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiUserPromoteVo> queryList(HuomaiUserPromoteQueryBo bo);

}
