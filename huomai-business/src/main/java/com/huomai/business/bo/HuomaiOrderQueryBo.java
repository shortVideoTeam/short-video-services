package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单记录分页查询对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("订单记录分页查询对象")
public class HuomaiOrderQueryBo extends BaseEntity {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/**
	 * 排序列
	 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/**
	 * 排序的方向desc或者asc
	 */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


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
	 * 推荐页面，1-热门页
	 */
	@ApiModelProperty("推荐页面，1-热门页")
	private String page;
	/**
	 * 金额
	 */
	@ApiModelProperty("金额")
	private BigDecimal amount;
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

}
