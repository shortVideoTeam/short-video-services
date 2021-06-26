package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
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
@ApiModel("视频信息视图对象")
public class HuomaiVideoVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 用户Id
	 */
	@Excel(name = "用户Id")
	@ApiModelProperty("用户Id")
	private Long userId;

	/**
	 * 视频标题
	 */
	@Excel(name = "视频标题")
	@ApiModelProperty("视频标题")
	private String title;

	/**
	 * 视频地址
	 */
	@Excel(name = "视频地址")
	@ApiModelProperty("视频地址")
	private String videoUrl;

	/**
	 * 视频时长
	 */
	@Excel(name = "视频时长")
	@ApiModelProperty("视频时长")
	private Long duration;

	/**
	 * 关联话题 (按","逗号拼接)
	 */
	@Excel(name = "关联话题 (按逗号拼接)")
	@ApiModelProperty("关联话题 (按逗号拼接)")
	private String topic;

	/**
	 * 关联好友 (按","逗号拼接)
	 */
	@Excel(name = "关联好友 (按逗号拼接)")
	@ApiModelProperty("关联好友 (按逗号拼接)")
	private String buddy;


	/**
	 * 点赞量
	 */
	@ApiModelProperty("点赞量")
	private Long starNum;

	/**
	 * 评论量
	 */
	@ApiModelProperty("评论量")
	private Long commentNum;

	/**
	 * 播放量
	 */
	@ApiModelProperty("播放量")
	private Long viewNum;

	/**
	 * 关键词ID (按","逗号拼接)
	 */
	@ApiModelProperty("关键词ID (按逗号拼接)")
	private String keywordId;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;


}
