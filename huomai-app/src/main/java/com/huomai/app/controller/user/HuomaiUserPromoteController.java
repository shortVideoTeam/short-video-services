package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.service.IHuomaiUserPromoteService;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推广记录Controller
 *
 * @author huomai
 * @date 2021-07-06
 */
@Api(
	value = "推广记录控制器",
	tags = {"推广记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/promote")
public class HuomaiUserPromoteController extends BaseController {

	private final IHuomaiUserPromoteService iHuomaiUserPromoteService;

	/**
	 * 查询推广记录列表
	 */
	@ApiOperation("查询推广记录列表")
	@GetMapping("/list")
	public AjaxResult list(@Validated HuomaiUserPromoteQueryBo bo) {
		return AjaxResult.success(iHuomaiUserPromoteService.queryPageList(bo));
	}
}
