package com.democxy.modules.sys.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 系统账号实体类
 * @author shiling
 * @version 2020-04-28
 */
public class Account {

    //账号ID 计划使用UUID，方便跟各用户之间进行一对一关联
    private String accountId;
    //登录账号
    @NotNull(message = "登录账号不能为空")
    private String accountNo;
    //登录密码
    @Size(min = 5, max = 11, message = "密码长度必须介于5-11之间")
    private String password;
    //用户身份
    private String role;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Account() {
    }

    public Account(String accountId, @NotNull(message = "登录账号不能为空") String accountNo, @Size(min = 5, max = 11, message = "密码长度必须介于5-11之间") String password, String role) {
        this.accountId = accountId;
        this.accountNo = accountNo;
        this.password = password;
        this.role = role;
    }
}
