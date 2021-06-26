package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户信息视图对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户信息视图对象")
public class HuomaiUserVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户Id
	 */
	@ApiModelProperty("用户Id")
	private Long userId;

	/**
	 * 用户火脉号Id
	 */
	@ApiModelProperty("用户火脉号Id")
	private String uuid;

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
	 * 用户性别 (0未知 1男 2女)
	 */
	@ApiModelProperty("用户性别 (0未知 1男 2女)")
	private String sex;

	/**
	 * 是否已关注
	 */
	@ApiModelProperty("是否已关注，0-否，1-是")
	private int attendFlag;
}
