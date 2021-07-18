package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserFollowAddBo;
import com.huomai.business.bo.HuomaiUserFollowDelBo;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.service.IHuomaiUserFollowService;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 用户关注Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "用户关注控制器", tags = {"用户关注管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/follow")
public class HuomaiUserFollowController extends BaseController {

	private final IHuomaiUserFollowService iHuomaiUserFollowService;

	/**
	 * 查询用户关注列表
	 */
	@ApiOperation("用户关注列表")
	@GetMapping("/attendList")
	public AjaxResult attendList(@Validated HuomaiUserFollowQueryBo bo) {
		return AjaxResult.success(iHuomaiUserFollowService.attendList(bo));
	}

	/**
	 * 查询用户粉丝列表
	 */
	@ApiOperation("用户粉丝列表")
	@GetMapping("/followMeList")
	public AjaxResult followMeList(@Validated HuomaiUserFollowQueryBo bo) {
		return AjaxResult.success(iHuomaiUserFollowService.followMeList(bo));
	}

	/**
	 * 我的好友列表
	 */
	@ApiOperation("我的好友列表")
	@GetMapping("/friendsList")
	public AjaxResult friendsList(@Validated HuomaiUserFollowQueryBo bo) {
		return AjaxResult.success(iHuomaiUserFollowService.friendsList(bo));
	}

	/**
	 * 获取用户关注详细信息
	 */
	@ApiOperation("获取用户关注详细信息")
	@GetMapping("/{userId}")
	public AjaxResult<HuomaiUserFollowVo> getInfo(@NotNull(message = "主键不能为空")
												  @PathVariable("userId") Long userId) {
		return AjaxResult.success(iHuomaiUserFollowService.queryById(userId));
	}

	/**
	 * 新增用户关注
	 */
	@ApiOperation("关注")
	@PostMapping("/attend")
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserFollowAddBo bo) {
		return toAjax(iHuomaiUserFollowService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 删除用户关注
	 */
	@ApiOperation("取消关注")
	@PostMapping("/attendCancel")
	public AjaxResult attendCancel(@Validated @RequestBody HuomaiUserFollowDelBo bo) {
		Long id = bo.getId();
		if (id == null) {
			return AjaxResult.error("id参数是必填");
		}
		return toAjax(iHuomaiUserFollowService.deleteWithValidByIds(Arrays.asList(bo.getId()), true) ? 1 : 0);
	}

	/**
	 * 删除用户关注
	 */
	@ApiOperation("批量取消关注")
	@PostMapping("/batchAttendCancel")
	public AjaxResult<Void> batchAttendCancel(@Validated @RequestBody HuomaiUserFollowDelBo bo) {
		List<Long> ids = bo.getIds();
		if (ids == null || ids.size() == 0) {
			return AjaxResult.error("ids参数是必填");
		}
		return toAjax(iHuomaiUserFollowService.deleteWithValidByIds(bo.getIds(), true) ? 1 : 0);
	}
}
