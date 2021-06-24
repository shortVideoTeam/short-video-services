package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user")
public class HuomaiUser implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 用户Id
	 */
	@TableId(value = "user_id",type = IdType.AUTO)
	private Long userId;

	/**
	 * 用户火脉号Id
	 */
	private Long uuid;

	/**
	 * 微信同一用户同一应用唯一标识
	 */
	private String openid;

	/**
	 * 微信同一用户不同应用唯一标识
	 */
	private String unionid;

	/**
	 * 用户头像
	 */
	private String avatar;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 用户性别 (0未知 1男 2女)
	 */
	private String sex;

	/**
	 * 用户生日
	 */
	private Date birthday;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 星座
	 */
	private String constellation;

	/**
	 * 省
	 */
	private Long province;

	/**
	 * 市
	 */
	private Long city;

	/**
	 * 区
	 */
	private Long area;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 个人介绍
	 */
	private String userDesc;

	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

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

	/**
	 * 用户状态
	 */
	private String status;

}
