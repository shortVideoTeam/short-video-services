package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiVideoAddBo;
import com.huomai.business.bo.HuomaiVideoEditBo;
import com.huomai.business.bo.HuomaiVideoQueryBo;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.mapper.HuomaiVideoMapper;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.business.vo.HuomaiVideoVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 视频信息Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoServiceImpl extends ServiceImpl<HuomaiVideoMapper, HuomaiVideo> implements IHuomaiVideoService {

	@Override
	public HuomaiVideoVo queryById(Long videoId) {
		return getVoById(videoId, HuomaiVideoVo.class);
	}

	@Override
	public TableDataInfo<HuomaiVideoVo> queryPageList(HuomaiVideoQueryBo bo) {
		PagePlus<HuomaiVideo, HuomaiVideoVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiVideoVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiVideoVo> queryList(HuomaiVideoQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiVideoVo.class);
	}

	private LambdaQueryWrapper<HuomaiVideo> buildQueryWrapper(HuomaiVideoQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiVideo> lqw = Wrappers.lambdaQuery();
		lqw.eq(bo.getUserId() != null, HuomaiVideo::getUserId, bo.getUserId());
		lqw.eq(StrUtil.isNotBlank(bo.getTitle()), HuomaiVideo::getTitle, bo.getTitle());
		lqw.eq(StrUtil.isNotBlank(bo.getVideoUrl()), HuomaiVideo::getVideoUrl, bo.getVideoUrl());
		lqw.eq(bo.getDuration() != null, HuomaiVideo::getDuration, bo.getDuration());
		lqw.eq(StrUtil.isNotBlank(bo.getTopic()), HuomaiVideo::getTopic, bo.getTopic());
		lqw.eq(StrUtil.isNotBlank(bo.getBuddy()), HuomaiVideo::getBuddy, bo.getBuddy());
		lqw.eq(StrUtil.isNotBlank(bo.getVisible()), HuomaiVideo::getVisible, bo.getVisible());
		lqw.eq(StrUtil.isNotBlank(bo.getStatus()), HuomaiVideo::getStatus, bo.getStatus());
		lqw.eq(bo.getStarNum() != null, HuomaiVideo::getStarNum, bo.getStarNum());
		lqw.eq(bo.getCommentNum() != null, HuomaiVideo::getCommentNum, bo.getCommentNum());
		lqw.eq(bo.getViewNum() != null, HuomaiVideo::getViewNum, bo.getViewNum());
		lqw.eq(StrUtil.isNotBlank(bo.getKeywordId()), HuomaiVideo::getKeywordId, bo.getKeywordId());
		return lqw;
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
}
