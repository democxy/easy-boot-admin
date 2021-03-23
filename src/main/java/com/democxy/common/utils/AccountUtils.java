package com.democxy.common.utils;

import com.alibaba.fastjson.JSON;
import com.democxy.modules.sys.entity.Account;

/**
 * 当前用户工具类
 * @author shiling_deng
 */
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

    public static Account getAccount(){
        try {
            Object login = ServletUtils.getSession().getAttribute("login");
            Account account = null;
            if (login!=null){
                account = (Account) login;
            }
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Account();
    }
}
