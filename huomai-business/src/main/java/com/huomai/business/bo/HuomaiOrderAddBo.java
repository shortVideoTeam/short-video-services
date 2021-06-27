package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单记录添加对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("订单记录添加对象")
public class HuomaiOrderAddBo {

	/**
	 * 推广时长
	 */
	@ApiModelProperty("推广时长")
	@NotNull(message = "推广时长不能为空")
	private Long time;

	/**
	 * 推荐页面，1-热门页
	 */
	@ApiModelProperty("推荐页面，1-热门页")
	@NotBlank(message = "推荐页面不能为空")
	private String page;

	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	@NotNull(message = "金额不能为空")
	private BigDecimal amount;

	/**
	 * 支付方式 1-微信 2-余额
	 */
	@ApiModelProperty("支付方式 1-微信 2-余额")
	@NotBlank(message = "支付方式不能为空")
	private String payWay;

	@ApiModelProperty("推广作品列表")
	private List<Long> videoList;

	//服务器域名
	private String domain;

}
