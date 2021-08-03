package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复对象 huomai_video_comment_reply
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_video_comment_reply")
public class HuomaiVideoCommentReply implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 回复类型 (1 : 评论的回复 2 : 回复的回复)
	 */
	private String replyType;

	/**
	 * 评论Id
	 */
	private Long commentId;

	/**
	 * 回复目标ID
	 */
	private Long replyId;

	/**
	 * 回复内容
	 */
	private String content;

	/**
	 * 回复用户ID
	 */
	private Long replyUserId;

	/**
	 * 目标用户id
	 */
	private Long toUserId;

	/**
	 * 点赞数
	 */
	private Long star;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
