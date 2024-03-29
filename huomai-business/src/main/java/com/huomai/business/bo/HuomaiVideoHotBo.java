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
//@Builder
@ApiModel("热门视频分页查询对象")
public class HuomaiVideoHotBo extends PageBo {

	@ApiModelProperty(value = "当前用户ID", hidden = true)
	private Long curUserId;

	//视频id
	@ApiModelProperty("视频ID")
	private Long videoId;

}
