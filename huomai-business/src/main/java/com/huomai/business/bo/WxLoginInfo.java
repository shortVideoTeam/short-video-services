package com.huomai.business.bo;

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
public class WxLoginInfo {

	@NotBlank(message = "appId不能为空")
	private String appid;
	@NotBlank(message = "code不能为空")
	private String code;
	@NotNull(message = "userInfo不能为空")
	private UserInfo userInfo;
	@NotNull(message = "encryptedData不能为空")
	private String encryptedData;
	@NotNull(message = "iv不能为空")
	private String iv;
	@NotNull(message = "rawData不能为空")
	private String rawData;
	@NotNull(message = "signature不能为空")
	private String signature;
}
