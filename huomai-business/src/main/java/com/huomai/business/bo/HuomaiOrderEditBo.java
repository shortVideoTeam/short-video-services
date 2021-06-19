package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单记录编辑对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录编辑对象")
public class HuomaiOrderEditBo {


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
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	@NotNull(message = "用户ID不能为空")
	private Long userId;

	/**
	 * 推广时长
	 */
	@ApiModelProperty("推广时长")
	private Long time;

	/**
	 * 推荐页面，1-热门页
	 */
	@ApiModelProperty("推荐页面，1-热门页")
	private String page;

	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	@NotNull(message = "金额不能为空")
	private BigDecimal amount;

	/**
	 * 支付时间
	 */
	@ApiModelProperty("支付时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date payTime;

	/**
	 * 状态，1-待付款 2-已付款
	 */
	@ApiModelProperty("状态，1-待付款 2-已付款")
	private String status;

	/**
	 * 支付方式 1-微信 2-余额
	 */
	@ApiModelProperty("支付方式 1-微信 2-余额")
	private String payWay;
}
