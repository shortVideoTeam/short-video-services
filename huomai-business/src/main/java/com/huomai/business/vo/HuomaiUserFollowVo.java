package com.huomai.business.vo;

import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 用户关注视图对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户关注视图对象")
public class HuomaiUserFollowVo {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@ApiModelProperty("用户id")
	private Long userId;

	/**
	 * 关注用户id
	 */
	@Excel(name = "关注用户id")
	@ApiModelProperty("关注用户id")
	private Long followUserId;

	/**
	 * 备注
	 */
	@Excel(name = "备注")
	@ApiModelProperty("备注")
	private String remark;


}
