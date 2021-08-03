package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 回复添加对象 huomai_video_comment_reply
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("回复添加对象")
public class HuomaiVideoCommentReplyAddBo {


	/**
	 * 回复类型 (1 : 评论的回复 2 : 回复的回复)
	 */
	@ApiModelProperty("回复类型 (1 : 评论的回复 2 : 回复的回复)")
	@NotBlank(message = "回复类型 (1 : 评论的回复 2 : 回复的回复)不能为空")
	private String replyType;

	/**
	 * 评论Id
	 */
	@ApiModelProperty("评论Id")
	@NotNull(message = "评论Id不能为空")
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
	@NotBlank(message = "回复内容不能为空")
	private String content;

	/**
	 * 目标用户id
	 */
	@ApiModelProperty("目标用户id")
	private Long toUserId;

}
