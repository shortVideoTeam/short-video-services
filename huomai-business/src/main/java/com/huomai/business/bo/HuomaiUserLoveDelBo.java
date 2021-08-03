package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * 点赞记录添加对象 huomai_user_love
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("点赞记录添加对象")
public class HuomaiUserLoveDelBo {

	@ApiModelProperty(value = "id")
	@NotNull(message = "id不能为空")
	private Long id;
}
