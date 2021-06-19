package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiVideoLoveAddBo;
import com.huomai.business.bo.HuomaiVideoLoveEditBo;
import com.huomai.business.bo.HuomaiVideoLoveQueryBo;
import com.huomai.business.service.IHuomaiVideoLoveService;
import com.huomai.business.vo.HuomaiVideoLoveVo;
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
 * 点赞记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "点赞记录控制器", tags = {"点赞记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/love")
public class HuomaiVideoLoveController extends BaseController {

	private final IHuomaiVideoLoveService iHuomaiVideoLoveService;

	/**
	 * 查询点赞记录列表
	 */
	@ApiOperation("查询点赞记录列表")
	//@PreAuthorize("@ss.hasPermi('business:love:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiVideoLoveVo> list(@Validated HuomaiVideoLoveQueryBo bo) {
		return iHuomaiVideoLoveService.queryPageList(bo);
	}

	/**
	 * 导出点赞记录列表
	 */
	@ApiOperation("导出点赞记录列表")
	//@PreAuthorize("@ss.hasPermi('business:love:export')")
	@Log(title = "点赞记录", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiVideoLoveVo> export(@Validated HuomaiVideoLoveQueryBo bo) {
		List<HuomaiVideoLoveVo> list = iHuomaiVideoLoveService.queryList(bo);
		ExcelUtil<HuomaiVideoLoveVo> util = new ExcelUtil<HuomaiVideoLoveVo>(HuomaiVideoLoveVo.class);
		return util.exportExcel(list, "点赞记录");
	}

	/**
	 * 获取点赞记录详细信息
	 */
	@ApiOperation("获取点赞记录详细信息")
	//@PreAuthorize("@ss.hasPermi('business:love:query')")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiVideoLoveVo> getInfo(@NotNull(message = "主键不能为空")
												 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiVideoLoveService.queryById(id));
	}

	/**
	 * 新增点赞记录
	 */
	@ApiOperation("新增点赞记录")
	//@PreAuthorize("@ss.hasPermi('business:love:add')")
	@Log(title = "点赞记录", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoLoveAddBo bo) {
		return toAjax(iHuomaiVideoLoveService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改点赞记录
	 */
	@ApiOperation("修改点赞记录")
	//@PreAuthorize("@ss.hasPermi('business:love:edit')")
	@Log(title = "点赞记录", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoLoveEditBo bo) {
		return toAjax(iHuomaiVideoLoveService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除点赞记录
	 */
	@ApiOperation("删除点赞记录")
	//@PreAuthorize("@ss.hasPermi('business:love:remove')")
	@Log(title = "点赞记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiVideoLoveService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
