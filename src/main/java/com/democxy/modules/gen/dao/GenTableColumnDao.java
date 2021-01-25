package com.democxy.modules.gen.dao;


import com.democxy.common.global.BaseDao;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenTableColumnDao extends BaseDao<GenTableColumn, GenTableColumnField> {

}