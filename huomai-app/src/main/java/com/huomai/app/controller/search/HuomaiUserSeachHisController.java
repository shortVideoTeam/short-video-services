package com.huomai.app.controller.search;

import com.huomai.business.bo.HuomaiUserSeachHisAddBo;
import com.huomai.business.bo.HuomaiUserSeachHisEditBo;
import com.huomai.business.bo.HuomaiUserSeachHisQueryBo;
import com.huomai.business.service.IHuomaiUserSeachHisService;
import com.huomai.business.vo.HuomaiUserSeachHisVo;
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
	public TableDataInfo<HuomaiUserSeachHisVo> list(@Validated HuomaiUserSeachHisQueryBo bo) {
		return iHuomaiUserSeachHisService.queryPageList(bo);
	}

	/**
	 * 获取搜索历史记录详细信息
	 */
	@ApiOperation("获取搜索历史记录详细信息")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiUserSeachHisVo> getInfo(@NotNull(message = "主键不能为空")
													@PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiUserSeachHisService.queryById(id));
	}

	/**
	 * 新增搜索历史记录
	 */
	@ApiOperation("新增搜索历史记录")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiUserSeachHisAddBo bo) {
		return toAjax(iHuomaiUserSeachHisService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改搜索历史记录
	 */
	@ApiOperation("修改搜索历史记录")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiUserSeachHisEditBo bo) {
		return toAjax(iHuomaiUserSeachHisService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除搜索历史记录
	 */
	@ApiOperation("删除搜索历史记录")
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "主键不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiUserSeachHisService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
