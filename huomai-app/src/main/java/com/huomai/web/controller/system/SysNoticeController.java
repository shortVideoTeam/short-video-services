package com.huomai.web.controller.system;

import com.huomai.common.annotation.Log;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.enums.BusinessType;
import com.huomai.common.utils.SecurityUtils;
import com.huomai.system.domain.SysNotice;
import com.huomai.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 公告 信息操作处理
 *
 * @author huomai
 */
@RestController
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController {
	@Autowired
	private ISysNoticeService noticeService;

	/**
	 * 获取通知公告列表
	 */
	//@PreAuthorize("@ss.hasPermi('system:notice:list')")
	@GetMapping("/list")
	public TableDataInfo list(SysNotice notice) {
		return noticeService.selectPageNoticeList(notice);
	}

	/**
	 * 根据通知公告编号获取详细信息
	 */
	//@PreAuthorize("@ss.hasPermi('system:notice:query')")
	@GetMapping(value = "/{noticeId}")
	public AjaxResult getInfo(@PathVariable Long noticeId) {
		return AjaxResult.success(noticeService.selectNoticeById(noticeId));
	}

	/**
	 * 新增通知公告
	 */
	//@PreAuthorize("@ss.hasPermi('system:notice:add')")
	@Log(title = "通知公告", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@Validated @RequestBody SysNotice notice) {
		notice.setCreateBy(SecurityUtils.getUsername());
		return toAjax(noticeService.insertNotice(notice));
	}

	/**
	 * 修改通知公告
	 */
	//@PreAuthorize("@ss.hasPermi('system:notice:edit')")
	@Log(title = "通知公告", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@Validated @RequestBody SysNotice notice) {
		notice.setUpdateBy(SecurityUtils.getUsername());
		return toAjax(noticeService.updateNotice(notice));
	}

	/**
	 * 删除通知公告
	 */
	//@PreAuthorize("@ss.hasPermi('system:notice:remove')")
	@Log(title = "通知公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
	public AjaxResult remove(@PathVariable Long[] noticeIds) {
		return toAjax(noticeService.deleteNoticeByIds(noticeIds));
	}
}
