package com.huomai.app.controller.common;

import com.huomai.business.bo.HuomaiMiusicQueryBo;
import com.huomai.business.service.IHuomaiMiusicService;
import com.huomai.business.vo.HuomaiMiusicVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 音乐模板Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "音乐模板控制器", tags = {"音乐模板管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/miusic")
public class HuomaiMiusicController extends BaseController {

	private final IHuomaiMiusicService iHuomaiMiusicService;

	/**
	 * 查询音乐模板列表
	 */
	@ApiOperation("查询音乐模板列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiMiusicVo> list(@Validated HuomaiMiusicQueryBo bo) {
		return iHuomaiMiusicService.queryPageList(bo);
	}
}
