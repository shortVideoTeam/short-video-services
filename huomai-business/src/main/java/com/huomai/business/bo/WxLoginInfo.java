package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/***
 * @description: 微信用户登录信息
 * @author chenshufeng
 * @date: 2021/6/21 1:00 下午
 */
@Data
@ToString
@ApiModel(value = "微信用户登录信息")
public class WxLoginInfo {

	@ApiModelProperty(value = "appid")
	@NotBlank(message = "appid不能为空")
	private String appid;
	@ApiModelProperty(value = "code")
	@NotBlank(message = "code不能为空")
	private String code;
	@ApiModelProperty(value = "userInfo")
	@NotNull(message = "userInfo不能为空")
	private UserInfo userInfo;
	@ApiModelProperty(value = "encryptedData")
	@NotBlank(message = "encryptedData不能为空")
	private String encryptedData;
	@ApiModelProperty(value = "iv")
	@NotBlank(message = "iv不能为空")
	private String iv;
	@NotBlank(message = "rawData不能为空")
	@ApiModelProperty(value = "rawData")
	private String rawData;
	@NotBlank(message = "signature不能为空")
	@ApiModelProperty(value = "signature")
	private String signature;
}
