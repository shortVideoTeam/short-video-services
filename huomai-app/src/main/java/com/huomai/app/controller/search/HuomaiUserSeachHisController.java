package com.huomai.app.controller.search;

import com.huomai.business.bo.HuomaiUserSeachHisAddBo;
import com.huomai.business.bo.HuomaiUserSeachHisQueryBo;
import com.huomai.business.service.IHuomaiUserSeachHisService;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 搜索历史记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "搜索历史记录控制器", tags = {"搜索历史记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/his")
public class HuomaiUserSeachHisController extends BaseController {

	private final IHuomaiUserSeachHisService iHuomaiUserSeachHisService;

	/**
	 * 查询搜索历史记录列表
	 */
	@ApiOperation("查询搜索历史记录列表")
	@GetMapping("/list")
	public AjaxResult list(@Validated HuomaiUserSeachHisQueryBo bo) {
		return AjaxResult.success(iHuomaiUserSeachHisService.queryPageList(bo));
	}

	/**
	 * 新增搜索历史记录
	 */
	@ApiOperation("新增搜索历史记录")
	@PostMapping("/add")
	public AjaxResult add(@Validated @RequestBody HuomaiUserSeachHisAddBo bo) {
		return toAjax(iHuomaiUserSeachHisService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 删除搜索历史记录
	 */
	@ApiOperation("清空搜索历史记录")
	@PostMapping("/cleanHis")
	public AjaxResult cleanHis() {
		return toAjax(iHuomaiUserSeachHisService.cleanHis() ? 1 : 0);
	}
}
