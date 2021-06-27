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
@ApiModel("关注视频分页查询对象")
public class HuomaiVideoAttendBo extends PageBo {

	//	@ApiModelProperty("当前用户ID")
	private Long curUserId;

	/**
	 * 搜索关键字
	 */
	@ApiModelProperty("搜索关键字")
	private String searchKey;

}
