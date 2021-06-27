package com.huomai.business.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传业务层
 *
 * @author jie
 * 2021年01月05日18:02:50
 */
public interface IUploadService {
	/**
	 * 文件上传
	 *
	 * @param file
	 * @return url
	 */
	String upload(MultipartFile file);
}
