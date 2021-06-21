package com.huomai.business.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Maps;
import com.huomai.business.bo.HuomaiUserAddBo;
import com.huomai.business.bo.WxLoginInfo;
import com.huomai.business.bo.WxUserData;
import com.huomai.business.config.WxMaConfiguration;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.common.annotation.PassToken;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.redis.RedisCache;
import com.huomai.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/wx/user")
public class WxAuthController {

	@Autowired
	private IHuomaiUserService userService;

	@Autowired
	private RedisCache redisCache;

	/**
	 * 授权
	 */
	@PassToken
	@PostMapping("/auth")
	public AjaxResult auth(@RequestBody WxLoginInfo loginInfo) {
		final WxMaService wxService = WxMaConfiguration.getMaService(loginInfo.getAppid());
		try {
			WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(loginInfo.getCode());
			//todo
			HuomaiUserAddBo addBo = new HuomaiUserAddBo();
			//填充用户信息
			userService.insertByAddBo(addBo);
			HashMap<Object, Object> map = Maps.newHashMap();
			map.put("userKey", session.getSessionKey());
			redisCache.setCacheObject(session.getSessionKey(), addBo.getOpenid());
			return AjaxResult.success(map);
		} catch (WxErrorException e) {
			log.error("授权失败：", e);
			return AjaxResult.error("授权失败");
		}
	}

	/**
	 * <pre>
	 * 绑定手机号，返回token
	 * </pre>
	 */
	@PassToken
	@PostMapping("/phone")
	public AjaxResult phone(@RequestBody WxUserData userData) {
		final WxMaService wxService = WxMaConfiguration.getMaService(userData.getAppid());
		// 用户信息校验
		if (!wxService.getUserService().checkUserInfo(userData.getSessionKey(), userData.getRawData(), userData.getSignature())) {
			return AjaxResult.error("user check failed");
		}
		// 解密手机号信息
		WxMaPhoneNumberInfo phoneNoInfo = wxService.getUserService().getPhoneNoInfo(userData.getSessionKey(), userData.getEncryptedData(), userData.getIv());
		log.info(phoneNoInfo.toString());
		String openId = redisCache.getCacheObject(userData.getSessionKey());
		if (StringUtils.isEmpty(openId)) {
			AjaxResult.error(HttpStatus.HTTP_UNAUTHORIZED, "请重新授权");
		}
		HuomaiUser huomaiUser = userService.getVoOne(Wrappers.<HuomaiUser>lambdaQuery().eq(HuomaiUser::getOpenid, openId), HuomaiUser.class);
		HuomaiUser uptUser = new HuomaiUser();
		uptUser.setUserId(huomaiUser.getUserId());
		uptUser.setPhone(phoneNoInfo.getPhoneNumber());
		userService.updateById(uptUser);
		HashMap<Object, Object> map = Maps.newHashMap();
		map.put("token", JwtUtil.sign(String.valueOf(huomaiUser.getUserId()), SecureUtil.md5(huomaiUser.getOpenid())));
		return AjaxResult.success(map);
	}

}
