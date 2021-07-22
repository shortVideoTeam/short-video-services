package com.huomai.common.utils;

/**
 * 安全服务工具类
 *
 * @author huomai
 */
public class SecurityUtils {

	/**
	 * 获取用户ID
	 **/
	public static Long getUserId() {
		Object userId = ServletUtils.getRequest().getAttribute("userId");
		if (userId == null) {
			return 0L;
		}
		return Long.parseLong(String.valueOf(userId));
	}
}
