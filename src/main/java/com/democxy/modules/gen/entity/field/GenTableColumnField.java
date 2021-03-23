package com.democxy.modules.gen.entity.field;

import com.democxy.common.global.BaseFiled;

import lombok.Data;

/**
 * 代码生成Entity
 * @author democxy
 * @version 2021-01-25
 */
 @Data
public class GenTableColumnField extends BaseFiled<GenTableColumnField> {
	
	private static final long serialVersionUID = 1L;
	// 归属表编号
	private String genTableId;
	// 名称
	private String name;
	// 描述
	private String comments;
	// 列的数据类型的字节长度
	private String jdbcType;
	// JAVA类型
	private String javaType;
	// JAVA字段名
	private String javaField;
	// 是否主键
	private Boolean isPk;
	// 是否可为空
	private Boolean isNull;
	// 是否为插入字段
	private Boolean isInsert;
	// 是否编辑字段
	private Boolean isEdit;
	// 是否列表字段
	private Boolean isList;
	// 是否查询字段
	private Boolean isQuery;
	// 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
	private String queryType;
	// 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
	private String showType;
	// 字典类型
	private String dictType;
	private String settings;
	// 其它设置（扩展字段JSON）
	private Integer sort;
	// 排序（升序）

	public GenTableColumnField(String genTableId) {
		this.genTableId = genTableId;
	}

	public GenTableColumnField() {
	}
}