package com.huomai.business.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * 搜索历史记录添加对象 huomai_user_seach_his
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@ApiModel("搜索历史记录添加对象")
public class HuomaiUserSeachHisAddBo {


	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	@NotNull(message = "用户ID不能为空")
	private Long userId;

	/**
	 * 搜索内容
	 */
	@ApiModelProperty("搜索内容")
	@NotBlank(message = "搜索内容不能为空")
	private String content;

	/**
	 * 搜索时间
	 */
	@ApiModelProperty("搜索时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "搜索时间不能为空")
	private Date createTime;
}
