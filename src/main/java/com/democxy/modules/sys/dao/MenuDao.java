package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDao extends BaseDao<Menu, MenuField> {
}