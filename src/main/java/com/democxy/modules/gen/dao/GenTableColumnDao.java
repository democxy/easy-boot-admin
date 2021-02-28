package com.democxy.modules.gen.dao;


import com.democxy.common.global.BaseDao;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shiling_deng
 */
@Mapper
public interface GenTableColumnDao extends BaseDao<GenTableColumn, GenTableColumnField> {
    /**
     * 根据tableName查询属性列表
     * @param tableName
     * @return
     */
    List<GenTableColumnField> selectColumnsForTableName(String tableName);
}