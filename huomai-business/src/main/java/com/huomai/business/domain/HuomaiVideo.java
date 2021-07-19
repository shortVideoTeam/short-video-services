package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频信息对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_video")
public class HuomaiVideo implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 视频ID
	 */
	@TableId(value = "video_id")
	private Long videoId;

	/**
	 * 用户Id
	 */
	private Long userId;

	/**
	 * 视频标题
	 */
	private String title;

	/**
	 * 视频地址
	 */
	private String videoUrl;

	private String coverUrl;

	/**
	 * 视频时长
	 */
	private Long duration;

	/**
	 * 关联话题 (按","逗号拼接)
	 */
	private String topic;

	/**
	 * 关联好友 (按","逗号拼接)
	 */
	private String buddy;

	/**
	 * 是否可见 (1 公开 0 私密)
	 */
	private String visible;

	/**
	 * 状态( 0 草稿 1: 审核通过 2: 审核不通过 3: 删除 )
	 */
	private String status;

	/**
	 * 点赞量
	 */
	private Integer starNum;

	/**
	 * 评论量
	 */
	private Integer commentNum;

	/**
	 * 播放量
	 */
	private Integer viewNum;

	/**
	 * 分享量
	 */
	private Integer shareNum;

	/**
	 * 关键词ID (按","逗号拼接)
	 */
	private String keywordId;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	/**
	 * 更新者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	/**
	 * 备注
	 */
	private String remark;

}
