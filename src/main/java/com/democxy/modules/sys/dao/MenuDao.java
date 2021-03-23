package com.democxy.modules.sys.dao;

import com.democxy.common.global.BaseDao;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * @author shiling_deng
 */
@Mapper
public interface MenuDao extends BaseDao<Menu, MenuField> {

    /**
     * 根据角色ID查询菜单列表
     * @param roleId
     * @return 角色ID下的菜单列表
     */
    List<Menu> findByRoleId(int roleId);

    /**
     * 根据角色ID查询访问权限列表
     * @param roleId
     * @return 角色ID下的访问权限列表
     */
    Set<String> getPermsForRole(int roleId);
}
