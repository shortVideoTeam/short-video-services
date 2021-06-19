package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserSeachHisAddBo;
import com.huomai.business.bo.HuomaiUserSeachHisEditBo;
import com.huomai.business.bo.HuomaiUserSeachHisQueryBo;
import com.huomai.business.domain.HuomaiUserSeachHis;
import com.huomai.business.mapper.HuomaiUserSeachHisMapper;
import com.huomai.business.service.IHuomaiUserSeachHisService;
import com.huomai.business.vo.HuomaiUserSeachHisVo;
import com.huomai.common.core.page.PagePlus;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 搜索历史记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserSeachHisServiceImpl extends ServiceImpl<HuomaiUserSeachHisMapper, HuomaiUserSeachHis> implements IHuomaiUserSeachHisService {

	@Override
	public HuomaiUserSeachHisVo queryById(Long id) {
		return getVoById(id, HuomaiUserSeachHisVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserSeachHisVo> queryPageList(HuomaiUserSeachHisQueryBo bo) {
		PagePlus<HuomaiUserSeachHis, HuomaiUserSeachHisVo> result = pageVo(PageUtils.buildPagePlus(), buildQueryWrapper(bo), HuomaiUserSeachHisVo.class);
		return PageUtils.buildDataInfo(result);
	}

	@Override
	public List<HuomaiUserSeachHisVo> queryList(HuomaiUserSeachHisQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiUserSeachHisVo.class);
	}

	private LambdaQueryWrapper<HuomaiUserSeachHis> buildQueryWrapper(HuomaiUserSeachHisQueryBo bo) {
		Map<String, Object> params = bo.getParams();
		LambdaQueryWrapper<HuomaiUserSeachHis> lqw = Wrappers.lambdaQuery();
		lqw.eq(bo.getUserId() != null, HuomaiUserSeachHis::getUserId, bo.getUserId());
		lqw.eq(StrUtil.isNotBlank(bo.getContent()), HuomaiUserSeachHis::getContent, bo.getContent());
		return lqw;
	}

	@Override
	public Boolean insertByAddBo(HuomaiUserSeachHisAddBo bo) {
		HuomaiUserSeachHis add = BeanUtil.toBean(bo, HuomaiUserSeachHis.class);
		validEntityBeforeSave(add);
		return save(add);
	}

	@Override
	public Boolean updateByEditBo(HuomaiUserSeachHisEditBo bo) {
		HuomaiUserSeachHis update = BeanUtil.toBean(bo, HuomaiUserSeachHis.class);
		validEntityBeforeSave(update);
		return updateById(update);
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUserSeachHis entity) {
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
