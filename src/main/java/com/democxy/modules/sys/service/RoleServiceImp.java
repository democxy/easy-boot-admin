package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.RoleDao;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.RoleField;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp extends BaseServiceImp<RoleDao, Role, RoleField> implements RoleService {
}
