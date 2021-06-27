package com.huomai.business.service;

import com.huomai.business.bo.HuomaiVideoCommentReplyAddBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyEditBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.domain.HuomaiVideoCommentReply;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 回复Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiVideoCommentReplyService extends IServicePlus<HuomaiVideoCommentReply> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiVideoCommentReplyVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiVideoCommentReplyVo> queryPageList(HuomaiVideoCommentReplyQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiVideoCommentReplyVo> queryList(HuomaiVideoCommentReplyQueryBo bo);

	/**
	 * 根据新增业务对象插入回复
	 *
	 * @param bo 回复新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiVideoCommentReplyAddBo bo);

	/**
	 * 根据编辑业务对象修改回复
	 *
	 * @param bo 回复编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiVideoCommentReplyEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

	/***
	 * @description: 批量查询评论下面的回复列表
	 * @author chenshufeng
	 * @date: 2021/6/26 3:06 下午
	 */
	Map<Long, List<HuomaiVideoCommentReplyVo>> batchQueryReplyListByCommentIds(List<Long> cIdList);
}
