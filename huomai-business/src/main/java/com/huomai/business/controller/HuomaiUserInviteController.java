package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiUserInviteAddBo;
import com.huomai.business.bo.HuomaiUserInviteEditBo;
import com.huomai.business.bo.HuomaiUserInviteQueryBo;
import com.huomai.business.service.IHuomaiUserInviteService;
import com.huomai.business.vo.HuomaiUserInviteVo;
import com.huomai.common.annotation.Log;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.enums.BusinessType;
import com.huomai.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

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
	//@PreAuthorize("@ss.hasPermi('business:invite:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiUserInviteVo> list(@Validated HuomaiUserInviteQueryBo bo) {
		return iHuomaiUserInviteService.queryPageList(bo);
	}

	/**
	 * 导出邀请记录列表
	 */
	@ApiOperation("导出邀请记录列表")
	//@PreAuthorize("@ss.hasPermi('business:invite:export')")
	@Log(title = "邀请记录", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiUserInviteVo> export(@Validated HuomaiUserInviteQueryBo bo) {
		List<HuomaiUserInviteVo> list = iHuomaiUserInviteService.queryList(bo);
		ExcelUtil<HuomaiUserInviteVo> util = new ExcelUtil<HuomaiUserInviteVo>(HuomaiUserInviteVo.class);
		return util.exportExcel(list, "邀请记录");
	}

	/**
	 * 获取邀请记录详细信息
	 */
	@ApiOperation("获取邀请记录详细信息")
	//@PreAuthorize("@ss.hasPermi('business:invite:query')")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiUserInviteVo> getInfo(@NotNull(message = "主键不能为空")
												  @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiUserInviteService.queryById(id));
	}

	/**
	 * 新增邀请记录
	 */
	@ApiOperation("新增邀请记录")
	//@PreAuthorize("@ss.hasPermi('business:invite:add')")
	@Log(title = "邀请记录", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserInviteAddBo bo) {
		return toAjax(iHuomaiUserInviteService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改邀请记录
	 */
	@ApiOperation("修改邀请记录")
	//@PreAuthorize("@ss.hasPermi('business:invite:edit')")
	@Log(title = "邀请记录", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserInviteEditBo bo) {
		return toAjax(iHuomaiUserInviteService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除邀请记录
	 */
	@ApiOperation("删除邀请记录")
	//@PreAuthorize("@ss.hasPermi('business:invite:remove')")
	@Log(title = "邀请记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiUserInviteService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
