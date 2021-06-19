package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 关键词对象 huomai_keywords
 *
 * @author huomai
 * @date 2021-06-19
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("huomai_keywords")
public class HuomaiKeywords implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 主键
	 */
	@TableId(value = "keyword_id")
	private Long keywordId;

	/**
	 * 关键词
	 */
	private String keyword;

	/**
	 * 命中词 (按","逗号拼接)
	 */
	private String hitword;

}
