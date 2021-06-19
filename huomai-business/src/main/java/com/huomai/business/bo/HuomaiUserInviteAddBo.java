package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 邀请记录添加对象 huomai_user_invite
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("邀请记录添加对象")
public class HuomaiUserInviteAddBo {


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

	/**
	 * 邀请时间
	 */
	@ApiModelProperty("邀请时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
}
