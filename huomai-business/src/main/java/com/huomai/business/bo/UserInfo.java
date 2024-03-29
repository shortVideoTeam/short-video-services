package com.huomai.business.bo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserInfo {
	private String nickName;
	private String avatarUrl;
	private String country;
	private String province;
	private String city;
	private String language;
	private Byte gender;
}
