package com.huomai.app.controller.video;

import com.huomai.business.bo.*;
import com.huomai.business.service.IHuomaiVideoService;
import com.huomai.business.vo.HuomaiVideoAttendVo;
import com.huomai.business.vo.HuomaiVideoHotVo;
import com.huomai.business.vo.HuomaiVideoVo;
import com.huomai.common.annotation.Log;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.enums.BusinessType;
import com.huomai.common.utils.SecurityUtils;
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
 * 视频信息Controller
 *
 * @author huomai
 * @date 2021-06-19
 */
@Api(value = "视频信息控制器", tags = {"视频信息管理"})
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/business/video")
public class HuomaiVideoController extends BaseController {

	private final IHuomaiVideoService iHuomaiVideoService;

	/**
	 * 热门视频列表
	 */
	@ApiOperation("热门视频列表")
	@GetMapping("/hotList")
	public TableDataInfo<HuomaiVideoHotVo> hotList(@Validated HuomaiVideoHotBo bo) {
		return iHuomaiVideoService.hotList(bo);
	}

	/**
	 * 关注视频列表
	 */
	@ApiOperation("关注视频列表")
	@GetMapping("/attendList")
	public TableDataInfo<HuomaiVideoAttendVo> attendList(@Validated HuomaiVideoAttendBo bo) {
		return iHuomaiVideoService.attendList(bo);
	}

	/**
	 * 用户作品列表
	 */
	@ApiOperation("视频列表")
	@GetMapping("/videoList")
	public TableDataInfo<HuomaiVideoVo> videoList(@Validated HuomaiVideoQueryBo bo) {

		return iHuomaiVideoService.videoList(bo);
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
	@PostMapping()
	public AjaxResult<Void> add(@Validated @RequestBody HuomaiVideoAddBo bo) {
		return toAjax(iHuomaiVideoService.insertByAddBo(bo) ? 1 : 0);
	}

	/**
	 * 修改视频信息
	 */
	@ApiOperation("修改视频")
	@Log(title = "视频信息", businessType = BusinessType.UPDATE)
	@PutMapping()
	public AjaxResult<Void> edit(@Validated @RequestBody HuomaiVideoEditBo bo) {
		return toAjax(iHuomaiVideoService.updateByEditBo(bo) ? 1 : 0);
	}

	/**
	 * 删除视频信息
	 */
	@ApiOperation("删除视频")
	@DeleteMapping("/{videoIds}")
	public AjaxResult<Void> remove(@NotEmpty(message = "videoIds不能为空")
								   @PathVariable Long[] videoIds) {
		return toAjax(iHuomaiVideoService.deleteWithValidByIds(Arrays.asList(videoIds), true) ? 1 : 0);
	}
}
