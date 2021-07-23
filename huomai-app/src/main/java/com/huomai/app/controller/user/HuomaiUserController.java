package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserEditBo;
import com.huomai.business.bo.HuomaiUserQueryBo;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.business.vo.HuomaiUserDetailVo;
import com.huomai.business.vo.HuomaiUserWalleVo;
import com.huomai.common.annotation.PassToken;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 用户信息Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "用户信息控制器", tags = {"用户信息管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/user")
public class HuomaiUserController extends BaseController {

	private final IHuomaiUserService iHuomaiUserService;

	/**
	 * 首页搜索用户信息列表
	 */
	@PassToken
	@ApiOperation("首页搜索用户列表")
	@GetMapping("/list")
	public AjaxResult list(@Validated HuomaiUserQueryBo bo) {
		return AjaxResult.success(iHuomaiUserService.queryPageList(bo));
	}


	/**
	 * 用户详情（我的|他人）
	 */
	@ApiOperation("用户详情（我的|他人）")
	@GetMapping("/{userId}")
	public AjaxResult<HuomaiUserDetailVo> getInfo(@NotNull(message = "主键不能为空")
												  @PathVariable("userId") Long userId) {
		return AjaxResult.success(iHuomaiUserService.getInfo(userId));
	}

	/**
	 * 修改资料
	 */
	@ApiOperation("修改资料")
	@PostMapping("/update")
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserEditBo bo) {
		return toAjax(iHuomaiUserService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 我的钱包
	 */
	@ApiOperation("我的钱包")
	@GetMapping("/myWalle")
	public AjaxResult<HuomaiUserWalleVo> myWalle() {
		return AjaxResult.success(iHuomaiUserService.getVoById(SecurityUtils.getUserId(), HuomaiUserWalleVo.class));
	}
}
