package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 用户关注添加对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户关注添加对象")
public class HuomaiUserFollowAddBo {

	/**
	 * 关注用户id
	 */
	@ApiModelProperty("关注用户id")
	@NotNull(message = "关注用户id不能为空")
	private Long followUserId;

	//来源，1-搜索2-粉丝3-消息4-可能认识的人
	@ApiModelProperty("来源，1-搜索2-粉丝3-消息4-可能认识的人")
	@NotNull(message = "来源不能为空")
	private Integer source;

}
