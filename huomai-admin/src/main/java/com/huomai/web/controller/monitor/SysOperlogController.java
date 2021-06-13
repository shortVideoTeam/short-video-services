package com.huomai.web.controller.monitor;

import com.huomai.common.annotation.Log;
import com.huomai.common.core.controller.BaseController;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.core.page.TableDataInfo;
import com.huomai.common.enums.BusinessType;
import com.huomai.common.utils.poi.ExcelUtil;
import com.huomai.system.domain.SysOperLog;
import com.huomai.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志记录
 *
 * @author huomai
 */
@RestController
@RequestMapping("/monitor/operlog")
public class SysOperlogController extends BaseController {
	@Autowired
	private ISysOperLogService operLogService;

	@PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
	@GetMapping("/list")
	public TableDataInfo list(SysOperLog operLog) {
		return operLogService.selectPageOperLogList(operLog);
	}

	@Log(title = "操作日志", businessType = BusinessType.EXPORT)
	@PreAuthorize("@ss.hasPermi('monitor:operlog:export')")
	@GetMapping("/export")
	public AjaxResult export(SysOperLog operLog) {
		List<SysOperLog> list = operLogService.selectOperLogList(operLog);
		ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
		return util.exportExcel(list, "操作日志");
	}

	@Log(title = "操作日志", businessType = BusinessType.DELETE)
	@PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
	@DeleteMapping("/{operIds}")
	public AjaxResult remove(@PathVariable Long[] operIds) {
		return toAjax(operLogService.deleteOperLogByIds(operIds));
	}

	@Log(title = "操作日志", businessType = BusinessType.CLEAN)
	@PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
	@DeleteMapping("/clean")
	public AjaxResult clean() {
		operLogService.cleanOperLog();
		return AjaxResult.success();
	}
}
