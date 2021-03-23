package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;

import java.util.List;
import java.util.Set;

/**
 * @author shiling_deng
 */
public interface MenuService extends BaseService<Menu, MenuField> {

    /**
     * 删除id及对应ID下的所有子菜单
     * @param id
     * @return
     */
    int delMore(String id);

    /**
     * 根据角色ID查询菜单列表
     * @param roleId
     * @return
     */
    List<Menu> findByRoleId(int roleId);

    /**
     * 根据角色ID查询权限列表
     * @param roleId
     * @return
     */
    Set<String> getPermsForRole(int roleId);
}
