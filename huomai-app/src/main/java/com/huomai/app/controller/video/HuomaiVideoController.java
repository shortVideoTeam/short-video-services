package com.huomai.app.controller.video;

import com.huomai.business.bo.*;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.business.vo.HuomaiVideoHotVo;
import com.huomai.common.annotation.PassToken;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * 视频信息Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "视频信息控制器", tags = {"视频模块"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/video")
public class HuomaiVideoController extends BaseController {

	private final IHuomaiVideoService iHuomaiVideoService;

	/**
	 * 热门视频列表
	 */
	@PassToken
	@ApiOperation("热门视频列表")
	@GetMapping("/hotList")
	public AjaxResult hotList(@Validated HuomaiVideoHotBo bo) {
		return AjaxResult.success(iHuomaiVideoService.hotList(bo));
	}

	/**
	 * 关注视频列表
	 */
	@ApiOperation("关注视频列表")
	@GetMapping("/attendList")
	public AjaxResult attendList(@Validated HuomaiVideoAttendBo bo) {
		return AjaxResult.success(iHuomaiVideoService.attendList(bo));
	}


	/**
	 * 关注视频列表
	 */
	@PassToken
	@ApiOperation("搜索视频列表")
	@GetMapping("/searchList")
	public AjaxResult searchList(@Validated HuomaiVideoSearchBo bo) {
		return AjaxResult.success(iHuomaiVideoService.searchList(bo));
	}

	/**
	 * 用户作品列表
	 */
	@ApiOperation("用户作品列表")
	@GetMapping("/videoList")
	public AjaxResult videoList(@Validated HuomaiVideoQueryBo bo) {

		return AjaxResult.success(iHuomaiVideoService.videoList(bo));
	}


	/**
	 * 获取视频信息详请
	 */
	@ApiOperation("获取视频信息详请")
	@GetMapping("/{videoId}")
	public AjaxResult<HuomaiVideoHotVo> getInfo(@NotNull(message = "videoId不能为空")
												@PathVariable("videoId") Long videoId) {
		return AjaxResult.success(iHuomaiVideoService.queryById(videoId));
	}

	/**
	 * 发布视频
	 */
	@ApiOperation("发布视频")
	@PostMapping("/add")
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoAddBo bo) {
		return toAjax(iHuomaiVideoService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改视频信息
	 */
	@ApiOperation("修改视频")
	@PostMapping("/update")
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoEditBo bo) {
		return toAjax(iHuomaiVideoService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除视频信息
	 */
	@ApiOperation("删除视频")
	@PostMapping("/del")
	public AjaxResult<Void> remove(@Validated @RequestBody HuomaiVideoDelBo bo) {
		return toAjax(iHuomaiVideoService.deleteWithValidByIds(Arrays.asList(bo.getVideoId()), true) ? 1 : 0);
	}

	/**
	 * 分享视频
	 * @param videoId
	 * @return
	 */
	@PassToken
	@ApiOperation("分享视频")
	@GetMapping("/share/{videoId}")
	public AjaxResult<Void> share(@NotNull(message = "videoId不能为空")
												@PathVariable("videoId") Long videoId) {
		return toAjax(iHuomaiVideoService.updateVideoShare(videoId) ? 1 : 0);
	}
}
