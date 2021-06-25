package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiVideoHotBo;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.vo.HuomaiVideoHotVo;
import com.huomai.business.vo.HuomaiVideoVo;
import com.huomai.common.core.page.BaseMapperPlus;
import com.huomai.common.core.page.TableDataInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 视频信息Mapper接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface HuomaiVideoMapper extends BaseMapperPlus<HuomaiVideo> {

	/***
	* @description: 热门
	* @author chenshufeng
	* @date: 2021/6/25 3:39 下午
	*/
    List<HuomaiVideoHotVo> hotList(@Param("page") Page page, @Param("bo") HuomaiVideoHotBo bo);
}
