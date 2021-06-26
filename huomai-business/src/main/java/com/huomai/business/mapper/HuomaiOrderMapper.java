package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiOrderQueryBo;
import com.huomai.business.domain.HuomaiOrder;
import com.huomai.business.vo.HuomaiOrderVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单记录Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiOrderMapper extends BaseMapperPlus<HuomaiOrder> {

	/***
	* @description: 订单列表
	* @author chenshufeng
	* @date: 2021/6/26 9:42 下午
	*/
    List<HuomaiOrderVo> queryList(@Param("page") Page page, @Param("bo") HuomaiOrderQueryBo bo);
}
