package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.MenuRole;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @author shiling_deng
 */
@Mapper
public interface RoleDao extends BaseDao<Role, RoleField> {

    /**
     * 插入菜单角色关系数据
     * @param menuRole
     * @return
     */
    int insertMenuRole(MenuRole menuRole);

    /**
     * 根据角色ID查询菜单ID集合
     * @param roleId
     * @return 角色ID关联的菜单ID集合
     */
    Set<String> selectMenuIdByRole(String roleId);

    /**
     * 根据角色ID删除菜单数据
     * @param roleId
     * @return
     */
    int delMenuIdByRole(String roleId);
}
