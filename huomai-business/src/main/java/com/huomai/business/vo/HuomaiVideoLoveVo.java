package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 点赞记录视图对象 huomai_user_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("点赞记录视图对象")
public class HuomaiVideoLoveVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 视频ID
	 */
	@Excel(name = "视频ID")
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 用户ID
	 */
	@Excel(name = "用户ID")
	@ApiModelProperty("用户ID")
	private Long userId;


}
