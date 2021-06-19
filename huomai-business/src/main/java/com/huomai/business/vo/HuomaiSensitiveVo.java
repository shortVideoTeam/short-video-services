package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 敏感词视图对象 huomai_sensitive
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("敏感词视图对象")
public class HuomaiSensitiveVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 内容
	 */
	@Excel(name = "内容")
	@ApiModelProperty("内容")
	private String content;


}
