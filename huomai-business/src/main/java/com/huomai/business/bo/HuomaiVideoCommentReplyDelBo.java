package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 回复添加对象 huomai_video_comment_reply
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("回复删除对象")
public class HuomaiVideoCommentReplyDelBo {

	@ApiModelProperty(name = "id")
	@NotNull(message = "id不能为空")
	private Long id;
}
