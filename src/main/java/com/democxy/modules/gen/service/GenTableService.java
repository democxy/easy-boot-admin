package com.democxy.modules.gen.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.field.GenTableField;

import java.util.List;

/**
 * @author shiling_deng
 */
public interface GenTableService extends BaseService<GenTable, GenTableField> {
    /**
     * 查询当前数据库下的所有表
     * @return
     */
    List<GenTable> selectAllTableForDatabase();

    /**
     * 根据tableName添加代码生成配置信息
     * @param tableNames
     */
    void addGenTableForTableName(List<String> tableNames);
}