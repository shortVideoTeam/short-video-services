package com.huomai.business.bo;

import com.huomai.business.domain.HuomaiGiftConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 红包金额配置添加对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-07-18
 */
@Data
@ApiModel("分红包")
public class HuomaiSplitGiftBo {


	/**
	 * 邀请码
	 */
	@ApiModelProperty("邀请码")
	@NotBlank(message = "邀请码不能为空")
	private String inviteCode;

	@ApiModelProperty(value = "邀请用户ID", hidden = true)
	private Long userId;
	@ApiModelProperty(value = "被邀请用户ID", hidden = true)
	private Long userIdBy;
	@ApiModelProperty(value = "金额", hidden = true)
	private Double money;
	@ApiModelProperty(value = "红包配置", hidden = true)
	private HuomaiGiftConfig config;

}
