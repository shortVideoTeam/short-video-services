package com.huomai.business.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * huomai_recharge_rule
 *
 * @author
 */
@Data
public class HuomaiCashRule implements Serializable {
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 金额
	 */
	private BigDecimal amount;

	//是否首次标识 0-否 1-是
	private Integer firstFlag;
	//每天可提标识 0-否 1-是
	private Integer dayFlag;

	private static final long serialVersionUID = 1L;
}
