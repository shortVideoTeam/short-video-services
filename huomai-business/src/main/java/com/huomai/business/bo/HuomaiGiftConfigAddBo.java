package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 红包金额配置添加对象 huomai_gift_config
 *
 * @author huomai
 * @date 2021-07-18
 */
@Data
@ApiModel("红包金额配置添加对象")
public class HuomaiGiftConfigAddBo {


	/**
	 * 总金额
	 */
	@ApiModelProperty("总金额")
	private BigDecimal totalAmount;

	/**
	 * 单笔领取金额
	 */
	@ApiModelProperty("单笔领取金额")
	private BigDecimal singleAmount;
}
