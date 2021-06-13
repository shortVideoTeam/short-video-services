package com.huomai.framework.web.service;

import com.huomai.common.constant.Constants;
import com.huomai.common.core.domain.entity.SysUser;
import com.huomai.common.core.domain.model.LoginUser;
import com.huomai.common.core.redis.RedisCache;
import com.huomai.common.exception.CustomException;
import com.huomai.common.exception.user.CaptchaException;
import com.huomai.common.exception.user.CaptchaExpireException;
import com.huomai.common.exception.user.UserPasswordNotMatchException;
import com.huomai.common.utils.DateUtils;
import com.huomai.common.utils.MessageUtils;
import com.huomai.common.utils.ServletUtils;
import com.huomai.common.utils.ip.IpUtils;
import com.huomai.framework.config.properties.CaptchaProperties;
import com.huomai.framework.manager.AsyncManager;
import com.huomai.framework.manager.factory.AsyncFactory;
import com.huomai.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author huomai
 */
@Component
public class SysLoginService {
	@Autowired
	private TokenService tokenService;

	@Resource
	private AuthenticationManager authenticationManager;

	@Autowired
	private RedisCache redisCache;

	@Autowired
	private CaptchaProperties captchaProperties;

	@Autowired
	private ISysUserService userService;

	/**
	 * 登录验证
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @param code     验证码
	 * @param uuid     唯一标识
	 * @return 结果
	 */
	public String login(String username, String password, String code, String uuid) {
		if (captchaProperties.getEnabled()) {
			String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
			String captcha = redisCache.getCacheObject(verifyKey);
			redisCache.deleteObject(verifyKey);
			if (captcha == null) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
				throw new CaptchaExpireException();
			}
			if (!code.equalsIgnoreCase(captcha)) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
				throw new CaptchaException();
			}
		}
		// 用户验证
		Authentication authentication = null;
		try {
			// 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
			authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			if (e instanceof BadCredentialsException) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
				throw new UserPasswordNotMatchException();
			} else {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
				throw new CustomException(e.getMessage());
			}
		}
		AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
		LoginUser loginUser = (LoginUser) authentication.getPrincipal();
		recordLoginInfo(loginUser.getUser());
		// 生成token
		return tokenService.createToken(loginUser);
	}

	/**
	 * 记录登录信息
	 */
	public void recordLoginInfo(SysUser user) {
		user.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
		user.setLoginDate(DateUtils.getNowDate());
		user.setUpdateBy(user.getUserName());
		userService.updateUserProfile(user);
	}
}
