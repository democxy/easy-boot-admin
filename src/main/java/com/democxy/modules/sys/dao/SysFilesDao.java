package com.democxy.modules.sys.dao;


import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.SysFiles;
import com.democxy.modules.sys.entity.field.SysFilesField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysFilesDao extends BaseDao<SysFiles, SysFilesField> {

}