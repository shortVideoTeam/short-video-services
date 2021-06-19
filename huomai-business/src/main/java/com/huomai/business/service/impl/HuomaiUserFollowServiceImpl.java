package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserFollowAddBo;
import com.huomai.business.bo.HuomaiUserFollowEditBo;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.domain.HuomaiUserFollow;
import com.huomai.business.mapper.HuomaiUserFollowMapper;
import com.huomai.business.service.IHuomaiUserFollowService;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 用户关注Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserFollowServiceImpl extends ServiceImpl<HuomaiUserFollowMapper, HuomaiUserFollow> implements IHuomaiUserFollowService {

	@Override
	public HuomaiUserFollowVo queryById(Long userId) {
		return getVoById(userId, HuomaiUserFollowVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserFollowVo> queryPageList(HuomaiUserFollowQueryBo bo) {
		PagePlus<HuomaiUserFollow, HuomaiUserFollowVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiUserFollowVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiUserFollowVo> queryList(HuomaiUserFollowQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiUserFollowVo.class);
	}

	private LambdaQueryWrapper<HuomaiUserFollow> buildQueryWrapper(HuomaiUserFollowQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiUserFollow> lqw = Wrappers.lambdaQuery();
		lqw.eq(bo.getFollowUserId() != null, HuomaiUserFollow::getFollowUserId, bo.getFollowUserId());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiUserFollowAddBo bo) {
		HuomaiUserFollow add = BeanUtil.toBean(bo, HuomaiUserFollow.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiUserFollowEditBo bo) {
		HuomaiUserFollow update = BeanUtil.toBean(bo, HuomaiUserFollow.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUserFollow entity) {
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
