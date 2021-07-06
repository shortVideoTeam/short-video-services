package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 视频信息分页查询对象 huomai_video
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("视频信息分页查询对象")
public class HuomaiVideoQueryBo extends PageBo {
	/**
	 * 用户Id
	 */
	@ApiModelProperty(value = "用户Id", hidden = true)
	private Long userId;

	@ApiModelProperty("类型，1-所有 2-私密 3-赞过")
	@NotNull(message = "类型不能为空")
	private Integer type;

}
