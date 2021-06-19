package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 钱包明细视图对象 huomai_user_walle
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("钱包明细视图对象")
public class HuomaiUserWalleVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;


}
