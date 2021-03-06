package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImpl;
import com.democxy.common.global.SystemCache;
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

import java.util.Set;

/**
 * @author shiling_deng
 */
@Service("role")
public class RoleServiceImpl extends BaseServiceImpl<RoleDao, Role, RoleField> implements RoleService {

    @Autowired
    MenuDao menuDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
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

    @Override
    public Role getById(String id){
        Role byId = dao.getById(id);
        Set<String> integers = dao.selectMenuIdByRole(id);
        byId.setMenuIds(integers);
        return byId;
    }

}
