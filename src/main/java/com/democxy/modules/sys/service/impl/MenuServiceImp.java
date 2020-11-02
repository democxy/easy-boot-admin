package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.MenuDao;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;
import com.democxy.modules.sys.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImp extends BaseServiceImp<MenuDao, Menu, MenuField> implements MenuService {
}
