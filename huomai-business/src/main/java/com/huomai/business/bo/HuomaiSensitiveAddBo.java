package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 敏感词添加对象 huomai_sensitive
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("敏感词添加对象")
public class HuomaiSensitiveAddBo {


	/**
	 * 内容
	 */
	@ApiModelProperty("内容")
	@NotBlank(message = "内容不能为空")
	private String content;
}
