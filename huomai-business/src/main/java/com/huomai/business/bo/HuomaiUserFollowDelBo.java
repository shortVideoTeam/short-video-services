package com.huomai.business.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 用户关注添加对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("用户取消关注对象")
public class HuomaiUserFollowDelBo {

	@ApiModelProperty(value = "单个取消关注ID")
	private Long id;

	@ApiModelProperty(value = "批量取消关注ID")
	private List<Long> ids;
}
