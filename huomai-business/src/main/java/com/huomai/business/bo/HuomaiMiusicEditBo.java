package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 音乐模板编辑对象 huomai_miusic
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("音乐模板编辑对象")
public class HuomaiMiusicEditBo {


	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 标题
	 */
	@ApiModelProperty("标题")
	private String title;

	/**
	 * 封面图
	 */
	@ApiModelProperty("封面图")
	private String coverImg;

	/**
	 * 音乐地址
	 */
	@ApiModelProperty("音乐地址")
	private String miusicUrl;

	/**
	 * 更新者
	 */
	@ApiModelProperty("更新者")
	private String updateBy;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;
}
