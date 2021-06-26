package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserAddBo;
import com.huomai.business.bo.HuomaiUserEditBo;
import com.huomai.business.bo.HuomaiUserQueryBo;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.mapper.HuomaiUserMapper;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.business.vo.HuomaiUserVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 用户信息Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserServiceImpl extends ServiceImpl<HuomaiUserMapper, HuomaiUser> implements IHuomaiUserService {

	@Autowired
	private HuomaiUserMapper userMapper;

	@Override
	public HuomaiUserVo queryById(Long userId) {
		return getVoById(userId, HuomaiUserVo.class);
	}

	/***
	 * @description: 用户列表
	 * @author chenshufeng
	 * @date: 2021/6/26 12:38 下午
	 */
	@Override
	public TableDataInfo<HuomaiUserVo> queryPageList(HuomaiUserQueryBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		List<HuomaiUserVo> userVos = userMapper.queryUserList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(userVos);
	}

	@Override
	public List<HuomaiUserVo> queryList(HuomaiUserQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiUserVo.class);
	}


	@Override
	public Boolean insertByAddBo(HuomaiUserAddBo bo) {
		HuomaiUser add = BeanUtil.toBean(bo, HuomaiUser.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiUserEditBo bo) {
		HuomaiUser update = BeanUtil.toBean(bo, HuomaiUser.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUser entity) {
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
