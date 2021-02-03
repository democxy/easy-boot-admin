package com.democxy.modules.gen.dao;


import com.democxy.common.global.BaseDao;
import com.democxy.modules.gen.entity.TemplateInfo;
import com.democxy.modules.gen.entity.field.TemplateInfoField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TemplateInfoDao extends BaseDao<TemplateInfo, TemplateInfoField> {

}