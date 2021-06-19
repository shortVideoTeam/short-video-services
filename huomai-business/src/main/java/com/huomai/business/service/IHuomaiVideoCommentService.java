package com.huomai.business.service;

import com.huomai.business.bo.HuomaiVideoCommentAddBo;
import com.huomai.business.bo.HuomaiVideoCommentEditBo;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.domain.HuomaiVideoComment;
import com.huomai.business.vo.HuomaiVideoCommentVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 评论Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiVideoCommentService extends IServicePlus<HuomaiVideoComment> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiVideoCommentVo queryById(Long commentId);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiVideoCommentVo> queryPageList(HuomaiVideoCommentQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiVideoCommentVo> queryList(HuomaiVideoCommentQueryBo bo);

	/**
	 * 根据新增业务对象插入评论
	 *
	 * @param bo 评论新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiVideoCommentAddBo bo);

	/**
	 * 根据编辑业务对象修改评论
	 *
	 * @param bo 评论编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiVideoCommentEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
