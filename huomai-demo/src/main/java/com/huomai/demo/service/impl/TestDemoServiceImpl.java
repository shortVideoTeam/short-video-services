package com.huomai.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.common.annotation.DataScope;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.demo.bo.TestDemoAddBo;
import com.huomai.demo.bo.TestDemoEditBo;
import com.huomai.demo.bo.TestDemoQueryBo;
import com.huomai.demo.domain.TestDemo;
import com.huomai.demo.mapper.TestDemoMapper;
import com.huomai.demo.service.ITestDemoService;
import com.huomai.demo.vo.TestDemoVo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 测试单表Service业务层处理
 *
 * @author Lion Li
 * @date 2021-05-30
 */
@Service
public class TestDemoServiceImpl extends ServiceImpl<TestDemoMapper, TestDemo> implements ITestDemoService {

	@Override
	public TestDemoVo queryById(Long id) {
		return getVoById(id, TestDemoVo.class);
	}

	@DataScope(isUser = true)
	@Override
	public TableDataInfo<TestDemoVo> queryPageList(TestDemoQueryBo bo) {
		PagePlus<TestDemo, TestDemoVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), TestDemoVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@DataScope(isUser = true)
	@Override
	public List<TestDemoVo> queryList(TestDemoQueryBo bo) {
		return listVo(buildQueryWrapper(bo), TestDemoVo.class);
	}

	private LambdaQueryWrapper<TestDemo> buildQueryWrapper(TestDemoQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		Object dataScope = params.get("dataScope");
		LambdaQueryWrapper<TestDemo> lqw = Wrappers.lambdaQuery();
		lqw.like(StrUtil.isNotBlank(bo.getTestKey()), TestDemo::getTestKey, bo.getTestKey());
		lqw.eq(StrUtil.isNotBlank(bo.getValue()), TestDemo::getValue, bo.getValue());
		lqw.between(params.get("beginCreateTime") != null && params.get("endCreateTime") != null,
			TestDemo::getCreateTime, params.get("beginCreateTime"), params.get("endCreateTime"));
		lqw.apply(dataScope != null && StrUtil.isNotBlank(dataScope.toString()),
			dataScope != null ? dataScope.toString() : null);
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(TestDemoAddBo bo) {
		TestDemo add = BeanUtil.toBean(bo, TestDemo.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(TestDemoEditBo bo) {
		TestDemo update = BeanUtil.toBean(bo, TestDemo.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(TestDemo entity) {
		//TODO 做一些数据校验,如唯一约束
	}

	@Override
	public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
		if (isValid) {
			//TODO 做一些业务上的校验,判断是否需要校验
		}
		return removeByIds(ids);
	}
}
