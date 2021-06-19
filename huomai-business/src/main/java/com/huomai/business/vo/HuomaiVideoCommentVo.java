package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 评论视图对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("评论视图对象")
public class HuomaiVideoCommentVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 评论ID
	 */
	@ApiModelProperty("评论ID")
	private Long commentId;

	/**
	 * 视频ID
	 */
	@Excel(name = "视频ID")
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 评论内容
	 */
	@Excel(name = "评论内容")
	@ApiModelProperty("评论内容")
	private String content;

	/**
	 * 评论用户Id
	 */
	@Excel(name = "评论用户Id")
	@ApiModelProperty("评论用户Id")
	private Long userId;

	/**
	 * 评论点赞数
	 */
	@Excel(name = "评论点赞数")
	@ApiModelProperty("评论点赞数")
	private Long starNum;


}
