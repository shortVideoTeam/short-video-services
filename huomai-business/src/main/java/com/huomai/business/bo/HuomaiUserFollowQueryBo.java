package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户关注分页查询对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户关注|粉丝分页查询对象")
public class HuomaiUserFollowQueryBo extends PageBo {

	@ApiModelProperty(value = "当前用户ID", hidden = true)
	private Long curUserId;

	//1-关注列表
	@ApiModelProperty(value = "查询类型 1-关注列表，2-粉丝列表", hidden = true)
	private Integer type;

}
