package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	//订单类型 1-购买 2-充值 3-提现 4-收益
	@ApiModelProperty("订单类型 1-购买 2-充值 3-提现 4-收益")
	private Integer orderType;

	/**
	 * 订单号
	 */
	@ApiModelProperty("订单号")
	private String orderNo;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 * 推广时长
	 */
	@ApiModelProperty("推广时长")
	private Long time;

	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	private BigDecimal amount;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("创建时间")
	private Date createTime;

	/**
	 * 支付时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("支付时间")
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

	/**
	 * 用户火脉号Id
	 */
	@ApiModelProperty("用户火脉号Id")
	private String uuid;

	/**
	 * 用户头像
	 */
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户昵称
	 */
	@ApiModelProperty("用户昵称")
	private String nickName;

}
