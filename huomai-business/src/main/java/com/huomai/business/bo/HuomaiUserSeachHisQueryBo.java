package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 搜索历史记录分页查询对象 huomai_user_seach_his
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("搜索历史记录分页查询对象")
public class HuomaiUserSeachHisQueryBo extends BaseEntity {

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
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private Long userId;
	/**
	 * 搜索内容
	 */
	@ApiModelProperty("搜索内容")
	private String content;

}
