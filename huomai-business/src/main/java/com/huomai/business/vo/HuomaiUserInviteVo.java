package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 邀请记录视图对象 huomai_user_invite
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("邀请记录视图对象")
public class HuomaiUserInviteVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 邀请人ID
	 */
	@Excel(name = "邀请人ID")
	@ApiModelProperty("邀请人ID")
	private Long userId;
	@ApiModelProperty("邀请人昵称")
	private String userNickName;
	@ApiModelProperty("邀请人头像")
	private String userAvatar;

	/**
	 * 被邀请人ID
	 */
	@Excel(name = "被邀请人ID")
	@ApiModelProperty("被邀请人ID")
	private Long byUserId;
	@ApiModelProperty("被邀请人昵称")
	private String byUserNickName;
	@ApiModelProperty("被邀请人头像")
	private String byUserAvatar;

	/**
	 * 邀请金额
	 */
	@Excel(name = "邀请金额")
	@ApiModelProperty("邀请金额")
	private BigDecimal money;


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("邀请时间")
	private Date createTime;


}
