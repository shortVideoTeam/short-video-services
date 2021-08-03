package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.domain.HuomaiVideoComment;
import com.huomai.business.vo.HuomaiVideoCommentVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiVideoCommentMapper extends BaseMapperPlus<HuomaiVideoComment> {

	/***
	* @description: 评论列表
	* @author chenshufeng
	* @date: 2021/6/26 2:26 下午
	*/
    List<HuomaiVideoCommentVo> queryList(@Param("page") Page page, @Param("bo") HuomaiVideoCommentQueryBo bo);
}
