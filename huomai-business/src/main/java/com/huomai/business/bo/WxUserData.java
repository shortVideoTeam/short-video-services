package com.huomai.business.bo;

import lombok.Data;
import lombok.ToString;

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

	private String appid;
	private String sessionKey;
	private String encryptedData;
	private String iv;
	private String rawData;
	private String signature;
}
