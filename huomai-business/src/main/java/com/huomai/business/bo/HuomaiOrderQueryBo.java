package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单记录分页查询对象 huomai_order
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("订单记录分页查询对象")
public class HuomaiOrderQueryBo extends PageBo {

	//订单类型 1-购买 2-充值 3-提现 4-收益
	@ApiModelProperty("订单类型 1-购买 2-充值 3-提现 4-收益")
	private Integer orderType;

	private Long curUserId;

}
