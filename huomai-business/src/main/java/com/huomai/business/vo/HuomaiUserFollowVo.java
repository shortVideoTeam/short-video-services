package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 用户关注视图对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户关注|粉丝视图对象")
public class HuomaiUserFollowVo {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 用户id
	 */
	@ApiModelProperty("用户id")
	private Long userId;

	//来源，1-搜索2-粉丝3-消息4-可能认识的人
	@ApiModelProperty("来源，1-搜索2-粉丝3-消息4-可能认识的人")
	private Integer source;

	/**
	 * 关注用户id
	 */
	@ApiModelProperty("关注用户id")
	private Long followUserId;

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
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;

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

	@ApiModelProperty("关注时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;


}
