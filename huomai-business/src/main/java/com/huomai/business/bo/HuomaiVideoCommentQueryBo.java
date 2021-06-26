package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论分页查询对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("评论分页查询对象")
public class HuomaiVideoCommentQueryBo extends PageBo {

	/**
	 * 视频ID
	 */
	@ApiModelProperty("视频ID")
	private Long videoId;

	private Long curUserId;


}
