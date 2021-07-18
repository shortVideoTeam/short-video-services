package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserLoveAddBo;
import com.huomai.business.bo.HuomaiVideoLoveEditBo;
import com.huomai.business.bo.HuomaiVideoLoveQueryBo;
import com.huomai.business.domain.HuomaiUserLove;
import com.huomai.business.vo.HuomaiVideoLoveVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 点赞记录Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiUserLoveService extends IServicePlus<HuomaiUserLove> {

	/**
	 * 根据新增业务对象插入点赞记录
	 *
	 * @param bo 点赞记录新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiUserLoveAddBo bo);


	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
