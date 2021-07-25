package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 视频信息编辑对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("视频信息编辑对象")
public class HuomaiVideoEditBo {


	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	@NotNull(message = "视频ID不能为空")
	private Long videoId;


	/**
	 * 视频标题
	 */
	@ApiModelProperty("视频标题")
//	@NotBlank(message = "视频标题不能为空")
	private String title;

	/**
	 * 视频地址
	 */
	@ApiModelProperty("视频地址")
//	@NotBlank(message = "视频地址不能为空")
	private String videoUrl;

	/**
	 * 视频时长
	 */
	@ApiModelProperty("视频时长")
	private Long duration;

	/**
	 * 关联话题 (按","逗号拼接)
	 */
	@ApiModelProperty("关联话题 (按逗号拼接)")
	private String topic;

	/**
	 * 关联好友 (按","逗号拼接)
	 */
	@ApiModelProperty("关联好友 (按逗号拼接)")
	private String buddy;

	/**
	 * 是否可见 (1 公开 0 私密)
	 */
	@ApiModelProperty("是否可见 (1 公开 0 私密)")
//	@NotBlank(message = "是否可见 (1 公开 0 私密)不能为空")
	private String visible;


	/**
	 * 关键词ID (按","逗号拼接)
	 */
	@ApiModelProperty("关键词ID (按逗号拼接)")
//	@NotBlank(message = "关键词ID (按逗号拼接)不能为空")
	private String keywordId;
}
