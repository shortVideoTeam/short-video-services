package com.huomai.business.service;

import com.huomai.business.vo.HuomaiMoneyRuleVo;

import java.util.List;

/**
 * 视频信息Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiMoneyRuleService {

	List<HuomaiMoneyRuleVo> rechargeMoneyList();

	List<HuomaiMoneyRuleVo> cashMoneyList();
}
