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
 * 用户关注对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_follow")
public class HuomaiUserFollow implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 用户id
	 */
	@TableId(value = "user_id")
	private Long userId;

	/**
	 * 关注用户id
	 */
	private Long followUserId;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 备注
	 */
	private String remark;

}
