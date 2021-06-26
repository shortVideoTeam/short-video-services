package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.*;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.mapper.HuomaiVideoMapper;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.business.vo.HuomaiVideoAttendVo;
import com.huomai.business.vo.HuomaiVideoHotVo;
import com.huomai.business.vo.HuomaiVideoVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 视频信息Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoServiceImpl extends ServiceImpl<HuomaiVideoMapper, HuomaiVideo> implements IHuomaiVideoService {

	@Autowired
	private HuomaiVideoMapper videoMapper;

	@Override
	public HuomaiVideoVo queryById(Long videoId) {
		return getVoById(videoId, HuomaiVideoVo.class);
	}

	@Override
	public TableDataInfo<HuomaiVideoVo> queryPageList(HuomaiVideoQueryBo bo) {
		PagePlus<HuomaiVideo, HuomaiVideoVo> result = pageVo(PageUtils.buildPagePlus(), Wrappers.emptyWrapper(), HuomaiVideoVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiVideoVo> queryList(HuomaiVideoQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiVideoVo.class);
	}

	@Override
	public Boolean insertByAddBo(HuomaiVideoAddBo bo) {
		HuomaiVideo add = BeanUtil.toBean(bo, HuomaiVideo.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiVideoEditBo bo) {
		HuomaiVideo update = BeanUtil.toBean(bo, HuomaiVideo.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiVideo entity) {
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
	 * @description: 热门
	 * @author chenshufeng
	 * @date: 2021/6/25 3:38 下午
	 */
	@Override
	public TableDataInfo<HuomaiVideoHotVo> hotList(HuomaiVideoHotBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		List<HuomaiVideoHotVo> videoVos = videoMapper.hotList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(videoVos);
	}

	/***
	 * @description: 关注列表
	 * @author chenshufeng
	 * @date: 2021/6/26 12:15 下午
	 */
	@Override
	public TableDataInfo<HuomaiVideoAttendVo> attendList(HuomaiVideoAttendBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		List<HuomaiVideoAttendVo> videoVos = videoMapper.attendList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(videoVos);
	}
}
