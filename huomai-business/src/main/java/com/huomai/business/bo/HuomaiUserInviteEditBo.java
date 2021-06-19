package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 邀请记录编辑对象 huomai_user_invite
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("邀请记录编辑对象")
public class HuomaiUserInviteEditBo {


	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 邀请人ID
	 */
	@ApiModelProperty("邀请人ID")
	private Long userId;

	/**
	 * 被邀请人ID
	 */
	@ApiModelProperty("被邀请人ID")
	private Long byUserId;

	/**
	 * 邀请金额
	 */
	@ApiModelProperty("邀请金额")
	private BigDecimal money;

	/**
	 * 邀请码
	 */
	@ApiModelProperty("邀请码")
	private String inviteCode;
}
