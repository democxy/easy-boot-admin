package com.democxy.common.enums;

/**
 * 响应枚举类
 * @author shiling
 * @version 2020-04-28
 */
public enum ResultEnum {

    VALIDATE_FAILED(1002, "参数校验失败"),

    SUCCESS(200, "操作成功"),

    FAILED(500, "响应失败"),

    NOT_FOUND(404, "未知请求"),

    LOGIN_FAILED(4040, "用户验证失败或长时间未操作身份已过期，请重新登录！"),

    NO_PERMISSION(4041, "对不起！您无操作权限！"),

    CODE_CHECK_ERROR(4042, "验证码错误！"),

    ACCOUNT_ERROR(4043, "账号密码错误"),

    FIX_PASS_CHECK_PASS_FAILED(4044, "旧密码验证不通过"),

    PASSWORD_NO_EQU(4045, "确认密码不一致");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
