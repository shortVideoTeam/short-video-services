package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserLoveAddBo;
import com.huomai.business.bo.HuomaiUserLoveDelBo;
import com.huomai.business.service.IHuomaiUserLoveService;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 点赞记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "点赞记录控制器", tags = {"点赞记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/love")
public class HuomaiUserLoveController extends BaseController {

	private final IHuomaiUserLoveService loveService;

	/**
	 * 新增点赞记录
	 */
	@ApiOperation("点赞|取消点赞")
	@PostMapping("/add")
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserLoveAddBo bo) {
		return toAjax(loveService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 删除点赞记录
	 */
	@ApiOperation("取消点赞")
	@PostMapping("/cancel")
	public AjaxResult<Void> cancel(@Validated @RequestBody HuomaiUserLoveDelBo bo) {
		return toAjax(loveService.deleteWithValidByIds(Arrays.asList(bo.getId()), true) ? 1 : 0);
	}
}
