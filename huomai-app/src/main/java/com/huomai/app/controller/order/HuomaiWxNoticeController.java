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

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.huomai.business.service.IHuomaiOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@ApiIgnore
@RestController
@RequestMapping("/business/wxpay")
@AllArgsConstructor
public class HuomaiWxNoticeController {

	/**
	 * 小程序支付
	 */
	@Autowired
	private WxPayService wxMiniPayService;
	@Autowired
	private IHuomaiOrderService orderService;

	/**
	 * 微信支付回调
	 *
	 * @param xmlData
	 * @return
	 */
	@RequestMapping("/callback")
	public String callback(@RequestBody String xmlData) {
		log.info("微信支付回调========");
		log.info(xmlData);
		try {
			WxPayOrderNotifyResult parseOrderNotifyResult = wxMiniPayService.parseOrderNotifyResult(xmlData);
			String payNo = parseOrderNotifyResult.getOutTradeNo();
			String bizPayNo = parseOrderNotifyResult.getTransactionId();
			// 根据内部订单号更新order
			orderService.paySuccess(payNo, bizPayNo);
		} catch (Exception e) {
			log.error("回调处理失败：", e);
			return WxPayNotifyResponse.failResp("失败");
		}
		return WxPayNotifyResponse.success("成功");
	}
}
