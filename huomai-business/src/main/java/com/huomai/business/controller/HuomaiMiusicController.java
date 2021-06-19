package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiMiusicAddBo;
import com.huomai.business.bo.HuomaiMiusicEditBo;
import com.huomai.business.bo.HuomaiMiusicQueryBo;
import com.huomai.business.service.IHuomaiMiusicService;
import com.huomai.business.vo.HuomaiMiusicVo;
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
 * 音乐模板Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "音乐模板控制器", tags = {"音乐模板管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/miusic")
public class HuomaiMiusicController extends BaseController {

	private final IHuomaiMiusicService iHuomaiMiusicService;

	/**
	 * 查询音乐模板列表
	 */
	@ApiOperation("查询音乐模板列表")
	//@PreAuthorize("@ss.hasPermi('business:miusic:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiMiusicVo> list(@Validated HuomaiMiusicQueryBo bo) {
		return iHuomaiMiusicService.queryPageList(bo);
	}

	/**
	 * 导出音乐模板列表
	 */
	@ApiOperation("导出音乐模板列表")
	//@PreAuthorize("@ss.hasPermi('business:miusic:export')")
	@Log(title = "音乐模板", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiMiusicVo> export(@Validated HuomaiMiusicQueryBo bo) {
		List<HuomaiMiusicVo> list = iHuomaiMiusicService.queryList(bo);
		ExcelUtil<HuomaiMiusicVo> util = new ExcelUtil<HuomaiMiusicVo>(HuomaiMiusicVo.class);
		return util.exportExcel(list, "音乐模板");
	}

	/**
	 * 获取音乐模板详细信息
	 */
	@ApiOperation("获取音乐模板详细信息")
	//@PreAuthorize("@ss.hasPermi('business:miusic:query')")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiMiusicVo> getInfo(@NotNull(message = "主键不能为空")
											  @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiMiusicService.queryById(id));
	}

	/**
	 * 新增音乐模板
	 */
	@ApiOperation("新增音乐模板")
	//@PreAuthorize("@ss.hasPermi('business:miusic:add')")
	@Log(title = "音乐模板", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiMiusicAddBo bo) {
		return toAjax(iHuomaiMiusicService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改音乐模板
	 */
	@ApiOperation("修改音乐模板")
	//@PreAuthorize("@ss.hasPermi('business:miusic:edit')")
	@Log(title = "音乐模板", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiMiusicEditBo bo) {
		return toAjax(iHuomaiMiusicService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除音乐模板
	 */
	@ApiOperation("删除音乐模板")
	//@PreAuthorize("@ss.hasPermi('business:miusic:remove')")
	@Log(title = "音乐模板", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiMiusicService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
