package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.MenuRole;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface RoleDao extends BaseDao<Role, RoleField> {

    int insertMenuRole(MenuRole menuRole);

    Set<String> selectMenuIdByRole(String roleId);

    int delMenuIdByRole(String roleId);
}
