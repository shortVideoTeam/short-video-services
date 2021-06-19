package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserWalleAddBo;
import com.huomai.business.bo.HuomaiUserWalleEditBo;
import com.huomai.business.bo.HuomaiUserWalleQueryBo;
import com.huomai.business.domain.HuomaiUserWalle;
import com.huomai.business.mapper.HuomaiUserWalleMapper;
import com.huomai.business.service.IHuomaiUserWalleService;
import com.huomai.business.vo.HuomaiUserWalleVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 钱包明细Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserWalleServiceImpl extends ServiceImpl<HuomaiUserWalleMapper, HuomaiUserWalle> implements IHuomaiUserWalleService {

	@Override
	public HuomaiUserWalleVo queryById(Long id) {
		return getVoById(id, HuomaiUserWalleVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserWalleVo> queryPageList(HuomaiUserWalleQueryBo bo) {
		PagePlus<HuomaiUserWalle, HuomaiUserWalleVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiUserWalleVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiUserWalleVo> queryList(HuomaiUserWalleQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiUserWalleVo.class);
	}

	private LambdaQueryWrapper<HuomaiUserWalle> buildQueryWrapper(HuomaiUserWalleQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiUserWalle> lqw = Wrappers.lambdaQuery();
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiUserWalleAddBo bo) {
		HuomaiUserWalle add = BeanUtil.toBean(bo, HuomaiUserWalle.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiUserWalleEditBo bo) {
		HuomaiUserWalle update = BeanUtil.toBean(bo, HuomaiUserWalle.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUserWalle entity) {
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
