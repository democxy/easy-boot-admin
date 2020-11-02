package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao extends BaseDao<Role, RoleField> {
}
