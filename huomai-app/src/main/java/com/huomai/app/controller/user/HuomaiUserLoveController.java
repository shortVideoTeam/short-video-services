package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserLoveAddBo;
import com.huomai.business.service.IHuomaiVideoLoveService;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
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

	private final IHuomaiVideoLoveService iHuomaiVideoLoveService;

	/**
	 * 新增点赞记录
	 */
	@ApiOperation("点赞")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserLoveAddBo bo) {
		return toAjax(iHuomaiVideoLoveService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 删除点赞记录
	 */
	@ApiOperation("取消点赞")
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "ids不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiVideoLoveService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
