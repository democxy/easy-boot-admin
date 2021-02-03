package com.democxy.modules.gen.entity.field;

import com.democxy.common.global.BaseFiled;

import lombok.Data;

/**
 * 模板信息Entity
 * @author shiling_deng
 * @version 2021-02-03
 */
 @Data
public class TemplateInfoField extends BaseFiled<TemplateInfoField> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String category;		// 分类
	private String filePath;		// 生成文件路径
	private String fileName;		// 生成文件名
	private String content;		// 内容
	
	
}