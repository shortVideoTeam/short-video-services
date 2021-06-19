package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 点赞记录分页查询对象 huomai_video_love
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("点赞记录分页查询对象")
public class HuomaiVideoLoveQueryBo extends BaseEntity {

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
	 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/**
	 * 排序的方向desc或者asc
	 */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


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
