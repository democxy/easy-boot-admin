package com.democxy.modules.sys.controller;

import com.democxy.common.global.BaseController;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import com.democxy.modules.sys.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/role")
public class RoleController extends BaseController<RoleService, Role, RoleField> {

}
