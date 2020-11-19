package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.common.utils.TreeUtils;
import com.democxy.modules.sys.dao.MenuDao;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;
import com.democxy.modules.sys.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImp extends BaseServiceImp<MenuDao, Menu, MenuField> implements MenuService {

    @Override
    @Transactional
    public int delMore(String id) {
        List<Menu> list = dao.findList(new MenuField());
        List<Menu> childPerms = TreeUtils.getChildPerms(list, id);
        childPerms.forEach(menu -> {
            dao.delete(menu.getId());
        });
        dao.delete(id);
        return 0;
    }

    @Override
    public List<Menu> findByRoleId(int roleId) {
        return dao.findByRoleId(roleId);
    }

    @Override
    public Set<String> getPermsForRole(int roleId){
        return dao.getPermsForRole(roleId);
    }

}
