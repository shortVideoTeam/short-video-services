package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiGiftConfigAddBo;
import com.huomai.business.bo.HuomaiGiftConfigEditBo;
import com.huomai.business.bo.HuomaiGiftConfigQueryBo;
import com.huomai.business.domain.HuomaiGiftConfig;
import com.huomai.business.mapper.HuomaiGiftConfigMapper;
import com.huomai.business.service.IHuomaiGiftConfigService;
import com.huomai.business.vo.HuomaiGiftConfigVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 红包金额配置Service业务层处理
 *
 * @author huomai
 * @date 2021-07-18
 */
@Service
public class HuomaiGiftConfigServiceImpl extends ServiceImpl<HuomaiGiftConfigMapper, HuomaiGiftConfig> implements IHuomaiGiftConfigService {

	@Override
	public HuomaiGiftConfigVo queryById(Long id) {
		return getVoById(id, HuomaiGiftConfigVo.class);
	}

	@Override
	public TableDataInfo<HuomaiGiftConfigVo> queryPageList(HuomaiGiftConfigQueryBo bo) {
		PagePlus<HuomaiGiftConfig, HuomaiGiftConfigVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiGiftConfigVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiGiftConfigVo> queryList(HuomaiGiftConfigQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiGiftConfigVo.class);
	}

	private LambdaQueryWrapper<HuomaiGiftConfig> buildQueryWrapper(HuomaiGiftConfigQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiGiftConfig> lqw = Wrappers.lambdaQuery();
		lqw.eq(bo.getTotalAmount() != null, HuomaiGiftConfig::getTotalAmount, bo.getTotalAmount());
		lqw.eq(bo.getSingleAmount() != null, HuomaiGiftConfig::getSingleAmount, bo.getSingleAmount());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiGiftConfigAddBo bo) {
		HuomaiGiftConfig add = BeanUtil.toBean(bo, HuomaiGiftConfig.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiGiftConfigEditBo bo) {
		HuomaiGiftConfig update = BeanUtil.toBean(bo, HuomaiGiftConfig.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiGiftConfig entity) {
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
