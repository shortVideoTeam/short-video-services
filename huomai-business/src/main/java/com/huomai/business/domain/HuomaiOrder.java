package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单记录对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_order")
public class HuomaiOrder implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 推广时长
	 */
	private Long time;

	/**
	 * 推荐页面，1-热门页
	 */
	private String page;

	/**
	 * 金额
	 */
	private BigDecimal amount;

	/**
	 * 支付时间
	 */
	private Date payTime;

	/**
	 * 状态，1-待付款 2-已付款
	 */
	private String status;

	/**
	 * 支付方式 1-微信 2-余额
	 */
	private String payWay;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
