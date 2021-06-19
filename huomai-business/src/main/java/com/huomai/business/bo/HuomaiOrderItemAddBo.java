package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * 订单记录项添加对象 huomai_order_item
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录项添加对象")
public class HuomaiOrderItemAddBo {


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

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "创建时间不能为空")
	private Date createTime;
}
