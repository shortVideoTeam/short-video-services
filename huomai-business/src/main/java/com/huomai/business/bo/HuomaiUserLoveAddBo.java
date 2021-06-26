package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 点赞记录添加对象 huomai_user_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("点赞记录添加对象")
public class HuomaiUserLoveAddBo {


	/**
	 * 视频ID/评论ID/回复ID
	 */
	@ApiModelProperty("视频ID/评论ID/回复ID")
	@NotNull(message = "businessId不能为空")
	private Long businessId;

	//1- 视频 2-评论 3-回复
	@ApiModelProperty("类型：1- 视频 2-评论 3-回复")
	@NotNull(message = "类型不能为空")
	private Integer type;

}
