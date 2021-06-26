package com.huomai.business.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 用户信息视图对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户信息详情视图对象")
public class HuomaiUserDetailVo {

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
	 * 用户生日
	 */
	@ApiModelProperty("用户生日")
	private Date birthday;

	/**
	 * 星座
	 */
	@ApiModelProperty("星座")
	private String constellation;

	/**
	 * 省
	 */
	@ApiModelProperty("省")
	private Long province;

	/**
	 * 市
	 */
	@ApiModelProperty("市")
	private Long city;

	/**
	 * 区
	 */
	@ApiModelProperty("区")
	private Long area;

	/**
	 * 详细地址
	 */
	@ApiModelProperty("详细地址")
	private String address;

	/**
	 * 个人介绍
	 */
	@ApiModelProperty("个人介绍")
	private String userDesc;

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

	@ApiModelProperty("关注数")
	private int attendNum;

	@ApiModelProperty("粉丝数")
	private int followNum;

	@ApiModelProperty("作品数")
	private int videoNum;
}
