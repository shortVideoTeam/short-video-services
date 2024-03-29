package com.huomai.system.mapper;

import com.huomai.common.core.page.BaseMapperPlus;
import com.huomai.system.domain.SysRoleMenu;

import java.util.List;

/**
 * 角色与菜单关联表 数据层
 *
 * @author huomai
 */
public interface SysRoleMenuMapper extends BaseMapperPlus<SysRoleMenu> {

	/**
	 * 批量新增角色菜单信息
	 *
	 * @param roleMenuList 角色菜单列表
	 * @return 结果
	 */
	public int batchRoleMenu(List<SysRoleMenu> roleMenuList);

}
