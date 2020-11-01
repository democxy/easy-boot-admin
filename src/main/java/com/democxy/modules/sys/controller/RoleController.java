package com.democxy.modules.sys.controller;

import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.RoleField;
import com.democxy.modules.sys.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin/role")
public class RoleController extends BaseController<RoleService, Role, RoleField> {

    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponeData<String> addUser(@Valid @RequestBody RoleField roleField){
        //调用业务逻辑，处理业务
        if (StringUtils.isEmpty(roleField.getId())){
            service.insert(roleField);
            return new ResponeData<>("添加成功");
        }else {
            service.update(roleField);
            return new ResponeData<>("更新成功");
        }
    }
}
