package com.democxy.modules.sys.entity.field;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author shiling_deng
 * @version 2021/4/14
 */
@Data
public class LoginField {

    /** 登录账号 */
    @ApiModelProperty(value = "登录账号", required = true, example = "admin")
    @NotNull(message = "登录账号不能为空")
    private String accountNo;

    /** 登录密码 */
    @ApiModelProperty(value = "登录密码", required = true, example = "123456")
    @NotNull(message = "登录账号不能为空")
    private String password;

    /** 验证码 */
    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码", required = true, example = "1234")
    private String code;

    /** 登录类型 */
    @ApiModelProperty(value = "登录类型", required = false, example = "mobile")
    private String loginType;
}
