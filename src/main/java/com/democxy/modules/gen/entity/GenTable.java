package com.democxy.modules.gen.entity;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

import java.util.List;

/**
 * 代码生成Entity
 * @author democxy
 * @version 2021-01-25
 */
 @Data
public class GenTable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	// 名称
	private String name;
	// 描述
	private String comments;
	// 实体类名称
	private String className;
	// 关联父表
	private String parentTable;
	// 关联父表外键
	private String parentTableFk;
	// 参数列表
	private List<GenTableColumn> columnList;
}