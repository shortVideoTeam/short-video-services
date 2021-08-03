package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 推广记录分页查询对象 huomai_user_promote
 *
 * @author huomai
 * @date 2021-07-06
 */
@Data
@ApiModel("推广记录分页查询对象")
public class HuomaiUserPromoteQueryBo implements Serializable {

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

	@ApiModelProperty(value = "查询类型，1-发出的，2-收到的")
	private Integer optType;

	@ApiModelProperty(hidden = true)
	private Long userId;


}
