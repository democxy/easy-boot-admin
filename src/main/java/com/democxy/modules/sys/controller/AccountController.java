package com.democxy.modules.sys.controller;

import com.democxy.common.global.ResponeData;
import com.democxy.modules.sys.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class AccountController {

    /**
     * 添加用户
     * @param account
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public ResponeData<String> addUser(@Valid Account account){
        System.out.println(account.getAccountNo());
        int i = 5/0;
        return new ResponeData<>("操作成功");
    }

}
