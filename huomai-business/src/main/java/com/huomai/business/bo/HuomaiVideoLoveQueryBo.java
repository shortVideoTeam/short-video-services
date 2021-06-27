package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 点赞记录分页查询对象 huomai_user_love
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("点赞记录分页查询对象")
public class HuomaiVideoLoveQueryBo extends PageBo {

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID|评论ID|回复ID")
	private Long businessId;

	//1- 视频 2-评论 3-回复
	@ApiModelProperty("类型：1- 视频 2-评论 3-回复")
	private Integer type;
	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private Long userId;

}
