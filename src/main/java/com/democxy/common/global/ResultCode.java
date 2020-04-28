package com.democxy.common.global;

/**
 * 响应枚举类
 * @author shiling
 * @version 2020-04-28
 */
public enum ResultCode {

    VALIDATE_FAILED(1002, "参数校验失败"),

    SUCCESS(200, "操作成功"),

    FAILED(500, "响应失败"),

    NOT_FOUND(404, "未知请求");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
