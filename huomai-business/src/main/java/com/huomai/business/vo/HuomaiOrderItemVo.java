package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 订单记录项视图对象 huomai_order_item
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录项视图对象")
public class HuomaiOrderItemVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 订单号
	 */
	@Excel(name = "订单号")
	@ApiModelProperty("订单号")
	private String orderNo;

	/**
	 * 视频ID
	 */
	@Excel(name = "视频ID")
	@ApiModelProperty("视频ID")
	private Long videoId;


}
