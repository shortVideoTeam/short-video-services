package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.domain.HuomaiVideoCommentReply;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 回复Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiVideoCommentReplyMapper extends BaseMapperPlus<HuomaiVideoCommentReply> {

	/***
	 * @description: 回复列表
	 * @author chenshufeng
	 * @date: 2021/6/26 3:08 下午
	 */
	List<HuomaiVideoCommentReplyVo> batchQueryReplyListByCommentIds(@Param("cIdList") List<Long> cIdList, @Param("userId") Long userId);

	/***
	 * @description: 回复列表
	 * @author chenshufeng
	 * @date: 2021/6/26 3:29 下午
	 */
	List<HuomaiVideoCommentReplyVo> queryReplyList(@Param("page") Page page, @Param("bo") HuomaiVideoCommentReplyQueryBo bo, @Param("userId") Long userId);
}
