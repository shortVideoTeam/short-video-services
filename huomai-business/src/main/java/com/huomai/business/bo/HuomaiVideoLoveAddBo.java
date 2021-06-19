package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 点赞记录添加对象 huomai_video_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("点赞记录添加对象")
public class HuomaiVideoLoveAddBo {


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

	/**
	 * 点赞时间
	 */
	@ApiModelProperty("点赞时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
}
