package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.PassLogin;
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

/**
 * @author shiling_deng
 */
@RestController
@RequestMapping("/admin/dict")
public class DictController extends BaseController<DictService, Dict, DictField> {

    /**
     * 添加用户
     * @param f
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
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
    @Override
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @Permission(value = "sys:dict:add")
    public ResponeData<String> addUser(@Valid @RequestBody DictField f ){
        return super.addUser(f);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:dict:del")
    public ResponeData<String> delById(@PathVariable("id") String id){
        return super.delById(id);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @Permission(value = "sys:dict:edit")
    public ResponeData<String> update(@Valid @RequestBody DictField f){
        return super.update(f);
    }


    @Override
    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponeData<List> findList(@RequestBody DictField f){
        return super.findList(f);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<DictField> basePageQuery){
        //调用业务逻辑，处理业务
        PageHelper.startPage(basePageQuery.getPageNum(), basePageQuery.getPageSize());
        List<Dict> list = service.findDistinct(basePageQuery.getEntity());
        PageInfo<Dict> pageInfo = new PageInfo<Dict>(list,5);
        return new ResponeData<>(ResultEnum.SUCCESS, pageInfo);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:dict:view")
    public ResponeData<Dict> getById(@PathVariable("id") String id){
        return super.getById(id);
    }


}
