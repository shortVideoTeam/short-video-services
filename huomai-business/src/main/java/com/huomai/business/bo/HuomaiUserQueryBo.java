package com.huomai.business.bo;

import com.huomai.common.core.domain.PageBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息分页查询对象 huomai_user
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户信息分页查询对象")
public class HuomaiUserQueryBo extends PageBo {

	/**
	 * 当前用户
	 */
	private Long curUserId;

	/**
	 * 搜索关键字
	 */
	@ApiModelProperty("搜索关键字")
	private String searchKey;

}
