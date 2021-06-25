package com.huomai.app.controller.common;

import cn.hutool.core.util.StrUtil;
import com.huomai.business.service.IUploadService;
import com.huomai.common.config.RuoYiConfig;
import com.huomai.common.constant.Constants;
import com.huomai.common.core.domain.AjaxResult;
import com.huomai.common.utils.file.FileUploadUtils;
import com.huomai.common.utils.file.FileUtils;
import com.huomai.framework.config.ServerConfig;
import com.huomai.system.service.ISysConfigService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用请求处理
 *
 * @author jie
 * 2021年01月20日10:01:43
 */
@Slf4j
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

	@Autowired
	private ServerConfig serverConfig;

	/**
	 * 通用下载请求
	 *
	 * @param fileName 文件名称
	 * @param delete   是否删除
	 */
	@GetMapping("common/download")
	public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
		try {
			if (!FileUtils.checkAllowDownload(fileName)) {
				throw new Exception(StrUtil.format("文件名称({})非法，不允许下载。 ", fileName));
			}
			String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
			String filePath = RuoYiConfig.getDownloadPath() + fileName;

			response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
			FileUtils.setAttachmentResponseHeader(response, realFileName);
			FileUtils.writeBytes(filePath, response.getOutputStream());
			if (delete) {
				FileUtils.deleteFile(filePath);
			}
		} catch (Exception e) {
			log.error("下载文件失败", e);
		}
	}

	/**
	 * 通用上传请求
	 */
	@PostMapping("/common/upload")
	public AjaxResult uploadFile(MultipartFile file) throws Exception {
		try {
			// 上传文件路径
			String filePath = RuoYiConfig.getUploadPath();
			// 上传并返回新文件名称
			String fileName = FileUploadUtils.upload(filePath, file);
			String url = serverConfig.getUrl() + fileName;
			Map<String, Object> ajax = new HashMap<>();
			ajax.put("fileName", fileName);
			ajax.put("url", url);
			return AjaxResult.success(ajax);
		} catch (Exception e) {
			return AjaxResult.error(e.getMessage());
		}
	}

	/**
	 * 本地资源通用下载
	 */
	@GetMapping("/common/download/resource")
	public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		try {
			if (!FileUtils.checkAllowDownload(resource)) {
				throw new Exception(StrUtil.format("资源文件({})非法，不允许下载。 ", resource));
			}
			// 本地资源路径
			String localPath = RuoYiConfig.getProfile();
			// 数据库资源地址
			String downloadPath = localPath + StrUtil.subAfter(resource, Constants.RESOURCE_PREFIX, false);
			// 下载名称
			String downloadName = StrUtil.subAfter(downloadPath, "/", true);
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
			FileUtils.setAttachmentResponseHeader(response, downloadName);
			FileUtils.writeBytes(downloadPath, response.getOutputStream());
		} catch (Exception e) {
			log.error("下载文件失败", e);
		}
	}
}
