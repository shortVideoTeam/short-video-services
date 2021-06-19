package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * 视频信息添加对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("视频信息添加对象")
public class HuomaiVideoAddBo {


	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	@NotNull(message = "用户Id不能为空")
	private Long userId;

	/**
	 * 视频标题
	 */
	@ApiModelProperty("视频标题")
	@NotBlank(message = "视频标题不能为空")
	private String title;

	/**
	 * 视频地址
	 */
	@ApiModelProperty("视频地址")
	@NotBlank(message = "视频地址不能为空")
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
	@NotBlank(message = "是否可见 (1 公开 0 私密)不能为空")
	private String visible;

	/**
	 * 状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )
	 */
	@ApiModelProperty("状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )")
	@NotBlank(message = "状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )不能为空")
	private String status;

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
	@NotBlank(message = "关键词ID (按逗号拼接)不能为空")
	private String keywordId;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 创建者
	 */
	@ApiModelProperty("创建者")
	private String createBy;

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
