package com.democxy.common.utils;

import com.alibaba.fastjson.JSON;
import com.democxy.modules.sys.entity.Account;

public class AccountUtils {

    /**
     * 根据token获取登录用户的信息
     * @param token
     * @return
     */
    public static Account getAccountByToken(String token){
        try {
            String subject = JwtUtil.parseToken(token).getSubject();
            Account account = JSON.parseObject(subject, Account.class);
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Account();
    }
}
