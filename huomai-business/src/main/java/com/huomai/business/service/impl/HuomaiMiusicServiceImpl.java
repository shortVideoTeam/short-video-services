package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiMiusicAddBo;
import com.huomai.business.bo.HuomaiMiusicEditBo;
import com.huomai.business.bo.HuomaiMiusicQueryBo;
import com.huomai.business.domain.HuomaiMiusic;
import com.huomai.business.mapper.HuomaiMiusicMapper;
import com.huomai.business.service.IHuomaiMiusicService;
import com.huomai.business.vo.HuomaiMiusicVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 音乐模板Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiMiusicServiceImpl extends ServiceImpl<HuomaiMiusicMapper, HuomaiMiusic> implements IHuomaiMiusicService {

	@Override
	public HuomaiMiusicVo queryById(Long id) {
		return getVoById(id, HuomaiMiusicVo.class);
	}

	@Override
	public TableDataInfo<HuomaiMiusicVo> queryPageList(HuomaiMiusicQueryBo bo) {
		PagePlus<HuomaiMiusic, HuomaiMiusicVo> result = pageVo(PageUtils.buildPagePlus(), Wrappers.emptyWrapper(), HuomaiMiusicVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiMiusicVo> queryList(HuomaiMiusicQueryBo bo) {
		return listVo(Wrappers.emptyWrapper(), HuomaiMiusicVo.class);
	}

	@Override
	public Boolean insertByAddBo(HuomaiMiusicAddBo bo) {
		HuomaiMiusic add = BeanUtil.toBean(bo, HuomaiMiusic.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiMiusicEditBo bo) {
		HuomaiMiusic update = BeanUtil.toBean(bo, HuomaiMiusic.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiMiusic entity) {
		//TODO 做一些数据校验,如唯一约束
	}

	@Override
	public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
		if (isValid) {
			//TODO 做一些业务上的校验,判断是否需要校验
		}
		return removeByIds(ids);
	}
}
