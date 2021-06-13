package com.huomai.generator.mapper;

import com.huomai.common.core.page.BaseMapperPlus;
import com.huomai.generator.domain.GenTableColumn;

import java.util.List;

/**
 * 业务字段 数据层
 *
 * @author huomai
 */
public interface GenTableColumnMapper extends BaseMapperPlus<GenTableColumn> {
	/**
	 * 根据表名称查询列信息
	 *
	 * @param tableName 表名称
	 * @return 列信息
	 */
	public List<GenTableColumn> selectDbTableColumnsByName(String tableName);

}
