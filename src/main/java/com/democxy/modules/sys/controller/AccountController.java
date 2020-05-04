package com.democxy.modules.sys.controller;

import com.democxy.common.global.ResponeData;
import com.democxy.common.global.ResultCode;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 添加用户
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public ResponeData<String> addUser(@Valid Account account){
        //调用业务逻辑，处理业务
        accountService.insert(account);
        return new ResponeData<>("操作成功");
    }

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResponeData<List> findList(Account account){
        //调用业务逻辑，处理业务
        List<Account> list = accountService.findList(account);
        return new ResponeData<List>(ResultCode.SUCCESS,list);
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponeData<Account> login(@Valid Account account){
        //调用业务逻辑，处理业务
        Account login= accountService.login(account);
        if (login!=null){
            return new ResponeData<Account>(ResultCode.SUCCESS,login);
        }else{
            return new ResponeData<Account>(ResultCode.LOGIN_FAILED,null);
        }

    }

}
