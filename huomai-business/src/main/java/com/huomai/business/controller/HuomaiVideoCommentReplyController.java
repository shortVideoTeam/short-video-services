package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiVideoCommentReplyAddBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyEditBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.service.IHuomaiVideoCommentReplyService;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
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
 * 回复Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "回复控制器", tags = {"回复管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/reply")
public class HuomaiVideoCommentReplyController extends BaseController {

	private final IHuomaiVideoCommentReplyService iHuomaiVideoCommentReplyService;

	/**
	 * 查询回复列表
	 */
	@ApiOperation("查询回复列表")
	//@PreAuthorize("@ss.hasPermi('business:reply:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiVideoCommentReplyVo> list(@Validated HuomaiVideoCommentReplyQueryBo bo) {
		return iHuomaiVideoCommentReplyService.queryPageList(bo);
	}

	/**
	 * 导出回复列表
	 */
	@ApiOperation("导出回复列表")
	//@PreAuthorize("@ss.hasPermi('business:reply:export')")
	@Log(title = "回复", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiVideoCommentReplyVo> export(@Validated HuomaiVideoCommentReplyQueryBo bo) {
		List<HuomaiVideoCommentReplyVo> list = iHuomaiVideoCommentReplyService.queryList(bo);
		ExcelUtil<HuomaiVideoCommentReplyVo> util = new ExcelUtil<HuomaiVideoCommentReplyVo>(HuomaiVideoCommentReplyVo.class);
		return util.exportExcel(list, "回复");
	}

	/**
	 * 获取回复详细信息
	 */
	@ApiOperation("获取回复详细信息")
	//@PreAuthorize("@ss.hasPermi('business:reply:query')")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiVideoCommentReplyVo> getInfo(@NotNull(message = "主键不能为空")
														 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiVideoCommentReplyService.queryById(id));
	}

	/**
	 * 新增回复
	 */
	@ApiOperation("新增回复")
	//@PreAuthorize("@ss.hasPermi('business:reply:add')")
	@Log(title = "回复", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoCommentReplyAddBo bo) {
		return toAjax(iHuomaiVideoCommentReplyService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改回复
	 */
	@ApiOperation("修改回复")
	//@PreAuthorize("@ss.hasPermi('business:reply:edit')")
	@Log(title = "回复", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoCommentReplyEditBo bo) {
		return toAjax(iHuomaiVideoCommentReplyService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除回复
	 */
	@ApiOperation("删除回复")
	//@PreAuthorize("@ss.hasPermi('business:reply:remove')")
	@Log(title = "回复", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiVideoCommentReplyService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
