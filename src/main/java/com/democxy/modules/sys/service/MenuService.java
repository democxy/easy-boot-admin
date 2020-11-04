package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;

public interface MenuService extends BaseService<Menu, MenuField> {

    int delMore(String id);
}
