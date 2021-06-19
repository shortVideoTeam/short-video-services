package com.huomai.business.controller;

import com.huomai.business.bo.HuomaiOrderItemAddBo;
import com.huomai.business.bo.HuomaiOrderItemEditBo;
import com.huomai.business.bo.HuomaiOrderItemQueryBo;
import com.huomai.business.service.IHuomaiOrderItemService;
import com.huomai.business.vo.HuomaiOrderItemVo;
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
 * 订单记录项Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "订单记录项控制器", tags = {"订单记录项管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/item")
public class HuomaiOrderItemController extends BaseController {

	private final IHuomaiOrderItemService iHuomaiOrderItemService;

	/**
	 * 查询订单记录项列表
	 */
	@ApiOperation("查询订单记录项列表")
	//@PreAuthorize("@ss.hasPermi('business:item:list')")
	@GetMapping("/list")
	public TableDataInfo<HuomaiOrderItemVo> list(@Validated HuomaiOrderItemQueryBo bo) {
		return iHuomaiOrderItemService.queryPageList(bo);
	}

	/**
	 * 导出订单记录项列表
	 */
	@ApiOperation("导出订单记录项列表")
	//@PreAuthorize("@ss.hasPermi('business:item:export')")
	@Log(title = "订单记录项", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult<HuomaiOrderItemVo> export(@Validated HuomaiOrderItemQueryBo bo) {
		List<HuomaiOrderItemVo> list = iHuomaiOrderItemService.queryList(bo);
		ExcelUtil<HuomaiOrderItemVo> util = new ExcelUtil<HuomaiOrderItemVo>(HuomaiOrderItemVo.class);
		return util.exportExcel(list, "订单记录项");
	}

	/**
	 * 获取订单记录项详细信息
	 */
	@ApiOperation("获取订单记录项详细信息")
	//@PreAuthorize("@ss.hasPermi('business:item:query')")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiOrderItemVo> getInfo(@NotNull(message = "主键不能为空")
												 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiOrderItemService.queryById(id));
	}

	/**
	 * 新增订单记录项
	 */
	@ApiOperation("新增订单记录项")
	//@PreAuthorize("@ss.hasPermi('business:item:add')")
	@Log(title = "订单记录项", businessType = BusinessType.INSERT)
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiOrderItemAddBo bo) {
		return toAjax(iHuomaiOrderItemService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改订单记录项
	 */
	@ApiOperation("修改订单记录项")
	//@PreAuthorize("@ss.hasPermi('business:item:edit')")
	@Log(title = "订单记录项", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiOrderItemEditBo bo) {
		return toAjax(iHuomaiOrderItemService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除订单记录项
	 */
	@ApiOperation("删除订单记录项")
	//@PreAuthorize("@ss.hasPermi('business:item:remove')")
	@Log(title = "订单记录项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiOrderItemService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
