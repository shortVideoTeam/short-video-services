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
 * 搜索历史记录对象 huomai_user_seach_his
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_seach_his")
public class HuomaiUserSeachHis implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 搜索内容
	 */
	private String content;

	/**
	 * 搜索时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

}
