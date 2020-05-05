package com.democxy.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.common.global.ResultCode;
import com.democxy.common.utils.JwtUtil;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.service.AccountService;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/account")
public class AccountController extends BaseController<AccountService,Account> {

    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponeData<String> login(@Valid Account account){
        //调用业务逻辑，处理业务
        Account login= service.login(account);
        if (login!=null){
            //计算token
            String token = JwtUtil.signToken(login.getAccountId(), JSON.toJSONString(login), JwtUtil.EXPIRE_TIME);
            return new ResponeData<String>(ResultCode.SUCCESS,token);
        }else{
            return new ResponeData<String>(ResultCode.LOGIN_FAILED,"用户名或密码错误！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.POST)
    public ResponeData<String> getAccountByToken(String token) {
        Claims claims = JwtUtil.parseToken(token);
        String subject = claims.getSubject();
        return new ResponeData<String>(ResultCode.SUCCESS,subject);
    }

}
