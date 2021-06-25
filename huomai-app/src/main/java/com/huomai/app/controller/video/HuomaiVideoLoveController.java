package com.huomai.app.controller.video;

import com.huomai.business.bo.HuomaiVideoLoveAddBo;
import com.huomai.business.bo.HuomaiVideoLoveEditBo;
import com.huomai.business.bo.HuomaiVideoLoveQueryBo;
import com.huomai.business.service.IHuomaiVideoLoveService;
import com.huomai.business.vo.HuomaiVideoLoveVo;
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
 * 点赞记录Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "点赞记录控制器", tags = {"点赞记录管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/love")
public class HuomaiVideoLoveController extends BaseController {

	private final IHuomaiVideoLoveService iHuomaiVideoLoveService;

	/**
	 * 查询点赞记录列表
	 */
	@ApiOperation("查询点赞记录列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiVideoLoveVo> list(@Validated HuomaiVideoLoveQueryBo bo) {
		return iHuomaiVideoLoveService.queryPageList(bo);
	}

	/**
	 * 获取点赞记录详细信息
	 */
	@ApiOperation("获取点赞记录详细信息")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiVideoLoveVo> getInfo(@NotNull(message = "id不能为空")
												 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiVideoLoveService.queryById(id));
	}

	/**
	 * 新增点赞记录
	 */
	@ApiOperation("新增点赞记录")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoLoveAddBo bo) {
		return toAjax(iHuomaiVideoLoveService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改点赞记录
	 */
	@ApiOperation("修改点赞记录")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoLoveEditBo bo) {
		return toAjax(iHuomaiVideoLoveService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除点赞记录
	 */
	@ApiOperation("删除点赞记录")
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "ids不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiVideoLoveService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
