package com.huomai.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 推广记录视图对象 huomai_user_promote
 *
 * @author huomai
 * @date 2021-07-06
 */
@Data
@ApiModel("推广记录视图对象")
public class HuomaiUserPromoteVo {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@ApiModelProperty("ID")
	private Long id;

	/**
	 * 用户ID
	 */
	@Excel(name = "用户ID")
	@ApiModelProperty("用户ID")
	private Long userId;

	/**
	 * 视频ID
	 */
	@Excel(name = "视频ID")
	@ApiModelProperty("视频ID")
	private Long videoId;

	/**
	 * 推广状态( 1: 已报名 2: 已参与 3:已失效 )
	 */
	@Excel(name = "推广状态( 1: 已报名 2: 已参与 3:已失效 )")
	@ApiModelProperty("推广状态( 1: 已报名 2: 已参与 3:已失效 )")
	private String status;

	/**
	 * 热门次数
	 */
	@Excel(name = "热门次数")
	@ApiModelProperty("热门次数")
	private Long hotNum;

	/**
	 * 推广收益
	 */
	@Excel(name = "推广收益")
	@ApiModelProperty("推广收益")
	private BigDecimal profit;

	/**
	 * 发出推广值
	 */
	@Excel(name = "发出推广值")
	@ApiModelProperty("发出推广值")
	private BigDecimal sendVal;

	/**
	 * 收到推广值
	 */
	@Excel(name = "收到推广值")
	@ApiModelProperty("收到推广值")
	private BigDecimal receivedVal;

	/**
	 * 用户火脉号Id
	 */
	@Excel(name = "用户火脉号Id")
	@ApiModelProperty("用户火脉号Id")
	private String uuid;

	/**
	 * 用户头像
	 */
	@Excel(name = "用户头像")
	@ApiModelProperty("用户头像")
	private String avatar;

	/**
	 * 用户昵称
	 */
	@Excel(name = "用户昵称")
	@ApiModelProperty("用户昵称")
	private String nickName;

	/**
	 * 手机号
	 */
	@Excel(name = "手机号")
	@ApiModelProperty("手机号")
	private String phone;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	@Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
}
