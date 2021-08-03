package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * huomai_recharge_rule
 *
 * @author
 */
@Data
@Builder
@ApiModel("金额配置视图对象")
public class HuomaiMoneyRuleVo implements Serializable {
	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;
	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	private BigDecimal amount;
	@ApiModelProperty("是否首次标识 0-否 1-是")
	private int firstFlag;
	@ApiModelProperty("每天可提标识 0-否 1-是")
	private int dayFlag;

	private static final long serialVersionUID = 1L;
}
