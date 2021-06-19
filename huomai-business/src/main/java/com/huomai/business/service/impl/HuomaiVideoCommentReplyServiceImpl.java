package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiVideoCommentReplyAddBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyEditBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.domain.HuomaiVideoCommentReply;
import com.huomai.business.mapper.HuomaiVideoCommentReplyMapper;
import com.huomai.business.service.IHuomaiVideoCommentReplyService;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 回复Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoCommentReplyServiceImpl extends ServiceImpl<HuomaiVideoCommentReplyMapper, HuomaiVideoCommentReply> implements IHuomaiVideoCommentReplyService {

	@Override
	public HuomaiVideoCommentReplyVo queryById(Long id) {
		return getVoById(id, HuomaiVideoCommentReplyVo.class);
	}

	@Override
	public TableDataInfo<HuomaiVideoCommentReplyVo> queryPageList(HuomaiVideoCommentReplyQueryBo bo) {
		PagePlus<HuomaiVideoCommentReply, HuomaiVideoCommentReplyVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiVideoCommentReplyVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiVideoCommentReplyVo> queryList(HuomaiVideoCommentReplyQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiVideoCommentReplyVo.class);
	}

	private LambdaQueryWrapper<HuomaiVideoCommentReply> buildQueryWrapper(HuomaiVideoCommentReplyQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiVideoCommentReply> lqw = Wrappers.lambdaQuery();
		lqw.eq(StrUtil.isNotBlank(bo.getReplyType()), HuomaiVideoCommentReply::getReplyType, bo.getReplyType());
		lqw.eq(bo.getCommentId() != null, HuomaiVideoCommentReply::getCommentId, bo.getCommentId());
		lqw.eq(bo.getReplyId() != null, HuomaiVideoCommentReply::getReplyId, bo.getReplyId());
		lqw.eq(StrUtil.isNotBlank(bo.getContent()), HuomaiVideoCommentReply::getContent, bo.getContent());
		lqw.eq(bo.getReplyUserId() != null, HuomaiVideoCommentReply::getReplyUserId, bo.getReplyUserId());
		lqw.eq(bo.getToUserId() != null, HuomaiVideoCommentReply::getToUserId, bo.getToUserId());
		lqw.eq(bo.getStar() != null, HuomaiVideoCommentReply::getStar, bo.getStar());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiVideoCommentReplyAddBo bo) {
		HuomaiVideoCommentReply add = BeanUtil.toBean(bo, HuomaiVideoCommentReply.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiVideoCommentReplyEditBo bo) {
		HuomaiVideoCommentReply update = BeanUtil.toBean(bo, HuomaiVideoCommentReply.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiVideoCommentReply entity) {
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
