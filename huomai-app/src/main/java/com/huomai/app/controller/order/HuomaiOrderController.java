package com.huomai.app.controller.order;

import com.huomai.business.bo.HuomaiOrderAddBo;
import com.huomai.business.bo.HuomaiOrderQueryBo;
import com.huomai.business.service.IHuomaiOrderService;
import com.huomai.business.vo.HuomaiOrderDetailVo;
import com.huomai.business.vo.HuomaiOrderVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.system.service.ISysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

	private final ISysConfigService configService;

	/**
	 * 查询订单记录列表
	 */
	@ApiOperation("查询订单记录列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiOrderVo> list(@Validated HuomaiOrderQueryBo bo) {
		return iHuomaiOrderService.queryPageList(bo);
	}

	/**
	 * 推广详情
	 */
	@ApiOperation("推广详情")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiOrderDetailVo> getInfo(@NotNull(message = "主键不能为空")
												   @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiOrderService.getInfo(id));
	}

	/**
	 * 作品推广下单
	 */
	@ApiOperation("作品推广下单")
	@PostMapping("/createOrder")
	public AjaxResult createOrder(@Validated @RequestBody HuomaiOrderAddBo bo) {
		bo.setDomain(configService.selectConfigByKey("api_domain"));
		return AjaxResult.success(iHuomaiOrderService.createOrder(bo));
	}
}
