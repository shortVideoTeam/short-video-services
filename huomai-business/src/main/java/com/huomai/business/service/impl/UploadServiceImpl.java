package com.huomai.business.service.impl;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.huomai.business.domain.HuomaiAttachFile;
import com.huomai.business.mapper.HuomaiAttachFileMapper;
import com.huomai.business.service.IUploadService;
import com.huomai.common.exception.BaseException;
import com.huomai.common.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@Component
public class UploadServiceImpl implements IUploadService {

	@Autowired
	private HuomaiAttachFileMapper attachFileMapper;

	//拿到配置的参数
	@Value("${file.endpoint}")
	private String endpoint;
	@Value("${file.accessKeyId}")
	private String accessKeyId;
	@Value("${file.accessKeySecret}")
	private String accessKeySecret;
	@Value("${file.bucketName}")
	private String bucketName;
	@Value("${file.fileFolder}")
	private String fileFolder;
	@Value("${file.internetAddress}")
	private String internetAddress;

	@Override
	public String upload(MultipartFile file) {
		//MultipartFile转File
		String filename = file.getOriginalFilename();
		try {
			if (!"".equals(filename.trim())) {
//                if (checkFileSize(file.getSize(),10,"M")){
//                    throw new BusinessException("单个文件大小不能超过10MB！");
//                }
				// 上传文件流
				InputStream inputStream = file.getInputStream();
				/*String fileType=filename.substring(filename.lastIndexOf("."));*/
				return uploadFileMulti(inputStream, filename, file.getSize());
			}
		} catch (IOException e) {
			log.error("文件上传失败,异常原因>>>", e);
			return "文件上传异常";
		}
		return "上传失败";
	}

	public String uploadFileMulti(InputStream inputStream, String filename, Long size) {
		String fileUrl = "";
		OSS ossClient = null;
		try {
			//获取文件后缀
			int indexOf = filename.lastIndexOf(".");
			String suffix = ".png";
			if (indexOf > -1) {
				suffix = filename.substring(indexOf);
			}
			String uuid = UUID.fastUUID().toString();
			// 设置文件上传到oss路径和名称
			fileUrl = fileFolder + "/" + DateUtils.getDate() + "/" + uuid + suffix;
			// 创建OSSClient实例。

			ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
			ObjectMetadata o = new ObjectMetadata();

			String formatFileName = encodingFileName(uuid + suffix);

			o.setContentDisposition("attachment; filename=\"" + formatFileName + "\"");
			Map<String, String> tags = new HashMap();
			tags.put("filename", formatFileName);
			o.setUserMetadata(tags);
			o.setContentEncoding("UTF-8");

			//o.setContentEncoding("UTF-8");
			// 上传文件流
			ossClient.putObject(bucketName, fileUrl, inputStream, o);
			//保存文件信息
//			saveFile(filename, size, fileUrl, suffix);
		} catch (Exception e) {
			log.error("文件上传失败,",e);
			throw new BaseException("文件上传失败"+e.getMessage());
		} finally {
			// 关闭OSSClient
			assert ossClient != null;
			ossClient.shutdown();
		}
		return fileUrl;
	}

	/***
	 * @description: 保存文件信息
	 * @author chenshufeng
	 * @date: 2021/6/25 2:12 下午
	 */
	private void saveFile(String filename, Long size, String fileUrl, String suffix) {
		HuomaiAttachFile attachFile = new HuomaiAttachFile();
		attachFile.setOriginalFileName(filename);
		attachFile.setFileType(suffix);
		attachFile.setFilePath(fileUrl);
		attachFile.setFileSize(String.valueOf(size));
		attachFile.setUploadTime(DateUtils.getNowDate());
		attachFileMapper.insert(attachFile);
	}


	public static String encodingFileName(String fileName) {
		String returnFileName = "";
		try {
			returnFileName = URLEncoder.encode(fileName, "UTF-8");
			returnFileName = StringUtils.replace(returnFileName, "+", "%20");
			if (returnFileName.length() > 150) {
				returnFileName = new String(fileName.getBytes("GB2312"), "ISO8859-1");
				returnFileName = StringUtils.replace(returnFileName, " ", "%20");
			}
		} catch (UnsupportedEncodingException e) {
			log.error("", e);
		}
		return returnFileName;
	}

}
