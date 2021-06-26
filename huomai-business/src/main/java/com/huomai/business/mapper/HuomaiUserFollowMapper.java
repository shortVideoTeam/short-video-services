package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiUserFollowQueryBo;
import com.huomai.business.domain.HuomaiUserFollow;
import com.huomai.business.vo.HuomaiUserFollowVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户关注Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiUserFollowMapper extends BaseMapperPlus<HuomaiUserFollow> {

	List<HuomaiUserFollowVo> queryList(@Param("page") Page page, @Param("bo") HuomaiUserFollowQueryBo bo);

	/***
	 * @description: 关注|粉丝列表
	 * @author chenshufeng
	 * @date: 2021/6/26 5:06 下午
	 */
	List<HuomaiUserFollowVo> userFollowList(@Param("page") Page page, @Param("bo") HuomaiUserFollowQueryBo bo);

	/***
	 * @description: 互相关注列表
	 * @author chenshufeng
	 * @date: 2021/6/26 6:03 下午
	 */
	List<HuomaiUserFollowVo> friendsList(@Param("page") Page page, @Param("bo") HuomaiUserFollowQueryBo bo);

}
