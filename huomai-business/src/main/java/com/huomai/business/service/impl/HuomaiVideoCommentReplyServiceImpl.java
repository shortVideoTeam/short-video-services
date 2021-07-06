package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiVideoCommentReplyAddBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyEditBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.domain.HuomaiVideoCommentReply;
import com.huomai.business.mapper.HuomaiVideoCommentReplyMapper;
import com.huomai.business.service.IHuomaiVideoCommentReplyService;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 回复Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiVideoCommentReplyServiceImpl extends ServiceImpl<HuomaiVideoCommentReplyMapper, HuomaiVideoCommentReply> implements IHuomaiVideoCommentReplyService {

	@Autowired
	private HuomaiVideoCommentReplyMapper replyMapper;

	@Override
	public HuomaiVideoCommentReplyVo queryById(Long id) {
		return getVoById(id, HuomaiVideoCommentReplyVo.class);
	}

	/***
	 * @description: 回复列表
	 * @author chenshufeng
	 * @date: 2021/6/26 3:32 下午
	 */
	@Override
	public TableDataInfo<HuomaiVideoCommentReplyVo> queryPageList(HuomaiVideoCommentReplyQueryBo bo) {
		bo.setCurUserId(SecurityUtils.getUserId());
		List<HuomaiVideoCommentReplyVo> vos = replyMapper.queryReplyList(PageUtils.buildPage(), bo, SecurityUtils.getUserId());
		return PageUtils.buildDataInfo(vos);
	}

	@Override
	public List<HuomaiVideoCommentReplyVo> queryList(HuomaiVideoCommentReplyQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiVideoCommentReplyVo.class);
	}

	/***
	 * @description: 新增回复
	 * @author chenshufeng
	 * @date: 2021/6/26 3:34 下午
	 */
	@Override
	public Boolean insertByAddBo(HuomaiVideoCommentReplyAddBo bo) {
		HuomaiVideoCommentReply add = BeanUtil.toBean(bo, HuomaiVideoCommentReply.class);
		validEntityBeforeSave(add);
		//回复用户ID
		add.setReplyUserId(SecurityUtils.getUserId());
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

	/***
	 * @description: 回复列表查询
	 * @author chenshufeng
	 * @date: 2021/6/26 3:07 下午
	 */
	@Override
	public Map<Long, List<HuomaiVideoCommentReplyVo>> batchQueryReplyListByCommentIds(List<Long> cIdList) {
		List<HuomaiVideoCommentReplyVo> vos = replyMapper.batchQueryReplyListByCommentIds(cIdList, SecurityUtils.getUserId());
		return vos.stream().collect(Collectors.groupingBy(HuomaiVideoCommentReplyVo::getCommentId));
	}
}
