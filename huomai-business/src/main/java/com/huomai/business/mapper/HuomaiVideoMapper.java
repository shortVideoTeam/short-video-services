package com.huomai.business.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huomai.business.bo.HuomaiVideoAttendBo;
import com.huomai.business.bo.HuomaiVideoHotBo;
import com.huomai.business.bo.HuomaiVideoQueryBo;
import com.huomai.business.bo.HuomaiVideoSearchBo;
import com.huomai.business.domain.HuomaiVideo;
import com.huomai.business.vo.HuomaiVideoAttendVo;
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

    /***
    * @description: 关注列表
    * @author chenshufeng
    * @date: 2021/6/26 12:17 下午
    */
    List<HuomaiVideoAttendVo> attendList(@Param("page") Page page, @Param("bo") HuomaiVideoAttendBo bo);

	List<HuomaiVideoAttendVo> searchList(@Param("page") Page page, @Param("bo") HuomaiVideoSearchBo bo);
}
