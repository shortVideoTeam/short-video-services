package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.domain.HuomaiUserPromote;
import com.huomai.business.vo.HuomaiUserPromoteVo;
import com.huomai.common.core.page.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 推广记录Mapper接口
 *
 * @author huomai
 * @date 2021-07-06
 */
public interface HuomaiUserPromoteMapper extends BaseMapperPlus<HuomaiUserPromote> {
	/**
	 * 查询列表
	 *
	 * @param page
	 * @param bo
	 * @return
	 */
	List<HuomaiUserPromoteVo> queryList(@Param("page") Page page, @Param("bo") HuomaiUserPromoteQueryBo bo);
}
