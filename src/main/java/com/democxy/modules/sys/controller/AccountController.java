package com.democxy.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.democxy.common.annotation.LoginRequired;
import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.BasePageQuery;
import com.democxy.common.global.ResponeData;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.JwtUtil;
import com.democxy.common.utils.ServletUtils;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.field.AccountField;
import com.democxy.modules.sys.service.AccountService;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/admin/account")
public class AccountController extends BaseController<AccountService, Account,AccountField > {

    @Override
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @Permission(value = "sys:account:add")
    public ResponeData<String> save(@Valid @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        if (StringUtils.isEmpty(accountField.getAccountId())){
            accountField.setAccountId(IdGenUtil.getUUID());
            service.insert(accountField);
            return new ResponeData<>("添加成功");
        }else {
            service.update(accountField);
            return new ResponeData<>("更新成功成功");
        }


    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponeData<Map<String,Object>> login(@Valid @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        Account login= service.login(accountField);
        Map<String,Object> map = new HashMap<>();
        if (login!=null){
            //计算token
            String token = JwtUtil.signToken(login.getAccountId(), JSON.toJSONString(login), JwtUtil.EXPIRE_TIME);
            map.put("token",token);
            map.put("login",login);
            ServletUtils.getSession().setAttribute("login",login);
            return new ResponeData<>(ResultEnum.SUCCESS,map);
        }else{
            return new ResponeData<>(ResultEnum.LOGIN_FAILED,null);
        }
    }

    @ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<String> getAccountByToken(HttpServletRequest request) {
        Claims claims = JwtUtil.parseToken(request.getHeader("token"));
        String subject = claims.getSubject();
        return new ResponeData<>(ResultEnum.SUCCESS,subject);
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
    public ResponeData<String> addUser(@Valid @RequestBody AccountField f ){
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
    public ResponeData<String> update(@Valid @RequestBody AccountField f){
        return super.update(f);
    }


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<List> findList(AccountField f){
        return super.findList(f);
    }

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    @LoginRequired
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<AccountField> basePageQuery){
        return super.findPage(basePageQuery);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @LoginRequired
    @Permission(value = "sys:dict:view")
    public ResponeData<Account> getById(@PathVariable("id") String id){
        return super.getById(id);
    }

}
