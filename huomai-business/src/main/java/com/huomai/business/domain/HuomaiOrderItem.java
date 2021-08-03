package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单记录项对象 huomai_order_item
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@Accessors(chain = true)
@Builder
@TableName("huomai_order_item")
public class HuomaiOrderItem implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 视频ID
	 */
	private Long videoId;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
