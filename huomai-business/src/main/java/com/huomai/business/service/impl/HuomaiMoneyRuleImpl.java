package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.huomai.business.mapper.HuomaiCashRuleMapper;
import com.huomai.business.mapper.HuomaiRechargeRuleMapper;
import com.huomai.business.service.IHuomaiMoneyRuleService;
import com.huomai.business.vo.HuomaiMoneyRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HuomaiMoneyRuleImpl implements IHuomaiMoneyRuleService {

	@Autowired
	private HuomaiRechargeRuleMapper rechargeRuleMapper;

	@Autowired
	private HuomaiCashRuleMapper casheRuleMapper;

	@Override
	public List<HuomaiMoneyRuleVo> rechargeMoneyList() {
		return rechargeRuleMapper.selectList(Wrappers.emptyWrapper()).stream().map(rule -> BeanUtil.toBean(rule, HuomaiMoneyRuleVo.class)).collect(Collectors.toList());
	}

	@Override
	public List<HuomaiMoneyRuleVo> cashMoneyList() {
		return casheRuleMapper.selectList(Wrappers.emptyWrapper()).stream().map(rule -> BeanUtil.toBean(rule, HuomaiMoneyRuleVo.class)).collect(Collectors.toList());
	}
}
