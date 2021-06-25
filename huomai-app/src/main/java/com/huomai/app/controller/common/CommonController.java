package com.huomai.app.controller.common;

import com.huomai.business.service.IUploadService;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.system.service.ISysConfigService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用请求处理
 *
 * @author jie
 * 2021年01月20日10:01:43
 */
@RestController
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private IUploadService uploadService;

	@Autowired
	private ISysConfigService configService;

	/**
	 * oss文件上传（单张）
	 *
	 * @param file
	 * @return url
	 */
	@ApiOperation("文件上传")
	@PostMapping("/fileUpload")
	public AjaxResult fileUpload(@NotNull @RequestBody MultipartFile file) {
		String ossPath = configService.selectConfigByKey("oss_path");
		String fileUrl = uploadService.upload(file);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("fileUrl", ossPath + fileUrl);
		return AjaxResult.success(resultMap);
	}
}
