package com.huomai.app.controller.video;

import com.huomai.business.bo.HuomaiVideoCommentReplyAddBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyEditBo;
import com.huomai.business.bo.HuomaiVideoCommentReplyQueryBo;
import com.huomai.business.service.IHuomaiVideoCommentReplyService;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
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
 * 回复Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "回复控制器", tags = {"回复管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/reply")
public class HuomaiVideoCommentReplyController extends BaseController {

	private final IHuomaiVideoCommentReplyService iHuomaiVideoCommentReplyService;

	/**
	 * 查询回复列表
	 */
	@ApiOperation("查询回复列表")
	@GetMapping("/list")
	public TableDataInfo<HuomaiVideoCommentReplyVo> list(@Validated HuomaiVideoCommentReplyQueryBo bo) {
		return iHuomaiVideoCommentReplyService.queryPageList(bo);
	}


	/**
	 * 获取回复详细信息
	 */
	@ApiOperation("获取回复详细信息")
	@GetMapping("/{id}")
	public AjaxResult<HuomaiVideoCommentReplyVo> getInfo(@NotNull(message = "id不能为空")
														 @PathVariable("id") Long id) {
		return AjaxResult.success(iHuomaiVideoCommentReplyService.queryById(id));
	}

	/**
	 * 新增回复
	 */
	@ApiOperation("新增回复")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoCommentReplyAddBo bo) {
		return toAjax(iHuomaiVideoCommentReplyService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改回复
	 */
	@ApiOperation("修改回复")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoCommentReplyEditBo bo) {
		return toAjax(iHuomaiVideoCommentReplyService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除回复
	 */
	@ApiOperation("删除回复")
	@DeleteMapping("/{ids}")
	public AjaxResult<Void> remove(@NotEmpty(message = "ids不能为空")
								   @PathVariable Long[] ids) {
		return toAjax(iHuomaiVideoCommentReplyService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
	}
}
