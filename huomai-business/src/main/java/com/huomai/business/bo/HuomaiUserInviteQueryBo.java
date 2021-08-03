package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 邀请记录分页查询对象 huomai_user_invite
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@ApiModel("邀请记录分页查询对象")
public class HuomaiUserInviteQueryBo extends PageBo {

	/**
	 * 当前用户
	 */
	@ApiModelProperty(value = "当前用户ID", hidden = true)
	private Long userId;

}
