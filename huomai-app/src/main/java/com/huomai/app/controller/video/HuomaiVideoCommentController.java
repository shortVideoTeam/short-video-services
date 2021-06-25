package com.huomai.app.controller.video;

import com.huomai.business.bo.HuomaiVideoCommentAddBo;
import com.huomai.business.bo.HuomaiVideoCommentEditBo;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.service.IHuomaiVideoCommentService;
import com.huomai.business.vo.HuomaiVideoCommentVo;
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
 * 评论Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "评论控制器", tags = {"评论管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/comment")
public class HuomaiVideoCommentController extends BaseController {

	private final IHuomaiVideoCommentService iHuomaiVideoCommentService;

	/**
	 * 视频评论列表接口
	 */
	@ApiOperation("视频评论列表接口")
	@GetMapping("/listWithReply")
	public TableDataInfo<HuomaiVideoCommentVo> listWithReply(@Validated HuomaiVideoCommentQueryBo bo) {
		return iHuomaiVideoCommentService.queryPageList(bo);
	}


	/**
	 * 获取评论详细信息
	 */
	@ApiOperation("获取评论详细信息")
	@GetMapping("/{commentId}")
	public AjaxResult<HuomaiVideoCommentVo> getInfo(@NotNull(message = "commentId不能为空")
													@PathVariable("commentId") Long commentId) {
		return AjaxResult.success(iHuomaiVideoCommentService.queryById(commentId));
	}

	/**
	 * 新增评论
	 */
	@ApiOperation("新增评论")
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoCommentAddBo bo) {
		return toAjax(iHuomaiVideoCommentService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改评论
	 */
	@ApiOperation("修改评论")
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoCommentEditBo bo) {
		return toAjax(iHuomaiVideoCommentService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除评论
	 */
	@ApiOperation("删除评论")
	@DeleteMapping("/{commentIds}")
	public AjaxResult<Void> remove(@NotEmpty(message = "commentIds不能为空")
								   @PathVariable Long[] commentIds) {
		return toAjax(iHuomaiVideoCommentService.deleteWithValidByIds(Arrays.asList(commentIds), true) ? 1 : 0);
	}
}
