package com.democxy.modules.gen.entity;

import com.democxy.common.global.BaseFiled;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

import java.util.List;

/**
 * 代码生成Entity
 *
 * @author democxy
 * @version 2021-01-25
 */
@Data
public class GenTable extends BaseFiled<GenTable> {

    private static final long serialVersionUID = 1L;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String comments;
    /**
     * 实体类名称
     */
    private String className;
    /**
     * 包路径
     */
    private String packageName;
    /**
     * 模块名称
     */
    private String modelName;
    /**
     * 关联父表
     */
    private String parentTable;
    /**
     * 关联父表外键
     */
    private String parentTableFk;
    /**
     * 参数列表
     */
    private List<GenTableColumn> columnList;
}