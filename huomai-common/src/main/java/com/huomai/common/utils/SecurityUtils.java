package com.huomai.common.utils;

/**
 * 安全服务工具类
 *
 * @author huomai
 */
public class SecurityUtils {
	/**
	 * 获取用户账户
	 **/
	public static String getUsername() {
		return String.valueOf(ServletUtils.getRequest().getAttribute("userId"));
	}
}
