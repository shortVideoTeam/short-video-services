package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiKeywordsAddBo;
import com.huomai.business.bo.HuomaiKeywordsEditBo;
import com.huomai.business.bo.HuomaiKeywordsQueryBo;
import com.huomai.business.domain.HuomaiKeywords;
import com.huomai.business.mapper.HuomaiKeywordsMapper;
import com.huomai.business.service.IHuomaiKeywordsService;
import com.huomai.business.vo.HuomaiKeywordsVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 关键词Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiKeywordsServiceImpl extends ServiceImpl<HuomaiKeywordsMapper, HuomaiKeywords> implements IHuomaiKeywordsService {

	@Override
	public HuomaiKeywordsVo queryById(Long keywordId) {
		return getVoById(keywordId, HuomaiKeywordsVo.class);
	}

	@Override
	public TableDataInfo<HuomaiKeywordsVo> queryPageList(HuomaiKeywordsQueryBo bo) {
		PagePlus<HuomaiKeywords, HuomaiKeywordsVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiKeywordsVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiKeywordsVo> queryList(HuomaiKeywordsQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiKeywordsVo.class);
	}

	private LambdaQueryWrapper<HuomaiKeywords> buildQueryWrapper(HuomaiKeywordsQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiKeywords> lqw = Wrappers.lambdaQuery();
		lqw.eq(StrUtil.isNotBlank(bo.getKeyword()), HuomaiKeywords::getKeyword, bo.getKeyword());
		lqw.eq(StrUtil.isNotBlank(bo.getHitword()), HuomaiKeywords::getHitword, bo.getHitword());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiKeywordsAddBo bo) {
		HuomaiKeywords add = BeanUtil.toBean(bo, HuomaiKeywords.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiKeywordsEditBo bo) {
		HuomaiKeywords update = BeanUtil.toBean(bo, HuomaiKeywords.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiKeywords entity) {
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
