package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiSensitiveAddBo;
import com.huomai.business.bo.HuomaiSensitiveEditBo;
import com.huomai.business.bo.HuomaiSensitiveQueryBo;
import com.huomai.business.service.IHuomaiSensitiveService;
import com.huomai.business.vo.HuomaiSensitiveVo;
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
 * 敏感词Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "敏感词控制器", tags = {"敏感词管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/sensitive")
public class HuomaiSensitiveController extends BaseController {

	private final IHuomaiSensitiveService iHuomaiSensitiveService;

	/**
	 * 查询敏感词列表
	 */
	@ApiOperation("查询敏感词列表")
	//@PreAuthorize("@ss.hasPermi('business:sensitive:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiSensitiveVo> list(@Validated HuomaiSensitiveQueryBo bo) {
		return iHuomaiSensitiveService.queryPageList(bo);
	}

	/**
	 * 导出敏感词列表
	 */
	@ApiOperation("导出敏感词列表")
	//@PreAuthorize("@ss.hasPermi('business:sensitive:export')")
	@Log(title = "敏感词", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiSensitiveVo> export(@Validated HuomaiSensitiveQueryBo bo) {
		List<HuomaiSensitiveVo> list = iHuomaiSensitiveService.queryList(bo);
		ExcelUtil<HuomaiSensitiveVo> util = new ExcelUtil<HuomaiSensitiveVo>(HuomaiSensitiveVo.class);
		return util.exportExcel(list, "敏感词");
	}

	/**
	 * 获取敏感词详细信息
	 */
	@ApiOperation("获取敏感词详细信息")
	//@PreAuthorize("@ss.hasPermi('business:sensitive:query')")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiSensitiveVo> getInfo(@NotNull(message = "主键不能为空")
												 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiSensitiveService.queryById(id));
	}

	/**
	 * 新增敏感词
	 */
	@ApiOperation("新增敏感词")
	//@PreAuthorize("@ss.hasPermi('business:sensitive:add')")
	@Log(title = "敏感词", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiSensitiveAddBo bo) {
		return toAjax(iHuomaiSensitiveService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改敏感词
	 */
	@ApiOperation("修改敏感词")
	//@PreAuthorize("@ss.hasPermi('business:sensitive:edit')")
	@Log(title = "敏感词", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiSensitiveEditBo bo) {
		return toAjax(iHuomaiSensitiveService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除敏感词
	 */
	@ApiOperation("删除敏感词")
	//@PreAuthorize("@ss.hasPermi('business:sensitive:remove')")
	@Log(title = "敏感词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiSensitiveService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
