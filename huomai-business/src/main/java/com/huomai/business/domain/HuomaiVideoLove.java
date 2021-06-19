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
 * 点赞记录对象 huomai_video_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_video_love")
public class HuomaiVideoLove implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 视频ID
	 */
	private Long videoId;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 点赞时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
