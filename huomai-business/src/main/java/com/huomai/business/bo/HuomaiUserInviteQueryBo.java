package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 邀请记录分页查询对象 huomai_user_invite
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("邀请记录分页查询对象")
public class HuomaiUserInviteQueryBo extends BaseEntity {

	/**
	 * 分页大小
	 */
	@ApiModelProperty("分页大小")
	private Integer pageSize;
	/**
	 * 当前页数
	 */
	@ApiModelProperty("当前页数")
	private Integer pageNum;
	/**
	 * 排序列
	 */
	@ApiModelProperty("排序列")
	private String orderByColumn;
	/**
	 * 排序的方向desc或者asc
	 */
	@ApiModelProperty(value = "排序的方向", example = "asc,desc")
	private String isAsc;


	/**
	 * 邀请人ID
	 */
	@ApiModelProperty("邀请人ID")
	private Long userId;
	/**
	 * 被邀请人ID
	 */
	@ApiModelProperty("被邀请人ID")
	private Long byUserId;
	/**
	 * 邀请金额
	 */
	@ApiModelProperty("邀请金额")
	private BigDecimal money;
	/**
	 * 邀请码
	 */
	@ApiModelProperty("邀请码")
	private String inviteCode;

}
