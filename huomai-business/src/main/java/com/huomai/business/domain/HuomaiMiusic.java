package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 音乐模板对象 huomai_miusic
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_miusic")
public class HuomaiMiusic implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 封面图
	 */
	private String coverImg;

	/**
	 * 音乐地址
	 */
	private String miusicUrl;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	/**
	 * 更新者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	/**
	 * 备注
	 */
	private String remark;

}
