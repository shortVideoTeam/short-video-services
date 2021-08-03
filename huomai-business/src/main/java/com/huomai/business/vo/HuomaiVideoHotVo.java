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
@ApiModel("热门视频信息视图对象")
public class HuomaiVideoHotVo {

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

	@ApiModelProperty("封面图")
	private String coverUrl;

	/**
	 * 视频时长
	 */
	@ApiModelProperty("视频时长")
	private long duration;

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
	 * 点赞量
	 */
	@ApiModelProperty("点赞量")
	private long starNum;

	/**
	 * 评论量
	 */
	@ApiModelProperty("评论量")
	private long commentNum;

	/**
	 * 播放量
	 */
	@ApiModelProperty("播放量")
	private long viewNum;

	/**
	 * 分享量
	 */
	@ApiModelProperty("分享量")
	private long shareNum;


	/**
	 * 我是否关注了ta
	 */
	@ApiModelProperty("我是否关注了ta 1-是 0-否")
	private int attendFlag;

	/**
	 * ta是否关注了我
	 */
	@ApiModelProperty("ta是否关注了我 1-是 0-否")
	private int followFlag;

	/**
	 * 是否已点赞
	 */
	@ApiModelProperty("是否已点赞,0-否，1-是")
	private int loveFlag;


}
