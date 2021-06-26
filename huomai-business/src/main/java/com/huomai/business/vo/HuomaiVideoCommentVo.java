package com.huomai.business.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;


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
	@TableId(type = IdType.AUTO)
	private Long commentId;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 评论内容
	 */
	@ApiModelProperty("评论内容")
	private String content;

	/**
	 * 评论用户Id
	 */
	@ApiModelProperty("评论用户Id")
	private Long userId;

	/**
	 * 评论点赞数
	 */
	@ApiModelProperty("评论点赞数")
	private Long starNum;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	@ApiModelProperty("回复列表")
	private List<HuomaiVideoCommentReplyVo> replyVoList;


}
