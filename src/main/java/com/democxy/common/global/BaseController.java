package com.democxy.common.global;

import com.democxy.common.annotation.Permission;
import com.democxy.common.enums.ResultEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author shiling_deng
 */
public class BaseController<S extends BaseService<T, F>, T, F extends BaseFiled<F>> {

    @Autowired
    public S service;

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ResponeData<String> save(@Valid @RequestBody F f ){
        //调用业务逻辑，处理业务
        service.save(f);
        return new ResponeData<>("添加成功");
    }

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponeData<String> addUser(@Valid @RequestBody F f ){
        //调用业务逻辑，处理业务
        service.insert(f);
        return new ResponeData<>("添加成功");
    }

    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public ResponeData<String> delById(@PathVariable("id") String id){
        service.delete(id);
        return new ResponeData<>(ResultEnum.SUCCESS,"删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponeData<String> update(@Valid @RequestBody F f){
        //调用业务逻辑，处理业务
        service.update(f);
        return new ResponeData<>("更新成功");
    }


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponeData<List> findList(@RequestBody F f){
        //调用业务逻辑，处理业务
        List<T> list = service.findList(f);
        return new ResponeData<List>(ResultEnum.SUCCESS,list);
    }

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public ResponeData<PageInfo> findPage( @RequestBody BasePageQuery<F> basePageQuery){
        //调用业务逻辑，处理业务
        PageHelper.startPage(basePageQuery.getPageNum(), basePageQuery.getPageSize());
        List<T> list = service.findList(basePageQuery.getEntity());
        PageInfo<T> pageInfo = new PageInfo<T>(list,5);
        return new ResponeData<>(ResultEnum.SUCCESS, pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @Permission(value = "permission")
    public ResponeData<T> getById(@PathVariable("id") String id){
        T account = service.getById(id);
        return new ResponeData<T>(ResultEnum.SUCCESS,account);
    }



}
