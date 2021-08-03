package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 点赞记录对象 huomai_user_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_love")
public class HuomaiUserLove implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 视频ID/评论ID/回复ID
	 */
	private Long businessId;

	//1- 视频 2-评论 3-回复
	private Integer type;

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
