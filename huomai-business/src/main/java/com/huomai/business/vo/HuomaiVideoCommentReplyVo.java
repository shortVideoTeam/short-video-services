package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 回复视图对象 huomai_video_comment_reply
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("回复视图对象")
public class HuomaiVideoCommentReplyVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty("主键")
	private Long id;

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

	@ApiModelProperty("回复用户昵称")
	private String replyUserNickName;

	@ApiModelProperty("回复用户头像")
	private String replyUserAvatar;

	/**
	 * 目标用户id
	 */
	@ApiModelProperty("目标用户id")
	private Long toUserId;

	@ApiModelProperty("目标用户昵称")
	private String toUserNickName;

	@ApiModelProperty("目标用户头像")
	private String toUserAvatar;

	/**
	 * 点赞数
	 */
	@ApiModelProperty("点赞数")
	private long star;

	@ApiModelProperty("点赞标识，0-未点赞，1-已点赞")
	private int starFlag;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date createTime;


}
