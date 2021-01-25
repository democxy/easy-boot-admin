package com.democxy.modules.gen.dao;


import com.democxy.common.global.BaseDao;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.field.GenTableField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenTableDao extends BaseDao<GenTable, GenTableField> {

}