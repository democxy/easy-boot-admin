package com.democxy.modules.gen.entity.field;

import com.democxy.common.global.BaseFiled;

import com.democxy.modules.gen.entity.GenTableColumn;
import lombok.Data;

import java.util.List;

/**
 * 代码生成Entity
 * @author democxy
 * @version 2021-01-25
 */
 @Data
public class GenTableField extends BaseFiled<GenTableField> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String comments;		// 描述
	private String className;		// 实体类名称
	private String parentTable;		// 关联父表
	private String parentTableFk;		// 关联父表外键
	private List<GenTableColumnField> columnList;
	
	
}