package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserAddBo;
import com.huomai.business.bo.HuomaiUserEditBo;
import com.huomai.business.bo.HuomaiUserQueryBo;
import com.huomai.business.domain.HuomaiUser;
import com.huomai.business.vo.HuomaiUserVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 用户信息Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiUserService extends IServicePlus<HuomaiUser> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiUserVo queryById(Long userId);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiUserVo> queryPageList(HuomaiUserQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiUserVo> queryList(HuomaiUserQueryBo bo);

	/**
	 * 根据新增业务对象插入用户信息
	 *
	 * @param bo 用户信息新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiUserAddBo bo);

	/**
	 * 根据编辑业务对象修改用户信息
	 *
	 * @param bo 用户信息编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiUserEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
