package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserFollowAddBo;
import com.huomai.business.bo.HuomaiUserFollowEditBo;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.domain.HuomaiUserFollow;
import com.huomai.business.mapper.HuomaiUserFollowMapper;
import com.huomai.business.service.IHuomaiUserFollowService;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.business.vo.HuomaiUserVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 用户关注Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserFollowServiceImpl extends ServiceImpl<HuomaiUserFollowMapper, HuomaiUserFollow> implements IHuomaiUserFollowService {

	@Autowired
	private HuomaiUserFollowMapper followMapper;

	@Override
	public HuomaiUserFollowVo queryById(Long userId) {
		return getVoById(userId, HuomaiUserFollowVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserFollowVo> queryPageList(HuomaiUserFollowQueryBo bo) {
		return PageUtils.buildDataInfo(followMapper.queryList(PageUtils.buildPage(), bo));
	}

	@Override
	public List<HuomaiUserFollowVo> queryList(HuomaiUserFollowQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiUserFollowVo.class);
	}


	@Override
	public Boolean insertByAddBo(HuomaiUserFollowAddBo bo) {
		HuomaiUserFollow add = BeanUtil.toBean(bo, HuomaiUserFollow.class);
		add.setUserId(SecurityUtils.getUserId());
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

	/***
	 * @description: 关注列表
	 * @author chenshufeng
	 * @date: 2021/6/26 5:11 下午
	 */
	@Override
	public TableDataInfo<HuomaiUserFollowVo> attendList(HuomaiUserFollowQueryBo bo) {
		bo.setType(1);
		bo.setCurUserId(SecurityUtils.getUserId());
		return PageUtils.buildDataInfo(followMapper.userFollowList(PageUtils.buildPage(), bo));
	}

	/***
	 * @description: 粉丝列表
	 * @author chenshufeng
	 * @date: 2021/6/26 5:11 下午
	 */
	@Override
	public TableDataInfo<HuomaiUserFollowVo> followMeList(HuomaiUserFollowQueryBo bo) {
		bo.setType(2);
		bo.setCurUserId(SecurityUtils.getUserId());
		return PageUtils.buildDataInfo(followMapper.userFollowList(PageUtils.buildPage(), bo));
	}

	/***
	* @description: 我的好友列表
	* @author chenshufeng
	* @date: 2021/6/26 5:58 下午
	*/
	@Override
	public TableDataInfo<HuomaiUserFollowVo> friendsList(HuomaiUserFollowQueryBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		return PageUtils.buildDataInfo(followMapper.friendsList(PageUtils.buildPage(),bo));
	}
}
