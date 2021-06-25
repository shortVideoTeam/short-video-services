package com.huomai.app.controller.user;

import com.huomai.business.bo.HuomaiUserWalleAddBo;
import com.huomai.business.bo.HuomaiUserWalleEditBo;
import com.huomai.business.bo.HuomaiUserWalleQueryBo;
import com.huomai.business.service.IHuomaiUserWalleService;
import com.huomai.business.vo.HuomaiUserWalleVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * 钱包明细Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "钱包明细控制器", tags = {"钱包明细管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/walle")
public class HuomaiUserWalleController extends BaseController {

	private final IHuomaiUserWalleService iHuomaiUserWalleService;

	/**
	 * 查询钱包明细列表
	 */
	@ApiOperation("查询钱包明细列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiUserWalleVo> list(@Validated HuomaiUserWalleQueryBo bo) {
		return iHuomaiUserWalleService.queryPageList(bo);
	}

	/**
	 * 获取钱包明细详细信息
	 */
	@ApiOperation("获取钱包明细详细信息")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiUserWalleVo> getInfo(@NotNull(message = "主键不能为空")
												 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiUserWalleService.queryById(id));
	}

	/**
	 * 新增钱包明细
	 */
	@ApiOperation("新增钱包明细")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserWalleAddBo bo) {
		return toAjax(iHuomaiUserWalleService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改钱包明细
	 */
	@ApiOperation("修改钱包明细")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserWalleEditBo bo) {
		return toAjax(iHuomaiUserWalleService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除钱包明细
	 */
	@ApiOperation("删除钱包明细")
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiUserWalleService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
