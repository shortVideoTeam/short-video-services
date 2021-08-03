package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 评论编辑对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("评论编辑对象")
public class HuomaiVideoCommentEditBo {


	/**
	 * 评论ID
	 */
	@ApiModelProperty("评论ID")
	private Long commentId;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	@NotNull(message = "视频ID不能为空")
	private Long videoId;

	/**
	 * 评论内容
	 */
	@ApiModelProperty("评论内容")
	@NotBlank(message = "评论内容不能为空")
	private String content;

	/**
	 * 评论用户Id
	 */
	@ApiModelProperty("评论用户Id")
	@NotNull(message = "评论用户Id不能为空")
	private Long userId;

	/**
	 * 评论点赞数
	 */
	@ApiModelProperty("评论点赞数")
	private Long starNum;
}
