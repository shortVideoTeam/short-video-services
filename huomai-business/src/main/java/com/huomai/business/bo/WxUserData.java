package com.huomai.business.bo;

import lombok.Data;
import lombok.ToString;

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
public class WxUserData {
	@NotNull(message = "appid不能为空")
	private String appid;
	@NotNull(message = "encryptedData不能为空")
	private String encryptedData;
	@NotNull(message = "iv不能为空")
	private String iv;
	@NotNull(message = "userKey不能为空")
	private String userKey;
}
