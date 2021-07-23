package com.huomai.app.controller.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Maps;
import com.huomai.business.bo.HuomaiUserInviteQueryBo;
import com.huomai.business.domain.HuomaiUserInvite;
import com.huomai.business.service.IHuomaiUserInviteService;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 邀请记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "邀请管理", tags = {"邀请管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/invite")
public class HuomaiUserInviteController extends BaseController {

	private final IHuomaiUserInviteService iHuomaiUserInviteService;

	/**
	 * 查询邀请记录列表
	 */
	@ApiOperation("我的邀请人")
	@GetMapping("/myUserInvite")
	public AjaxResult myUserInvite() {
		return AjaxResult.success(iHuomaiUserInviteService.myUserInvite());
	}

	@ApiOperation("已邀请好友列表")
	@GetMapping("/myInviteList")
	public AjaxResult myInviteList(@Validated HuomaiUserInviteQueryBo bo) {
		return AjaxResult.success(iHuomaiUserInviteService.myInviteList(bo));
	}

	/**
	 * 查询邀请记录列表
	 */
	@ApiOperation("我邀请的总人数")
	@GetMapping("/count")
	public AjaxResult count() {
		int count = iHuomaiUserInviteService.count(Wrappers.<HuomaiUserInvite>lambdaQuery().eq(HuomaiUserInvite::getUserId, SecurityUtils.getUserId()));
		HashMap<Object, Object> map = Maps.newHashMap();
		map.put("inviteNum", count);
		return AjaxResult.success(map);
	}
}
