
package com.huomai.business.filter;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpStatus;
import com.google.common.collect.Sets;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.common.annotation.PassToken;
import com.huomai.common.exception.CustomException;
import com.huomai.common.utils.JwtUtil;
import com.huomai.common.utils.ServletUtils;
import com.huomai.common.utils.spring.SpringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Set;

/***
 * @description:
 * @author chenshufeng
 * @date: 2021/6/21 3:17 下午
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
	public static final String USER_KEY = "userId";

	private final static Set<String> set = Sets.newHashSet("/doc.html", "/swagger-resources", "/v2/api-docs");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							 Object object) {
		if (set.contains(request.getRequestURI())) {
			return true;
		}
		String token = request.getHeader("Authorization");// 从 http 请求头中取出
		// token
		// 如果不是映射到方法直接通过
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		// 检查是否有passtoken注释，有则跳过认证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		// 执行认证
		if (token == null) {
			throw new RuntimeException("无token，请重新登录");
		}
		String username = JwtUtil.getUsername(token);
		if (username == null) {
			throw new RuntimeException("token invalid");
		}

		HuomaiUser appUser = SpringUtils.getBean(IHuomaiUserService.class).getById(username);
		if (appUser == null) {
			throw new RuntimeException("用户不存在，请重新登录");
		}
		// 验证 token
		if (!JwtUtil.verify(token, String.valueOf(appUser.getUserId()), SecureUtil.md5(appUser.getOpenid()))) {
			throw new CustomException("token已过期，请重新登录", HttpStatus.HTTP_UNAUTHORIZED);
		}
		// 设置userId到request里，后续根据userId，获取用户信息
		request.setAttribute(USER_KEY, appUser.getUserId());
		ServletUtils.getRequest().setAttribute(USER_KEY,appUser.getUserId());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
						   ModelAndView modelAndView) {
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
								Object o, Exception e) {
	}
}
