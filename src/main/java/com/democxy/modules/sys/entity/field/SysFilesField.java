package com.democxy.modules.sys.entity.field;

import com.democxy.common.global.BaseFiled;

import lombok.Data;

import java.util.Date;

/**
 * 文件管理Entity
 * @author democxy
 * @version 2021-01-20
 */
 @Data
public class SysFilesField extends BaseFiled<SysFilesField> {
	
	private static final long serialVersionUID = 1L;
	// 文件路径
	private String filePath;
	// 文件名称
	private String fileNewname;
	// 原始名称
	private String fileOldName;
	// 文件大小
	private Double fileSize;
	// 文件后缀名
	private String fileSuffix;
	// 文件类型
	private String fileType;
	// 备注
	private String remark;
	// 上传用户
	private String useId;
	// 上传时间
	private Date uploadTime;
	
	
}