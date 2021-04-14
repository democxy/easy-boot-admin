package com.democxy.modules.sys.entity.field;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author shiling_deng
 * @version 2021/4/14
 */
@Data
public class LoginField {

    /** 登录账号 */
    @NotNull(message = "登录账号不能为空")
    private String accountNo;

    /** 登录密码 */
    @NotNull(message = "登录账号不能为空")
    private String password;

    /** 验证码 */
    @NotNull(message = "验证码不能为空")
    private String code;

    /** 登录类型 */
    private String loginType;
}
