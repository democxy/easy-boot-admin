package com.democxy.common.exception;

/**
 * 自定义异常类
 * @author shiling
 * @version 2020-04-28
 */
public class CustomException extends RuntimeException {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CustomException() {
        this(1001, "接口错误");
    }

    public CustomException(String msg) {
        this(1001, msg);
    }

    public CustomException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}
