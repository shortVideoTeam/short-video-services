package com.huomai.app.controller.order;

import com.huomai.business.bo.HuomaiOrderAddBo;
import com.huomai.business.bo.HuomaiOrderEditBo;
import com.huomai.business.bo.HuomaiOrderQueryBo;
import com.huomai.business.service.IHuomaiOrderService;
import com.huomai.business.vo.HuomaiOrderVo;
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
 * 订单记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "订单记录控制器", tags = {"订单记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/order")
public class HuomaiOrderController extends BaseController {

	private final IHuomaiOrderService iHuomaiOrderService;

	/**
	 * 查询订单记录列表
	 */
	@ApiOperation("查询订单记录列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiOrderVo> list(@Validated HuomaiOrderQueryBo bo) {
		return iHuomaiOrderService.queryPageList(bo);
	}

	/**
	 * 获取订单记录详细信息
	 */
	@ApiOperation("获取订单记录详细信息")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiOrderVo> getInfo(@NotNull(message = "主键不能为空")
											 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiOrderService.queryById(id));
	}

	/**
	 * 新增订单记录
	 */
	@ApiOperation("新增订单记录")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiOrderAddBo bo) {
		return toAjax(iHuomaiOrderService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改订单记录
	 */
	@ApiOperation("修改订单记录")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiOrderEditBo bo) {
		return toAjax(iHuomaiOrderService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除订单记录
	 */
	@ApiOperation("删除订单记录")
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiOrderService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
