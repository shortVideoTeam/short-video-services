package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserInviteAddBo;
import com.huomai.business.bo.HuomaiUserInviteEditBo;
import com.huomai.business.bo.HuomaiUserInviteQueryBo;
import com.huomai.business.domain.HuomaiUserInvite;
import com.huomai.business.mapper.HuomaiUserInviteMapper;
import com.huomai.business.service.IHuomaiUserInviteService;
import com.huomai.business.vo.HuomaiUserInviteVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 邀请记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserInviteServiceImpl extends ServiceImpl<HuomaiUserInviteMapper, HuomaiUserInvite> implements IHuomaiUserInviteService {

	@Autowired
	private HuomaiUserInviteMapper inviteMapper;

	@Override
	public HuomaiUserInviteVo queryById(Long id) {
		return getVoById(id, HuomaiUserInviteVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserInviteVo> queryPageList(HuomaiUserInviteQueryBo bo) {
		PagePlus<HuomaiUserInvite, HuomaiUserInviteVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiUserInviteVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiUserInviteVo> queryList(HuomaiUserInviteQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiUserInviteVo.class);
	}

	private LambdaQueryWrapper<HuomaiUserInvite> buildQueryWrapper(HuomaiUserInviteQueryBo bo) {
		LambdaQueryWrapper<HuomaiUserInvite> lqw = Wrappers.lambdaQuery();
		lqw.eq(bo.getUserId() != null, HuomaiUserInvite::getUserId, SecurityUtils.getUserId());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiUserInviteAddBo bo) {
		HuomaiUserInvite add = BeanUtil.toBean(bo, HuomaiUserInvite.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiUserInviteEditBo bo) {
		HuomaiUserInvite update = BeanUtil.toBean(bo, HuomaiUserInvite.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUserInvite entity) {
		//TODO 做一些数据校验,如唯一约束
	}

	@Override
	public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
		if (isValid) {
			//TODO 做一些业务上的校验,判断是否需要校验
		}
		return removeByIds(ids);
	}

	@Override
	public HuomaiUserInviteVo myUserInvite() {
		return inviteMapper.myUserInvite(SecurityUtils.getUserId());
	}

	@Override
	public TableDataInfo myInviteList(HuomaiUserInviteQueryBo bo) {
		bo.setUserId(SecurityUtils.getUserId());
		return PageUtils.buildDataInfo(inviteMapper.myInviteList(PageUtils.buildPage(), bo));
	}

}
