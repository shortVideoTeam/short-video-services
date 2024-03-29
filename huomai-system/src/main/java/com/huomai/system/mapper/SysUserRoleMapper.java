package com.huomai.system.mapper;

import com.huomai.common.core.page.BaseMapperPlus;
import com.huomai.system.domain.SysUserRole;

import java.util.List;

/**
 * 用户与角色关联表 数据层
 *
 * @author huomai
 */
public interface SysUserRoleMapper extends BaseMapperPlus<SysUserRole> {

	/**
	 * 批量新增用户角色信息
	 *
	 * @param userRoleList 用户角色列表
	 * @return 结果
	 */
	public int batchUserRole(List<SysUserRole> userRoleList);

}
