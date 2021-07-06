package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 订单记录添加对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("充值记录添加对象")
public class HuomaiRechargeAddBo {

	@ApiModelProperty("充值规则ID")
	@NotNull(message = "充值规则ID不能为空")
	private Long rechargeRuleId;

	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	@NotNull(message = "金额不能为空")
	private BigDecimal amount;

	/**
	 * 支付方式 1-微信 2-余额
	 */
	@ApiModelProperty("支付方式 1-微信")
	@NotBlank(message = "支付方式不能为空")
	private String payWay;

	//服务器域名
	@ApiModelProperty(value = "服务器域名", hidden = true)
	private String domain;

}
