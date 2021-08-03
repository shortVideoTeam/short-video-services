package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 评论添加对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("评论添加对象")
public class HuomaiVideoCommentAddBo {


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
}
