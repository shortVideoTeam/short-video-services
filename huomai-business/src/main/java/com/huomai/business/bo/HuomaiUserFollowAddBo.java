package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


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

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 备注
	 */
	@ApiModelProperty("备注")
	private String remark;
}
