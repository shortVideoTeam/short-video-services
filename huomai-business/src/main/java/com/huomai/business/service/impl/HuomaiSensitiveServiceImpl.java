package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiSensitiveAddBo;
import com.huomai.business.bo.HuomaiSensitiveEditBo;
import com.huomai.business.bo.HuomaiSensitiveQueryBo;
import com.huomai.business.domain.HuomaiSensitive;
import com.huomai.business.mapper.HuomaiSensitiveMapper;
import com.huomai.business.service.IHuomaiSensitiveService;
import com.huomai.business.vo.HuomaiSensitiveVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 敏感词Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiSensitiveServiceImpl extends ServiceImpl<HuomaiSensitiveMapper, HuomaiSensitive> implements IHuomaiSensitiveService {

	@Override
	public HuomaiSensitiveVo queryById(Long id) {
		return getVoById(id, HuomaiSensitiveVo.class);
	}

	@Override
	public TableDataInfo<HuomaiSensitiveVo> queryPageList(HuomaiSensitiveQueryBo bo) {
		PagePlus<HuomaiSensitive, HuomaiSensitiveVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiSensitiveVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiSensitiveVo> queryList(HuomaiSensitiveQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiSensitiveVo.class);
	}

	private LambdaQueryWrapper<HuomaiSensitive> buildQueryWrapper(HuomaiSensitiveQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiSensitive> lqw = Wrappers.lambdaQuery();
		lqw.eq(StrUtil.isNotBlank(bo.getContent()), HuomaiSensitive::getContent, bo.getContent());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiSensitiveAddBo bo) {
		HuomaiSensitive add = BeanUtil.toBean(bo, HuomaiSensitive.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiSensitiveEditBo bo) {
		HuomaiSensitive update = BeanUtil.toBean(bo, HuomaiSensitive.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiSensitive entity) {
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
