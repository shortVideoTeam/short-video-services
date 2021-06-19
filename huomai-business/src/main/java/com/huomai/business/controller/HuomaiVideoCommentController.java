package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiVideoCommentAddBo;
import com.huomai.business.bo.HuomaiVideoCommentEditBo;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.service.IHuomaiVideoCommentService;
import com.huomai.business.vo.HuomaiVideoCommentVo;
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
 * 评论Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "评论控制器", tags = {"评论管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/comment")
public class HuomaiVideoCommentController extends BaseController {

	private final IHuomaiVideoCommentService iHuomaiVideoCommentService;

	/**
	 * 查询评论列表
	 */
	@ApiOperation("查询评论列表")
	//@PreAuthorize("@ss.hasPermi('business:comment:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiVideoCommentVo> list(@Validated HuomaiVideoCommentQueryBo bo) {
		return iHuomaiVideoCommentService.queryPageList(bo);
	}

	/**
	 * 导出评论列表
	 */
	@ApiOperation("导出评论列表")
	//@PreAuthorize("@ss.hasPermi('business:comment:export')")
	@Log(title = "评论", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiVideoCommentVo> export(@Validated HuomaiVideoCommentQueryBo bo) {
		List<HuomaiVideoCommentVo> list = iHuomaiVideoCommentService.queryList(bo);
		ExcelUtil<HuomaiVideoCommentVo> util = new ExcelUtil<HuomaiVideoCommentVo>(HuomaiVideoCommentVo.class);
		return util.exportExcel(list, "评论");
	}

	/**
	 * 获取评论详细信息
	 */
	@ApiOperation("获取评论详细信息")
	//@PreAuthorize("@ss.hasPermi('business:comment:query')")
	@GetMapping("/{commentId}")
	public AjaxResult<HuomaiVideoCommentVo> getInfo(@NotNull(message = "主键不能为空")
													@PathVariable("commentId") Long commentId) {
		return AjaxResult.success(iHuomaiVideoCommentService.queryById(commentId));
	}

	/**
	 * 新增评论
	 */
	@ApiOperation("新增评论")
	//@PreAuthorize("@ss.hasPermi('business:comment:add')")
	@Log(title = "评论", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoCommentAddBo bo) {
		return toAjax(iHuomaiVideoCommentService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改评论
	 */
	@ApiOperation("修改评论")
	//@PreAuthorize("@ss.hasPermi('business:comment:edit')")
	@Log(title = "评论", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoCommentEditBo bo) {
		return toAjax(iHuomaiVideoCommentService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除评论
	 */
	@ApiOperation("删除评论")
	//@PreAuthorize("@ss.hasPermi('business:comment:remove')")
	@Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commentIds}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] commentIds) {
		return toAjax(iHuomaiVideoCommentService.deleteWithValidByIds(Arrays.asList(commentIds), true) ? 1 : 0);
	}
}
