package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 邀请记录对象 huomai_user_invite
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_invite")
public class HuomaiUserInvite implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 邀请人ID
	 */
	private Long userId;

	/**
	 * 被邀请人ID
	 */
	private Long byUserId;

	/**
	 * 邀请金额
	 */
	private BigDecimal money;

	/**
	 * 邀请码
	 */
	private String inviteCode;

	/**
	 * 邀请时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
