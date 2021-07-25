package com.huomai.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huomai.business.bo.HuomaiUserPromoteQueryBo;
import com.huomai.business.domain.HuomaiUserPromote;
import com.huomai.business.mapper.HuomaiUserPromoteMapper;
import com.huomai.business.service.IHuomaiUserPromoteService;
import com.huomai.business.vo.HuomaiUserPromoteVo;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 推广记录Service业务层处理
 *
 * @author huomai
 * @date 2021-07-06
 */
@Service
public class HuomaiUserPromoteServiceImpl
	extends ServiceImpl<HuomaiUserPromoteMapper, HuomaiUserPromote>
	implements IHuomaiUserPromoteService {

	@Autowired
	private HuomaiUserPromoteMapper promoteMapper;

	@Override
	public HuomaiUserPromoteVo queryById(Long id) {
		return getVoById(id, HuomaiUserPromoteVo.class);
	}

	@Override
	public TableDataInfo<HuomaiUserPromoteVo> queryPageList(HuomaiUserPromoteQueryBo bo) {
		bo.setUserId(SecurityUtils.getUserId());
		List<HuomaiUserPromoteVo> list = promoteMapper.queryList(PageUtils.buildPage(), bo);
		return PageUtils.buildDataInfo(list);
	}

	@Override
	public List<HuomaiUserPromoteVo> queryList(HuomaiUserPromoteQueryBo bo) {
		return listVo(buildQueryWrapper(bo), HuomaiUserPromoteVo.class);
	}

	private LambdaQueryWrapper<HuomaiUserPromote> buildQueryWrapper(HuomaiUserPromoteQueryBo bo) {
		LambdaQueryWrapper<HuomaiUserPromote> lqw = Wrappers.lambdaQuery();
		return lqw;
	}

	/**
	 * 保存前的数据校验
	 *
	 * @param entity 实体类数据
	 */
	private void validEntityBeforeSave(HuomaiUserPromote entity) {
		// TODO 做一些数据校验,如唯一约束
	}

}
