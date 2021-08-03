package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 小程序用户加密信息
 *
 * @author chenshufeng
 * @version 1.0
 * @date 2021/6/21 12:52 下午
 */
@Data
@ToString
@ApiModel(value = "小程序用户加密信息")
public class WxUserData {
	@ApiModelProperty(value = "appid")
	@NotBlank(message = "appid不能为空")
	private String appid;

	@ApiModelProperty(value = "encryptedData")
	@NotBlank(message = "encryptedData不能为空")
	private String encryptedData;

	@ApiModelProperty(value = "iv")
	@NotBlank(message = "iv不能为空")
	private String iv;

	@ApiModelProperty(value = "userKey")
	@NotBlank(message = "userKey不能为空")
	private String userKey;
}
