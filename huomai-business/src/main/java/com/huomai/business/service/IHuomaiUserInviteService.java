package com.huomai.business.service;

import com.huomai.business.bo.HuomaiUserInviteAddBo;
import com.huomai.business.bo.HuomaiUserInviteEditBo;
import com.huomai.business.bo.HuomaiUserInviteQueryBo;
import com.huomai.business.domain.HuomaiUserInvite;
import com.huomai.business.vo.HuomaiUserInviteVo;
import com.huomai.common.core.page.IServicePlus;
import com.huomai.common.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 邀请记录Service接口
 *
 * @author huomai
 * @date 2021-06-19
 */
public interface IHuomaiUserInviteService extends IServicePlus<HuomaiUserInvite> {
	/**
	 * 查询单个
	 *
	 * @return
	 */
	HuomaiUserInviteVo queryById(Long id);

	/**
	 * 查询列表
	 */
	TableDataInfo<HuomaiUserInviteVo> queryPageList(HuomaiUserInviteQueryBo bo);

	/**
	 * 查询列表
	 */
	List<HuomaiUserInviteVo> queryList(HuomaiUserInviteQueryBo bo);

	/**
	 * 根据新增业务对象插入邀请记录
	 *
	 * @param bo 邀请记录新增业务对象
	 * @return
	 */
	Boolean insertByAddBo(HuomaiUserInviteAddBo bo);

	/**
	 * 根据编辑业务对象修改邀请记录
	 *
	 * @param bo 邀请记录编辑业务对象
	 * @return
	 */
	Boolean updateByEditBo(HuomaiUserInviteEditBo bo);

	/**
	 * 校验并删除数据
	 *
	 * @param ids     主键集合
	 * @param isValid 是否校验,true-删除前校验,false-不校验
	 * @return
	 */
	Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
