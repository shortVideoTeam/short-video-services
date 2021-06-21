package com.huomai.business.service.impl;

import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserAddBo;
import com.huomai.business.bo.HuomaiUserEditBo;
import com.huomai.business.bo.HuomaiUserQueryBo;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.mapper.HuomaiUserMapper;
import com.huomai.business.service.IHuomaiUserService;
import com.huomai.business.vo.HuomaiUserVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户信息Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserServiceImpl extends ServiceImpl<HuomaiUserMapper, HuomaiUser> implements IHuomaiUserService {

	@Override
	public HuomaiUserVo queryById(Long userId) {
		return getVoById(userId, HuomaiUserVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserVo> queryPageList(HuomaiUserQueryBo bo) {
		PagePlus<HuomaiUser, HuomaiUserVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiUserVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiUserVo> queryList(HuomaiUserQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiUserVo.class);
	}

	private LambdaQueryWrapper<HuomaiUser> buildQueryWrapper(HuomaiUserQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiUser> lqw = Wrappers.lambdaQuery();
		lqw.eq(StrUtil.isNotBlank(bo.getUuid()), HuomaiUser::getUuid, bo.getUuid());
		lqw.eq(StrUtil.isNotBlank(bo.getOpenid()), HuomaiUser::getOpenid, bo.getOpenid());
		lqw.eq(StrUtil.isNotBlank(bo.getUnionid()), HuomaiUser::getUnionid, bo.getUnionid());
		lqw.eq(StrUtil.isNotBlank(bo.getAvatar()), HuomaiUser::getAvatar, bo.getAvatar());
		lqw.like(StrUtil.isNotBlank(bo.getNickName()), HuomaiUser::getNickName, bo.getNickName());
		lqw.eq(StrUtil.isNotBlank(bo.getSex()), HuomaiUser::getSex, bo.getSex());
		lqw.eq(bo.getBirthday() != null, HuomaiUser::getBirthday, bo.getBirthday());
		lqw.eq(StrUtil.isNotBlank(bo.getPhone()), HuomaiUser::getPhone, bo.getPhone());
		lqw.eq(StrUtil.isNotBlank(bo.getConstellation()), HuomaiUser::getConstellation, bo.getConstellation());
		lqw.eq(bo.getProvince() != null, HuomaiUser::getProvince, bo.getProvince());
		lqw.eq(bo.getCity() != null, HuomaiUser::getCity, bo.getCity());
		lqw.eq(bo.getArea() != null, HuomaiUser::getArea, bo.getArea());
		lqw.eq(StrUtil.isNotBlank(bo.getAddress()), HuomaiUser::getAddress, bo.getAddress());
		lqw.eq(StrUtil.isNotBlank(bo.getDesc()), HuomaiUser::getDesc, bo.getDesc());
		return lqw;
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


	@Override
	public HashMap<Object, Object> updateUserPhone(WxMaPhoneNumberInfo phoneNoInfo, String openId) {
		return null;
	}
}
