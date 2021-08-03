package com.huomai.common.core.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页参数
 *
 * @author chenshufeng
 * @version 1.0
 * @date 2021/6/25 3:33 下午
 */
@Data
public class PageBo {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize = 5;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum = 1;
}
