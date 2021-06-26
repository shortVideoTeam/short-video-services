package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserLoveAddBo;
import com.huomai.business.bo.HuomaiVideoLoveEditBo;
import com.huomai.business.bo.HuomaiVideoLoveQueryBo;
import com.huomai.business.domain.HuomaiUserLove;
import com.huomai.business.mapper.HuomaiVideoLoveMapper;
import com.huomai.business.service.IHuomaiVideoLoveService;
import com.huomai.business.vo.HuomaiVideoLoveVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 点赞记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoLoveServiceImpl extends ServiceImpl<HuomaiVideoLoveMapper, HuomaiUserLove> implements IHuomaiVideoLoveService {

	@Override
	public HuomaiVideoLoveVo queryById(Long id) {
		return getVoById(id, HuomaiVideoLoveVo.class);
	}

	@Override
	public TableDataInfo<HuomaiVideoLoveVo> queryPageList(HuomaiVideoLoveQueryBo bo) {
		PagePlus<HuomaiUserLove, HuomaiVideoLoveVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiVideoLoveVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiVideoLoveVo> queryList(HuomaiVideoLoveQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiVideoLoveVo.class);
	}

	private LambdaQueryWrapper<HuomaiUserLove> buildQueryWrapper(HuomaiVideoLoveQueryBo bo) {
		LambdaQueryWrapper<HuomaiUserLove> lqw = Wrappers.lambdaQuery();
		lqw.eq(bo.getBusinessId() != null, HuomaiUserLove::getBusinessId, bo.getBusinessId());
		lqw.eq(bo.getUserId() != null, HuomaiUserLove::getUserId, bo.getUserId());
		return lqw;
	}

	/***
	 * @description: 新增点赞记录
	 * @author chenshufeng
	 * @date: 2021/6/26 2:47 下午
	 */
	@Override
	public Boolean insertByAddBo(HuomaiUserLoveAddBo bo) {
		HuomaiUserLove add = BeanUtil.toBean(bo, HuomaiUserLove.class);
		validEntityBeforeSave(add);
		//点赞人
		add.setUserId(SecurityUtils.getUserId());
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiVideoLoveEditBo bo) {
		HuomaiUserLove update = BeanUtil.toBean(bo, HuomaiUserLove.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUserLove entity) {
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
