package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiVideoAddBo;
import com.huomai.business.bo.HuomaiVideoEditBo;
import com.huomai.business.bo.HuomaiVideoQueryBo;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.business.vo.HuomaiVideoVo;
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
 * 视频信息Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "视频信息控制器", tags = {"视频信息管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/video")
public class HuomaiVideoController extends BaseController {

	private final IHuomaiVideoService iHuomaiVideoService;

	/**
	 * 查询视频信息列表
	 */
	@ApiOperation("查询视频信息列表")
	//@PreAuthorize("@ss.hasPermi('business:video:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiVideoVo> list(@Validated HuomaiVideoQueryBo bo) {
		return iHuomaiVideoService.queryPageList(bo);
	}

	/**
	 * 导出视频信息列表
	 */
	@ApiOperation("导出视频信息列表")
	//@PreAuthorize("@ss.hasPermi('business:video:export')")
	@Log(title = "视频信息", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiVideoVo> export(@Validated HuomaiVideoQueryBo bo) {
		List<HuomaiVideoVo> list = iHuomaiVideoService.queryList(bo);
		ExcelUtil<HuomaiVideoVo> util = new ExcelUtil<HuomaiVideoVo>(HuomaiVideoVo.class);
		return util.exportExcel(list, "视频信息");
	}

	/**
	 * 获取视频信息详细信息
	 */
	@ApiOperation("获取视频信息详细信息")
	//@PreAuthorize("@ss.hasPermi('business:video:query')")
	@GetMapping("/{videoId}")
	public AjaxResult<HuomaiVideoVo> getInfo(@NotNull(message = "主键不能为空")
											 @PathVariable("videoId") Long videoId) {
		return AjaxResult.success(iHuomaiVideoService.queryById(videoId));
	}

	/**
	 * 新增视频信息
	 */
	@ApiOperation("新增视频信息")
	//@PreAuthorize("@ss.hasPermi('business:video:add')")
	@Log(title = "视频信息", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoAddBo bo) {
		return toAjax(iHuomaiVideoService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改视频信息
	 */
	@ApiOperation("修改视频信息")
	//@PreAuthorize("@ss.hasPermi('business:video:edit')")
	@Log(title = "视频信息", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoEditBo bo) {
		return toAjax(iHuomaiVideoService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除视频信息
	 */
	@ApiOperation("删除视频信息")
	//@PreAuthorize("@ss.hasPermi('business:video:remove')")
	@Log(title = "视频信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{videoIds}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] videoIds) {
		return toAjax(iHuomaiVideoService.deleteWithValidByIds(Arrays.asList(videoIds), true) ? 1 : 0);
	}
}
