package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.LoginRequired;
import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.BasePageQuery;
import com.democxy.common.global.ResponeData;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.RoleField;
import com.democxy.modules.sys.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin/role")
public class RoleController extends BaseController<RoleService, Role, RoleField> {

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @LoginRequired
    @Permission(value = "sys:dict:add")
    public ResponeData<String> save(@Valid @RequestBody RoleField f ){
        //调用业务逻辑，处理业务
        return super.save(f);
    }

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @LoginRequired
    @Permission(value = "sys:dict:add")
    public ResponeData<String> addUser(@Valid @RequestBody RoleField f ){
        return super.addUser(f);
    }

    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    @LoginRequired
    @Permission(value = "sys:dict:del")
    public ResponeData<String> delById(@PathVariable("id") String id){
        return super.delById(id);
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @LoginRequired
    @Permission(value = "sys:dict:edit")
    public ResponeData<String> update(@Valid @RequestBody RoleField f){
        return super.update(f);
    }


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<List> findList(RoleField f){
        return super.findList(f);
    }

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<RoleField> basePageQuery){
        return super.findPage(basePageQuery);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @LoginRequired
    @Permission(value = "sys:dict:view")
    public ResponeData<Role> getById(@PathVariable("id") String id){
        return super.getById(id);
    }

}
