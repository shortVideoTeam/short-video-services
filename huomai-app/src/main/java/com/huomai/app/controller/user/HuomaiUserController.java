package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserAddBo;
import com.huomai.business.bo.HuomaiUserEditBo;
import com.huomai.business.bo.HuomaiUserQueryBo;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.business.vo.HuomaiUserVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

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
	 * 查询用户信息列表
	 */
	@ApiOperation("查询用户信息列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiUserVo> list(@Validated HuomaiUserQueryBo bo) {
		return iHuomaiUserService.queryPageList(bo);
	}

	/**
	 * 获取用户信息详细信息
	 */
	@ApiOperation("获取用户信息详细信息")
	@GetMapping("/{userId}")
	public AjaxResult<HuomaiUserVo> getInfo(@NotNull(message = "主键不能为空")
											@PathVariable("userId") Long userId) {
		return AjaxResult.success(iHuomaiUserService.queryById(userId));
	}

	/**
	 * 新增用户信息
	 */
	@ApiOperation("新增用户信息")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserAddBo bo) {
		return toAjax(iHuomaiUserService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改用户信息
	 */
	@ApiOperation("修改用户信息")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserEditBo bo) {
		return toAjax(iHuomaiUserService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除用户信息
	 */
	@ApiOperation("删除用户信息")
	@DeleteMapping("/{userIds}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] userIds) {
		return toAjax(iHuomaiUserService.deleteWithValidByIds(Arrays.asList(userIds), true) ? 1 : 0);
	}
}
