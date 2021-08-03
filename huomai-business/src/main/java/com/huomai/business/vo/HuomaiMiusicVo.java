package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 音乐模板视图对象 huomai_miusic
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("音乐模板视图对象")
public class HuomaiMiusicVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 标题
	 */
	@Excel(name = "标题")
	@ApiModelProperty("标题")
	private String title;

	/**
	 * 封面图
	 */
	@Excel(name = "封面图")
	@ApiModelProperty("封面图")
	private String coverImg;

	/**
	 * 音乐地址
	 */
	@Excel(name = "音乐地址")
	@ApiModelProperty("音乐地址")
	private String miusicUrl;

	/**
	 * 备注
	 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;


}
