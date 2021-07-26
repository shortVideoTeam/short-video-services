package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
import jodd.util.StringUtil;
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

	/***
	 * @description: 视频详情
	 * @author chenshufeng
	 * @date: 2021/6/26 2:08 下午
	 */
	@Override
	public HuomaiVideoHotVo queryById(Long videoId) {
		HuomaiVideoHotBo hotBo = new HuomaiVideoHotBo();
		hotBo.setVideoId(videoId);
		List<HuomaiVideoHotVo> vos = queryList(hotBo);
		if (vos.size() > 0) {
			return vos.get(0);
		}
		return new HuomaiVideoHotVo();
	}

	/***
	 * @description: 视频列表
	 * @author chenshufeng
	 * @date: 2021/6/26 4:14 下午
	 */
	@Override
	public TableDataInfo<HuomaiVideoVo> queryPageList(HuomaiVideoQueryBo bo) {
		LambdaQueryWrapper<HuomaiVideo> queryWrapper = Wrappers.lambdaQuery();
		queryWrapper.eq(HuomaiVideo::getStatus, 1);
		queryWrapper.eq(bo.getUserId() != null, HuomaiVideo::getUserId, bo.getUserId());
		Integer type = bo.getType();
		if (type == 1) {

		} else if (type == 2) {
			//私密
			queryWrapper.eq(HuomaiVideo::getVisible, 0);
		} else if (type == 3) {
			//赞过
			queryWrapper.lt(HuomaiVideo::getStarNum, 0);
		}
		queryWrapper.orderByDesc(HuomaiVideo::getCreateTime);
		PagePlus<HuomaiVideo, HuomaiVideoVo> result = pageVo(PageUtils.buildPagePlus(), queryWrapper, HuomaiVideoVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiVideoVo> queryList(HuomaiVideoQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiVideoVo.class);
	}

	/***
	 * @description: 发布视频
	 * @author chenshufeng
	 * @date: 2021/6/26 2:20 下午
	 */
	@Override
	public Boolean insertByAddBo(HuomaiVideoAddBo bo) {
		HuomaiVideo add = BeanUtil.toBean(bo, HuomaiVideo.class);
		validEntityBeforeSave(add);
		//发布人
		add.setUserId(SecurityUtils.getUserId());
		//发布状态
		add.setStatus("0");
		return save(add);
	}

	/***
	 * @description: 编辑视频
	 * @author chenshufeng
	 * @date: 2021/6/26 2:20 下午
	 */
	@Override
	public Boolean updateByEditBo(HuomaiVideoEditBo bo) {
		HuomaiVideo update = BeanUtil.toBean(bo, HuomaiVideo.class);
		validEntityBeforeSave(update);
		//重置发布状态
		update.setStatus("0");
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
		List<HuomaiVideoHotVo> videoVos = queryList(bo);
		return PageUtils.buildDataInfo(videoVos);
	}

	/***
	 * @description: 视频列表
	 * @author chenshufeng
	 * @date: 2021/6/26 2:11 下午
	 */
	public List<HuomaiVideoHotVo> queryList(HuomaiVideoHotBo bo) {
		return videoMapper.hotList(PageUtils.buildPage(), bo);
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

	@Override
	public TableDataInfo<HuomaiVideoVo> videoList(HuomaiVideoQueryBo bo) {
		bo.setUserId(SecurityUtils.getUserId());
		return queryPageList(bo);
	}

	@Override
	public TableDataInfo<HuomaiVideoAttendVo> searchList(HuomaiVideoSearchBo bo) {
		List<HuomaiVideoAttendVo> videoVos = videoMapper.searchList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(videoVos);
	}

	@Override
	public Boolean updateVideoShare(Long videoId) {
		HuomaiVideoEditBo bo = new HuomaiVideoEditBo();
		bo.setVideoId(videoId);
		HuomaiVideo update = BeanUtil.toBean(bo, HuomaiVideo.class);
		update.setShareNum(update.getShareNum()+1);
		return updateById(update);
	}
}
