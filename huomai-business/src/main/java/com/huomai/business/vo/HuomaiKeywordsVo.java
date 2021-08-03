package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 关键词视图对象 huomai_keywords
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("关键词视图对象")
public class HuomaiKeywordsVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty("主键")
	private Long keywordId;

	/**
	 * 关键词
	 */
	@Excel(name = "关键词")
	@ApiModelProperty("关键词")
	private String keyword;

	/**
	 * 命中词 (按","逗号拼接)
	 */
	@Excel(name = "命中词 (按逗号拼接)")
	@ApiModelProperty("命中词 (按逗号拼接)")
	private String hitword;


}
