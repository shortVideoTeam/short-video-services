package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
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
	@Excel(name = "用户火脉号Id")
	@ApiModelProperty("用户火脉号Id")
	private String uuid;

	/**
	 * 微信同一用户同一应用唯一标识
	 */
	@Excel(name = "微信同一用户同一应用唯一标识")
	@ApiModelProperty("微信同一用户同一应用唯一标识")
	private String openid;

	/**
	 * 微信同一用户不同应用唯一标识
	 */
	@Excel(name = "微信同一用户不同应用唯一标识")
	@ApiModelProperty("微信同一用户不同应用唯一标识")
	private String unionid;

	/**
	 * 用户头像
	 */
	@Excel(name = "用户头像")
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户昵称
	 */
	@Excel(name = "用户昵称")
	@ApiModelProperty("用户昵称")
	private String nickName;

	/**
	 * 用户性别 (0未知 1男 2女)
	 */
	@Excel(name = "用户性别 (0未知 1男 2女)")
	@ApiModelProperty("用户性别 (0未知 1男 2女)")
	private String sex;

	/**
	 * 用户生日
	 */
	@Excel(name = "用户生日", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("用户生日")
	private Date birthday;

	/**
	 * 手机号
	 */
	@Excel(name = "手机号")
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 * 星座
	 */
	@Excel(name = "星座")
	@ApiModelProperty("星座")
	private String constellation;

	/**
	 * 省
	 */
	@Excel(name = "省")
	@ApiModelProperty("省")
	private Long province;

	/**
	 * 市
	 */
	@Excel(name = "市")
	@ApiModelProperty("市")
	private Long city;

	/**
	 * 区
	 */
	@Excel(name = "区")
	@ApiModelProperty("区")
	private Long area;

	/**
	 * 详细地址
	 */
	@Excel(name = "详细地址")
	@ApiModelProperty("详细地址")
	private String address;

	/**
	 * 个人介绍
	 */
	@Excel(name = "个人介绍")
	@ApiModelProperty("个人介绍")
	private String desc;

	/**
	 * 备注
	 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;


}
