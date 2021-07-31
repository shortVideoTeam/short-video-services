package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiVideoCommentAddBo;
import com.huomai.business.bo.HuomaiVideoCommentEditBo;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.domain.HuomaiVideoComment;
import com.huomai.business.mapper.HuomaiVideoCommentMapper;
import com.huomai.business.service.IHuomaiVideoCommentService;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.business.vo.HuomaiVideoCommentVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * 评论Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoCommentServiceImpl extends ServiceImpl<HuomaiVideoCommentMapper, HuomaiVideoComment> implements IHuomaiVideoCommentService {

	@Autowired
	private HuomaiVideoCommentMapper commentMapper;

	@Autowired
	private IHuomaiVideoService videoService;

	@Override
	public HuomaiVideoCommentVo queryById(Long commentId) {
		return getVoById(commentId, HuomaiVideoCommentVo.class);
	}

	@Override
	public TableDataInfo<HuomaiVideoCommentVo> queryPageList(HuomaiVideoCommentQueryBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		List<HuomaiVideoCommentVo> vos = queryCommentWithUserList(bo);
		return PageUtils.buildDataInfo(vos);
	}

	/***
	 * @description: 用户评论列表
	 * @author chenshufeng
	 * @date: 2021/6/26 2:59 下午
	 */
	public List<HuomaiVideoCommentVo> queryCommentWithUserList(HuomaiVideoCommentQueryBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		return commentMapper.queryList(PageUtils.buildPage(), bo);
	}

	@Override
	public List<HuomaiVideoCommentVo> queryList(HuomaiVideoCommentQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiVideoCommentVo.class);
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean insertByAddBo(HuomaiVideoCommentAddBo bo) {
		HuomaiVideoComment add = BeanUtil.toBean(bo, HuomaiVideoComment.class);
		add.setUserId(SecurityUtils.getUserId());
		validEntityBeforeSave(add);

		changeCommentByVideoId(bo.getVideoId());

		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiVideoCommentEditBo bo) {
		HuomaiVideoComment update = BeanUtil.toBean(bo, HuomaiVideoComment.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiVideoComment entity) {
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
	 * @description: 评论列表
	 * @author chenshufeng
	 * @date: 2021/6/26 2:55 下午
	 */
	@Override
	public List<HuomaiVideoCommentVo> listWithReply(HuomaiVideoCommentQueryBo bo) {
		return queryCommentWithUserList(bo);
	}

	/**
	 * 更新视频评论数
	 */
	@Transactional(rollbackFor = Exception.class)
	public void changeCommentByVideoId(Long videoId) {
		HuomaiVideo video = videoService.getVoById(videoId, HuomaiVideo.class);
		HuomaiVideo update = new HuomaiVideo();
		update.setVideoId(videoId);
		update.setCommentNum(video.getCommentNum() + 1);
		videoService.updateById(update);
	}
}
