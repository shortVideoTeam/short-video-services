package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserInviteAddBo;
import com.huomai.business.bo.HuomaiUserInviteQueryBo;
import com.huomai.business.service.IHuomaiUserInviteService;
import com.huomai.business.vo.HuomaiUserInviteVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * 邀请记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "邀请记录控制器", tags = {"邀请记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/invite")
public class HuomaiUserInviteController extends BaseController {

	private final IHuomaiUserInviteService iHuomaiUserInviteService;

	/**
	 * 查询邀请记录列表
	 */
	@ApiOperation("查询邀请记录列表")
	@GetMapping("/list")
	public AjaxResult list(@Validated HuomaiUserInviteQueryBo bo) {
		return AjaxResult.success(iHuomaiUserInviteService.queryPageList(bo));
	}

	/**
	 * 获取邀请记录详细信息
	 */
	@ApiOperation("获取邀请记录详细信息")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiUserInviteVo> getInfo(@NotNull(message = "主键不能为空")
												  @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiUserInviteService.queryById(id));
	}

	/**
	 * 新增邀请记录
	 */
	@ApiOperation("新增邀请记录")
	@PostMapping("/add")
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserInviteAddBo bo) {
		return toAjax(iHuomaiUserInviteService.insertByAddBo(bo) ? 1 : 0);
	}
}
