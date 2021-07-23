package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserLoveAddBo;
import com.huomai.business.domain.HuomaiUserLove;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.domain.HuomaiVideoComment;
import com.huomai.business.domain.HuomaiVideoCommentReply;
import com.huomai.business.mapper.HuomaiUserLoveMapper;
import com.huomai.business.service.IHuomaiUserLoveService;
import com.huomai.business.service.IHuomaiVideoCommentReplyService;
import com.huomai.business.service.IHuomaiVideoCommentService;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 点赞记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserLoveServiceImpl extends ServiceImpl<HuomaiUserLoveMapper, HuomaiUserLove> implements IHuomaiUserLoveService {

	@Autowired
	private HuomaiUserLoveMapper loveMapper;

	@Autowired
	private IHuomaiVideoService videoService;

	@Autowired
	private IHuomaiVideoCommentService commentService;

	@Autowired
	private IHuomaiVideoCommentReplyService replyService;


	/***
	 * @description: 新增点赞记录
	 * @author chenshufeng
	 * @date: 2021/6/26 2:47 下午
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean insertByAddBo(HuomaiUserLoveAddBo bo) {

		//存在则取消，不存在则新增
		Long userId = SecurityUtils.getUserId();
		Integer type = bo.getType();
		LambdaQueryWrapper<HuomaiUserLove> queryWrapper = Wrappers.<HuomaiUserLove>lambdaQuery().eq(HuomaiUserLove::getBusinessId, bo.getBusinessId()).eq(HuomaiUserLove::getUserId, userId);
		List<HuomaiUserLove> loveList = loveMapper.selectList(queryWrapper);
		if (loveList == null || loveList.size() == 0) {
			HuomaiUserLove add = BeanUtil.toBean(bo, HuomaiUserLove.class);
			validEntityBeforeSave(add);
			//点赞人
			add.setUserId(userId);
			//更新点赞数量
			changeStar(bo.getBusinessId(), type, 1);

			return save(add);
		} else {
			List<Long> ids = loveList.stream().map(HuomaiUserLove::getId).collect(Collectors.toList());
			if (ids.size() > 0) {
				loveMapper.deleteBatchIds(ids);
			}
			//更新点赞数量
			changeStar(bo.getBusinessId(), type, -1);

			return Boolean.TRUE;
		}

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

	/**
	 * 更新点赞数
	 */
	@Transactional(rollbackFor = Exception.class)
	public void changeStar(Long businessId, Integer type, int num) {
		if (1 == type) {
			HuomaiVideo video = videoService.getVoById(businessId, HuomaiVideo.class);
			long curNum = Optional.ofNullable(video.getStarNum()).orElse(0L) + (num);
			HuomaiVideo update = new HuomaiVideo();
			update.setVideoId(businessId);
			update.setStarNum(curNum > 0 ? curNum : 0);
			videoService.updateById(update);
		} else if (2 == type) {
			HuomaiVideoComment comment = commentService.getVoById(businessId, HuomaiVideoComment.class);
			long curNum = Optional.ofNullable(comment.getStarNum()).orElse(0L) + (num);
			HuomaiVideoComment update = new HuomaiVideoComment();
			update.setCommentId(businessId);
			update.setStarNum(curNum > 0 ? curNum : 0);
			commentService.updateById(update);
		} else if (3 == type) {
			HuomaiVideoCommentReply reply = replyService.getVoById(businessId, HuomaiVideoCommentReply.class);
			long curNum = Optional.ofNullable(reply.getStar()).orElse(0L) + (num);
			HuomaiVideoCommentReply update = new HuomaiVideoCommentReply();
			update.setId(businessId);
			update.setStar(curNum > 0 ? curNum : 0);
			replyService.updateById(update);
		}

	}
}
