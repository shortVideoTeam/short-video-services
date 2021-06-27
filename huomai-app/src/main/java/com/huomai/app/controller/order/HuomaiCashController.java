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

import com.huomai.business.bo.HuomaiCashAddBo;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Api(value = "提现模块", tags = {"提现管理"})
@RestController
@RequestMapping("/business/cash")
@AllArgsConstructor
public class HuomaiCashController {

	@Autowired
	private IHuomaiOrderService orderService;

	@Autowired
	private IHuomaiMoneyRuleService moneyRuleService;


	@ApiOperation("提现金额列表")
	@GetMapping("/cashMoneyList")
	public AjaxResult<List<HuomaiMoneyRuleVo>> cashMoneyList() {
		return AjaxResult.success(moneyRuleService.cashMoneyList());
	}

	@ApiOperation("提现申请接口")
	@GetMapping("/cashApply")
	public AjaxResult cashApply(@Validated @RequestBody HuomaiCashAddBo bo) {
		return orderService.cashApply(bo);
	}
}
