package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 敏感词编辑对象 huomai_sensitive
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("敏感词编辑对象")
public class HuomaiSensitiveEditBo {


	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 内容
	 */
	@ApiModelProperty("内容")
	@NotBlank(message = "内容不能为空")
	private String content;
}
