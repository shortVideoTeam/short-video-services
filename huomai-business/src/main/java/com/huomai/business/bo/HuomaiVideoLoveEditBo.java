package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 点赞记录编辑对象 huomai_video_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("点赞记录编辑对象")
public class HuomaiVideoLoveEditBo {


	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private Long userId;
}
