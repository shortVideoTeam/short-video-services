package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


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

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "创建时间不能为空")
	private Date createTime;
}
