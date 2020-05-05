package com.democxy.common.global;

import lombok.Data;

/**
 * 响应数据
 */
@Data
public class ResponeData<T> {

    private int code;

    private String msg;

    private T data;

    public ResponeData(T data) {
        this(ResultCode.SUCCESS,data);
    }

    public ResponeData(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
