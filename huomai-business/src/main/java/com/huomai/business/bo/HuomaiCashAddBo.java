package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 订单记录添加对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("提现记录添加对象")
public class HuomaiCashAddBo {

	@ApiModelProperty("提现规则ID")
	@NotNull(message = "提现规则ID不能为空")
	private Long cashRuleId;

	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	@NotNull(message = "金额不能为空")
	private BigDecimal amount;

	private String domain;

}
