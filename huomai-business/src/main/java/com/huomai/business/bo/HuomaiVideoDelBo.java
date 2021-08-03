package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 视频信息编辑对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("视频信息删除对象")
public class HuomaiVideoDelBo {


	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	@NotNull(message = "视频ID不能为空")
	private Long videoId;

}
