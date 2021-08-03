package com.huomai.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
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
import com.huomai.common.utils.DateUtils;
import com.huomai.common.utils.PageUtils;
import com.huomai.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * 搜索历史记录Service业务层处理
 *
 * @author huomai
 * @date 2021-06-19
 */
@Service
public class HuomaiUserSeachHisServiceImpl extends ServiceImpl<HuomaiUserSeachHisMapper, HuomaiUserSeachHis> implements IHuomaiUserSeachHisService {

	@Autowired
	private HuomaiUserSeachHisMapper seachHisMapper;

	@Override
	public HuomaiUserSeachHisVo queryById(Long id) {
		return getVoById(id, HuomaiUserSeachHisVo.class);
	}


	/***
	 * @description: 搜索记录列表
	 * @author chenshufeng
	 * @date: 2021/6/26 1:16 下午
	 */
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
		LambdaQueryWrapper<HuomaiUserSeachHis> lqw = Wrappers.lambdaQuery();
		lqw.eq(HuomaiUserSeachHis::getUserId, SecurityUtils.getUserId());
		lqw.orderByDesc(HuomaiUserSeachHis::getCreateTime);
		return lqw;
	}

	/***
	 * @description: 新增搜索历史
	 * @author chenshufeng
	 * @date: 2021/6/26 1:39 下午
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean insertByAddBo(HuomaiUserSeachHisAddBo bo) {
		HuomaiUserSeachHis add = BeanUtil.toBean(bo, HuomaiUserSeachHis.class);
		validEntityBeforeSave(add);
		String content = bo.getContent();
		Long userId = SecurityUtils.getUserId();
		LambdaQueryWrapper<HuomaiUserSeachHis> queryWrapper = Wrappers.<HuomaiUserSeachHis>lambdaQuery().eq(HuomaiUserSeachHis::getUserId, userId).eq(HuomaiUserSeachHis::getContent, content);
		List<HuomaiUserSeachHis> hisList = seachHisMapper.selectList(queryWrapper);
		//保留一条相同内容的记录
		if (hisList.size() > 1) {
			seachHisMapper.delete(queryWrapper);
			save(content, userId);
		} else if (hisList.size() == 1) {
			HuomaiUserSeachHis his = hisList.get(0);
			his.setCreateTime(DateUtils.getNowDate());
			updateById(his);
		} else {
			save(content, userId);
		}
		return Boolean.TRUE;
	}

	public void save(String content, Long userId) {
		HuomaiUserSeachHis his = new HuomaiUserSeachHis();
		his.setCreateTime(DateUtils.getNowDate());
		his.setContent(content);
		his.setUserId(userId);
		seachHisMapper.insert(his);
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

	/***
	 * @description: 清空搜索历史
	 * @author chenshufeng
	 * @date: 2021/6/26 2:00 下午
	 */
	@Override
	public Boolean cleanHis() {
		seachHisMapper.delete(Wrappers.<HuomaiUserSeachHis>lambdaQuery().eq(HuomaiUserSeachHis::getUserId, SecurityUtils.getUserId()));
		return Boolean.TRUE;
	}
}
