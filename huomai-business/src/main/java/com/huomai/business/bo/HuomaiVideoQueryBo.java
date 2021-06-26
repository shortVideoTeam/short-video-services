package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视频信息分页查询对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("视频信息分页查询对象")
public class HuomaiVideoQueryBo extends BaseEntity {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/**
	 * 排序列
	 *//*
	@ApiModelProperty("排序列")
	private String orderByColumn;
	*//**
	 * 排序的方向desc或者asc
	 *//*
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


	*//**
	 * 用户Id
	 *//*
	@ApiModelProperty("用户Id")
	private Long userId;
	*//**
	 * 视频标题
	 *//*
	@ApiModelProperty("视频标题")
	private String title;
	*//**
	 * 视频地址
	 *//*
	@ApiModelProperty("视频地址")
	private String videoUrl;
	*//**
	 * 视频时长
	 *//*
	@ApiModelProperty("视频时长")
	private Long duration;
	*//**
	 * 关联话题 (按","逗号拼接)
	 *//*
	@ApiModelProperty("关联话题 (按逗号拼接)")
	private String topic;
	*//**
	 * 关联好友 (按","逗号拼接)
	 *//*
	@ApiModelProperty("关联好友 (按逗号拼接)")
	private String buddy;
	*//**
	 * 是否可见 (1 公开 0 私密)
	 *//*
	@ApiModelProperty("是否可见 (1 公开 0 私密)")
	private String visible;
	*//**
	 * 状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )
	 *//*
	@ApiModelProperty("状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )")
	private String status;
	*//**
	 * 点赞量
	 *//*
	@ApiModelProperty("点赞量")
	private Long starNum;
	*//**
	 * 评论量
	 *//*
	@ApiModelProperty("评论量")
	private Long commentNum;
	*//**
	 * 播放量
	 *//*
	@ApiModelProperty("播放量")
	private Long viewNum;
	*//**
	 * 关键词ID (按","逗号拼接)
	 *//*
	@ApiModelProperty("关键词ID (按逗号拼接)")
	private String keywordId;*/

}
