package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.Log;
import com.democxy.common.annotation.PassLogin;
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

/**
 * @author shiling_deng
 */
@RestController
@RequestMapping("admin/role")
public class RoleController extends BaseController<RoleService, Role, RoleField> {

    /**
     * 添加用户
     * @param f
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @Permission(value = "sys:role:add")
    @Log(title = "添加/修改角色")
    public ResponeData<String> save(@Valid @RequestBody RoleField f ){
        //调用业务逻辑，处理业务
        return super.save(f);
    }

    /**
     * 添加用户
     * @param f
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @Permission(value = "sys:role:add")
    public ResponeData<String> add(@Valid @RequestBody RoleField f ){
        return super.add(f);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:role:del")
    public ResponeData<String> delById(@PathVariable("id") String id){
        return super.delById(id);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @Permission(value = "sys:role:edit")
    public ResponeData<String> update(@Valid @RequestBody RoleField f){
        return super.update(f);
    }


    @Override
    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponeData<List> findList(RoleField f){
        return super.findList(f);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<RoleField> basePageQuery){
        return super.findPage(basePageQuery);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:role:view")
    public ResponeData<Role> getById(@PathVariable("id") String id){
        return super.getById(id);
    }

}
