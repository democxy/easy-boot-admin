package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuDao extends BaseDao<Menu, MenuField> {

    List<Menu> findByRoleId(int roleId);

    Set<String> getPermsForRole(int roleId);
}
