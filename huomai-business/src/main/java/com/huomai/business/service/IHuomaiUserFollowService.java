package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserFollowAddBo;
import com.huomai.business.bo.HuomaiUserFollowEditBo;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.domain.HuomaiUserFollow;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 用户关注Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiUserFollowService extends IServicePlus<HuomaiUserFollow> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiUserFollowVo queryById(Long userId);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiUserFollowVo> queryPageList(HuomaiUserFollowQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiUserFollowVo> queryList(HuomaiUserFollowQueryBo bo);

	/**
	 * 根据新增业务对象插入用户关注
	 *
	 * @param bo 用户关注新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiUserFollowAddBo bo);

	/**
	 * 根据编辑业务对象修改用户关注
	 *
	 * @param bo 用户关注编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiUserFollowEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
