package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 用户关注编辑对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户关注编辑对象")
public class HuomaiUserFollowEditBo {


	/**
	 * 用户id
	 */
	@ApiModelProperty("用户id")
	private Long userId;

	/**
	 * 关注用户id
	 */
	@ApiModelProperty("关注用户id")
	@NotNull(message = "关注用户id不能为空")
	private Long followUserId;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;
}
