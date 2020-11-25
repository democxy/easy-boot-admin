package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.LoginRequired;
import com.democxy.common.annotation.Permission;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.BasePageQuery;
import com.democxy.common.global.ResponeData;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;
import com.democxy.modules.sys.service.DictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/dict")
public class DictController extends BaseController<DictService, Dict, DictField> {

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @LoginRequired
    @Permission(value = "sys:dict:add")
    public ResponeData<String> save(@Valid @RequestBody DictField f ){
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
    public ResponeData<String> addUser(@Valid @RequestBody DictField f ){
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
    public ResponeData<String> update(@Valid @RequestBody DictField f){
        return super.update(f);
    }


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<List> findList(DictField f){
        return super.findList(f);
    }

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<DictField> basePageQuery){
        //调用业务逻辑，处理业务
        PageHelper.startPage(basePageQuery.getPageNum(), basePageQuery.getPageSize());
        List<Dict> list = service.findDistinct(basePageQuery.getEntity());
        PageInfo<Dict> pageInfo = new PageInfo<Dict>(list,5);
        return new ResponeData<>(ResultEnum.SUCCESS, pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @LoginRequired
    @Permission(value = "sys:dict:view")
    public ResponeData<Dict> getById(@PathVariable("id") String id){
        return super.getById(id);
    }
}
