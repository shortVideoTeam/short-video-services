package com.huomai.business.bo;

import com.huomai.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 音乐模板分页查询对象 huomai_miusic
 *
 * @author huomai
 * @date 2021-06-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("音乐模板分页查询对象")
public class HuomaiMiusicQueryBo extends BaseEntity {

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
	 * 标题
	 */
	@ApiModelProperty("标题")
	private String title;
	/**
	 * 封面图
	 */
	@ApiModelProperty("封面图")
	private String coverImg;
	/**
	 * 音乐地址
	 */
	@ApiModelProperty("音乐地址")
	private String miusicUrl;

}
