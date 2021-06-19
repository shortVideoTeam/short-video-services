package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 钱包明细对象 huomai_user_walle
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_user_walle")
public class HuomaiUserWalle implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * ID
	 */
	@TableId(value = "id")
	private Long id;

}
