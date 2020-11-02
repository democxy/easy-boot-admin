package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.RoleDao;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import com.democxy.modules.sys.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp extends BaseServiceImp<RoleDao, Role, RoleField> implements RoleService {
}
