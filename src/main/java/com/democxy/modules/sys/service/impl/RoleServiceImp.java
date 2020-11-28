package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.common.global.SystemCache;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.dao.MenuDao;
import com.democxy.modules.sys.dao.RoleDao;
import com.democxy.modules.sys.entity.MenuRole;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import com.democxy.modules.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("role")
public class RoleServiceImp extends BaseServiceImp<RoleDao, Role, RoleField> implements RoleService {

    @Autowired
    MenuDao menuDao;

    @Override
    @Transactional
    public int save(RoleField entity){
        if (StringUtils.isEmpty(entity.getId())){
            dao.insert(entity);
        }else {
            dao.update(entity);
        }
        dao.delMenuIdByRole(entity.getId());
        Set<String> menuIds = entity.getMenuIds();
        menuIds.forEach(menu ->{
            MenuRole menuRole = new MenuRole(menu,entity.getId());
            dao.insertMenuRole(menuRole);
        });
        // 更新缓存
        SystemCache.ROLE_MENU_CACHE.put(entity.getId(),menuDao.getPermsForRole(Integer.valueOf(entity.getId())));
        return 0;
    }

    public Role getById(String id){
        Role byId = dao.getById(id);
        Set<String> integers = dao.selectMenuIdByRole(id);
        byId.setMenuIds(integers);
        return byId;
    }

}
