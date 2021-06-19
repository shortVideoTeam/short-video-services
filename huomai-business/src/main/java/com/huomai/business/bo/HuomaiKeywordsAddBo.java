package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * 关键词添加对象 huomai_keywords
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("关键词添加对象")
public class HuomaiKeywordsAddBo {


	/**
	 * 关键词
	 */
	@ApiModelProperty("关键词")
	@NotBlank(message = "关键词不能为空")
	private String keyword;

	/**
	 * 命中词 (按","逗号拼接)
	 */
	@ApiModelProperty("命中词 (按逗号拼接)")
	@NotBlank(message = "命中词 (按逗号拼接)不能为空")
	private String hitword;
}
