package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserFollowAddBo;
import com.huomai.business.bo.HuomaiUserFollowEditBo;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.domain.HuomaiUserFollow;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.business.vo.HuomaiUserVo;
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

	/***
	* @description: 关注列表
	* @author chenshufeng
	* @date: 2021/6/26 4:48 下午
	*/
	TableDataInfo<HuomaiUserFollowVo> attendList(HuomaiUserFollowQueryBo bo);

	/***
	* @description: 粉丝列表
	* @author chenshufeng
	* @date: 2021/6/26 5:10 下午
	*/
	TableDataInfo<HuomaiUserFollowVo> followMeList(HuomaiUserFollowQueryBo bo);

	/***
	* @description: 我的好友列表
	* @author chenshufeng
	* @date: 2021/6/26 5:57 下午
	*/
	TableDataInfo<HuomaiUserFollowVo> friendsList(HuomaiUserFollowQueryBo bo);
}
