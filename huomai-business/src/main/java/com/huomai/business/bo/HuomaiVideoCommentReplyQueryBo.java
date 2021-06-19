package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 回复分页查询对象 huomai_video_comment_reply
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("回复分页查询对象")
public class HuomaiVideoCommentReplyQueryBo extends BaseEntity {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/**
	 * 排序列
	 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/**
	 * 排序的方向desc或者asc
	 */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


	/**
	 * 回复类型 (1 : 评论的回复 2 : 回复的回复)
	 */
	@ApiModelProperty("回复类型 (1 : 评论的回复 2 : 回复的回复)")
	private String replyType;
	/**
	 * 评论Id
	 */
	@ApiModelProperty("评论Id")
	private Long commentId;
	/**
	 * 回复目标ID
	 */
	@ApiModelProperty("回复目标ID")
	private Long replyId;
	/**
	 * 回复内容
	 */
	@ApiModelProperty("回复内容")
	private String content;
	/**
	 * 回复用户ID
	 */
	@ApiModelProperty("回复用户ID")
	private Long replyUserId;
	/**
	 * 目标用户id
	 */
	@ApiModelProperty("目标用户id")
	private Long toUserId;
	/**
	 * 点赞数
	 */
	@ApiModelProperty("点赞数")
	private Long star;

}
