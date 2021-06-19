package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户信息分页查询对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户信息分页查询对象")
public class HuomaiUserQueryBo extends BaseEntity {

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
	 * 用户火脉号Id
	 */
	@ApiModelProperty("用户火脉号Id")
	private String uuid;
	/**
	 * 微信同一用户同一应用唯一标识
	 */
	@ApiModelProperty("微信同一用户同一应用唯一标识")
	private String openid;
	/**
	 * 微信同一用户不同应用唯一标识
	 */
	@ApiModelProperty("微信同一用户不同应用唯一标识")
	private String unionid;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty("用户生日")
	private Date birthday;
	/**
	 * 手机号
	 */
	@ApiModelProperty("手机号")
	private String phone;
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
	private String desc;

}
