package com.democxy.modules.gen.dao;


import com.democxy.common.global.BaseDao;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.field.GenTableField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shiling_deng
 * @version 2021/02/28
 */
@Mapper
public interface GenTableDao extends BaseDao<GenTable, GenTableField> {

    /**
     * 查询当前数据库下的所有表
     * @return
     */
    List<GenTable> selectAllTableForDatabase();

    /**
     * 根据表名查询出表描述
     * @param tableName
     * @return
     */
    String selectCommentsForTableName(String tableName);
}