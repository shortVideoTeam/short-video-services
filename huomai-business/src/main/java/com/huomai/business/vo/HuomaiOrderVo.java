package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单记录视图对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录视图对象")
public class HuomaiOrderVo {

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
	 * 用户ID
	 */
	@Excel(name = "用户ID")
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 * 推广时长
	 */
	@Excel(name = "推广时长")
	@ApiModelProperty("推广时长")
	private Long time;

	/**
	 * 推荐页面，1-热门页
	 */
	@Excel(name = "推荐页面，1-热门页")
	@ApiModelProperty("推荐页面，1-热门页")
	private String page;

	/**
	 * 金额
	 */
	@Excel(name = "金额")
	@ApiModelProperty("金额")
	private BigDecimal amount;

	/**
	 * 支付时间
	 */
	@Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("支付时间")
	private Date payTime;

	/**
	 * 状态，1-待付款 2-已付款
	 */
	@Excel(name = "状态，1-待付款 2-已付款")
	@ApiModelProperty("状态，1-待付款 2-已付款")
	private String status;

	/**
	 * 支付方式 1-微信 2-余额
	 */
	@Excel(name = "支付方式 1-微信 2-余额")
	@ApiModelProperty("支付方式 1-微信 2-余额")
	private String payWay;


}
