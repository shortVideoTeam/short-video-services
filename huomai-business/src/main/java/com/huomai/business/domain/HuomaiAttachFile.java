package com.huomai.business.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.huomai.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传信息保存对象 chida_attach_file
 *
 * @author huomai
 * @date 2021-01-13
 */
@Data
@ToString
public class HuomaiAttachFile implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 文件id
	 */
	@TableId(type = IdType.AUTO)
	private Long fileId;

	/**
	 * 文件原名
	 */
	private String originalFileName;

	/**
	 * 文件路径
	 */
	private String filePath;

	/**
	 * 文件类型
	 */
	private String fileType;

	/**
	 * 文件大小
	 */
	private String fileSize;

	/**
	 * 上传时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date uploadTime;

}
