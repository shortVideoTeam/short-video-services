package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiUserInviteQueryBo;
import com.huomai.business.domain.HuomaiUserInvite;
import com.huomai.business.vo.HuomaiUserInviteVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 邀请记录Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiUserInviteMapper extends BaseMapperPlus<HuomaiUserInvite> {
	/***
	* @description: 邀请我的人
	* @author chenshufeng
	* @date: 2021/7/23 11:26 上午
	 * @param userId
	*/
    HuomaiUserInviteVo myUserInvite(Long userId);

	List<HuomaiUserInviteVo> myInviteList(@Param("page") Page page, @Param("bo") HuomaiUserInviteQueryBo bo);
}
