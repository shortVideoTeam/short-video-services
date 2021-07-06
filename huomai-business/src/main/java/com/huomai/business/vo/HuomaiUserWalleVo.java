package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;


/**
 * 用户信息视图对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("我的钱包视图对象")
public class HuomaiUserWalleVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	private Long userId;

	//总金额
	@ApiModelProperty("总金额")
	private BigDecimal totalAmount = BigDecimal.ZERO;
	//可提现金额
	@ApiModelProperty("可提现金额")
	private BigDecimal cashAmount = BigDecimal.ZERO;
}
