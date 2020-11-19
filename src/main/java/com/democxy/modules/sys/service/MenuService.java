package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;

import java.util.List;
import java.util.Set;

public interface MenuService extends BaseService<Menu, MenuField> {

    int delMore(String id);

    List<Menu> findByRoleId(int roleId);

    Set<String> getPermsForRole(int roleId);
}
