package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_video_comment")
public class HuomaiVideoComment implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 评论ID
	 */
	@TableId(value = "comment_id")
	private Long commentId;

	/**
	 * 视频ID
	 */
	private Long videoId;

	/**
	 * 评论内容
	 */
	private String content;

	/**
	 * 评论用户Id
	 */
	private Long userId;

	/**
	 * 评论点赞数
	 */
	private Long starNum;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
