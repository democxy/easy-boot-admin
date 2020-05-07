package com.democxy.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.JwtUtil;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.AccountField;
import com.democxy.modules.sys.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/account")
public class AccountController extends BaseController<AccountService, Account,AccountField > {

    @Override
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponeData<String> addUser(@Valid @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        accountField.setAccountId(IdGenUtil.getUUID());
        service.insert(accountField);
        return new ResponeData<>("添加成功");
    }

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    public ResponeData<PageInfo> findPage( @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        PageHelper.startPage(accountField.getPageNo(), accountField.getPageSize());
        List<Account> list = service.findList(accountField);
        PageInfo<Account> pageInfo = new PageInfo<Account>(list,5);
        return new ResponeData<>(ResultEnum.SUCCESS, pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponeData<String> login(@Valid @RequestBody AccountField accountField){
        //调用业务逻辑，处理业务
        Account login= service.login(accountField);
        if (login!=null){
            //计算token
            String token = JwtUtil.signToken(login.getAccountId(), JSON.toJSONString(login), JwtUtil.EXPIRE_TIME);
            return new ResponeData<>(ResultEnum.SUCCESS,token);
        }else{
            return new ResponeData<>(ResultEnum.LOGIN_FAILED,"用户名或密码错误！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.POST)
    public ResponeData<String> getAccountByToken(String token) {
        Claims claims = JwtUtil.parseToken(token);
        String subject = claims.getSubject();
        return new ResponeData<>(ResultEnum.SUCCESS,subject);
    }

}
