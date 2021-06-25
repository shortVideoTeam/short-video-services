package com.huomai.business.service;

import com.huomai.business.bo.HuomaiVideoAddBo;
import com.huomai.business.bo.HuomaiVideoEditBo;
import com.huomai.business.bo.HuomaiVideoHotBo;
import com.huomai.business.bo.HuomaiVideoQueryBo;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.vo.HuomaiVideoHotVo;
import com.huomai.business.vo.HuomaiVideoVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 视频信息Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiVideoService extends IServicePlus<HuomaiVideo> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiVideoVo queryById(Long videoId);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiVideoVo> queryPageList(HuomaiVideoQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiVideoVo> queryList(HuomaiVideoQueryBo bo);

	/**
	 * 根据新增业务对象插入视频信息
	 *
	 * @param bo 视频信息新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiVideoAddBo bo);

	/**
	 * 根据编辑业务对象修改视频信息
	 *
	 * @param bo 视频信息编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiVideoEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

	/***
	* @description: 热门
	* @author chenshufeng
	* @date: 2021/6/25 3:38 下午
	*/
	TableDataInfo<HuomaiVideoHotVo> hotList(HuomaiVideoHotBo bo);
}
