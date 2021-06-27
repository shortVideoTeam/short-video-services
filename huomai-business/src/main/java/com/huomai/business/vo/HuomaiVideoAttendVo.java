package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 视频信息视图对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("关注视频信息视图对象")
public class HuomaiVideoAttendVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	private Long userId;

	/**
	 * 用户头像
	 */
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户昵称
	 */
	@ApiModelProperty("用户昵称")
	private String nickName;

	/**
	 * 视频标题
	 */
	@ApiModelProperty("视频标题")
	private String title;

	/**
	 * 视频地址
	 */
	@ApiModelProperty("视频地址")
	private String videoUrl;

	/**
	 * 视频时长
	 */
	@ApiModelProperty("视频时长")
	private long duration;


	/**
	 * 播放量
	 */
	@ApiModelProperty("播放量")
	private long viewNum;
}
