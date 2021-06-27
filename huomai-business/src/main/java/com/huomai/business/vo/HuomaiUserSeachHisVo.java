package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 搜索历史记录视图对象 huomai_user_seach_his
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("搜索历史记录视图对象")
public class HuomaiUserSeachHisVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 * 搜索内容
	 */
	@ApiModelProperty("搜索内容")
	private String content;


}
