package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 钱包明细编辑对象 huomai_user_walle
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("钱包明细编辑对象")
public class HuomaiUserWalleEditBo {


	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;
}
