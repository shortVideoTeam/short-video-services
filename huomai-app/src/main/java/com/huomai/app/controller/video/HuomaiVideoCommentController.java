package com.huomai.app.controller.video;

import com.google.common.collect.Lists;
import com.huomai.business.bo.HuomaiVideoCommentAddBo;
import com.huomai.business.bo.HuomaiVideoCommentDelBo;
import com.huomai.business.bo.HuomaiVideoCommentQueryBo;
import com.huomai.business.service.IHuomaiVideoCommentReplyService;
import com.huomai.business.service.IHuomaiVideoCommentService;
import com.huomai.business.vo.HuomaiVideoCommentReplyVo;
import com.huomai.business.vo.HuomaiVideoCommentVo;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 评论Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "评论控制器", tags = {"评论模块"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/comment")
public class HuomaiVideoCommentController extends BaseController {

	private final IHuomaiVideoCommentService commentService;

	private final IHuomaiVideoCommentReplyService replyService;

	/**
	 * 视频评论列表接口
	 */
	@ApiOperation("视频评论列表接口")
	@GetMapping("/listWithReply")
	public AjaxResult listWithReply(@Validated HuomaiVideoCommentQueryBo bo) {
		List<HuomaiVideoCommentVo> voList = commentService.listWithReply(bo);
		//批量查询评论下面的回复列表
		if (voList.size() > 0) {
			List<Long> cIdList = voList.stream().map(HuomaiVideoCommentVo::getCommentId).collect(Collectors.toList());
			Map<Long, List<HuomaiVideoCommentReplyVo>> map = replyService.batchQueryReplyListByCommentIds(cIdList);
			voList.forEach(vo -> {
				vo.setReplyVoList(map.getOrDefault(vo.getCommentId(), Lists.newArrayList()));
			});
		}
		return AjaxResult.success(PageUtils.buildDataInfo(voList));
	}


	/**
	 * 获取评论详细信息
	 */
	@ApiOperation("获取评论详细信息")
	@GetMapping("/{commentId}")
	public AjaxResult<HuomaiVideoCommentVo> getInfo(@NotNull(message = "commentId不能为空")
													@PathVariable("commentId") Long commentId) {
		return AjaxResult.success(commentService.queryById(commentId));
	}

	/**
	 * 新增评论
	 */
	@ApiOperation("评论")
	@PostMapping("/add")
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoCommentAddBo bo) {
		return toAjax(commentService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 删除评论
	 */
	@ApiOperation("删除评论")
	@PostMapping("/del")
	public AjaxResult<Void> remove(@Validated @RequestBody HuomaiVideoCommentDelBo bo) {
		return toAjax(commentService.deleteWithValidByIds(Arrays.asList(bo.getCommentId()), true) ? 1 : 0);
	}
}
