package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 视频信息分页查询对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("搜索视频分页查询对象")
public class HuomaiVideoSearchBo extends PageBo {

	/**
	 * 搜索关键字
	 */
	@ApiModelProperty("搜索关键字,搜索关键字不为空则代表是搜索，否则是关注的视频列表")
	private String searchKey;

}
