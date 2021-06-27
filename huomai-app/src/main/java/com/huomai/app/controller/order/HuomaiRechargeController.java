/*
 * Copyright (c) 2018-2999 广州亚米信息科技有限公司 All rights reserved.
 *
 * https://www.gz-yami.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.huomai.app.controller.order;

import com.huomai.business.bo.HuomaiRechargeAddBo;
import com.huomai.business.service.IHuomaiMoneyRuleService;
import com.huomai.business.service.IHuomaiOrderService;
import com.huomai.business.vo.HuomaiMoneyRuleVo;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(value = "充值模块", tags = {"充值管理"})
@RestController
@RequestMapping("/business/recharge")
@AllArgsConstructor
public class HuomaiRechargeController {

	@Autowired
	private IHuomaiOrderService orderService;

	@Autowired
	private IHuomaiMoneyRuleService moneyRuleService;


	@ApiOperation("充值金额列表")
	@GetMapping("/moneyList")
	public AjaxResult<List<HuomaiMoneyRuleVo>> moneyList() {
		return AjaxResult.success(moneyRuleService.rechargeMoneyList());
	}

	@ApiOperation("充值接口")
	@PostMapping("/recharge")
	public AjaxResult recharge(@Validated @RequestBody HuomaiRechargeAddBo bo) {
		return orderService.recharge(bo);
	}
}
