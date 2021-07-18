package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 评论添加对象 huomai_video_comment
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("评论删除对象")
public class HuomaiVideoCommentDelBo {

	@ApiModelProperty(name = "commentId")
	@NotNull(message = "commentId不能为空")
	private Long commentId;

}
