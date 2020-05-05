package com.democxy.common.global;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class BaseController<S extends BaseService<T>,T> {

    @Autowired
    public S service;

    /**
     * 添加用户
     * @param t
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponeData<String> addUser(@Valid @RequestBody T t ){
        //调用业务逻辑，处理业务
        service.insert(t);
        return new ResponeData<>("添加成功");
    }

    @ResponseBody
    @RequestMapping(value = "del/{id}",method = RequestMethod.GET)
    public ResponeData<String> delById(@PathVariable("id") String id){
        service.delete(id);
        return new ResponeData<>(ResultCode.SUCCESS,"删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponeData<String> update(@Valid @RequestBody T t){
        //调用业务逻辑，处理业务
        service.update(t);
        return new ResponeData<>("更新成功");
    }


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponeData<List> findList(T t){
        //调用业务逻辑，处理业务
        List<T> list = service.findList(t);
        return new ResponeData<List>(ResultCode.SUCCESS,list);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    public ResponeData<T> getById(@PathVariable("id") String id){
        T account = service.getById(id);
        return new ResponeData<T>(ResultCode.SUCCESS,account);
    }



}
