package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注对象 huomai_user_follow
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_follow")
public class HuomaiUserFollow implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;


	/**
	 * 用户id
	 */
	private Long userId;

	//来源，1-搜索2-粉丝3-消息4-可能认识的人
	private Integer source;

	/**
	 * 关注用户id
	 */
	private Long followUserId;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 备注
	 */
	private String remark;

}
