package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 订单记录项编辑对象 huomai_order_item
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录项编辑对象")
public class HuomaiOrderItemEditBo {


	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 订单号
	 */
	@ApiModelProperty("订单号")
	@NotBlank(message = "订单号不能为空")
	private String orderNo;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;
}
