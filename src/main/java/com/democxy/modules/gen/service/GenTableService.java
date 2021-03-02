package com.democxy.modules.gen.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.field.GenTableField;
import com.democxy.modules.gen.vo.PreViewCode;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取模板渲染数据
     * @param id
     * @return
     */
    Map<String,Object> getGenTempModelData(String id);

    /**
     * 获取预览代码数据
     * @param id
     * @return
     */
    List<PreViewCode> preViewCode(String id);
}