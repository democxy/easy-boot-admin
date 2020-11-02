package com.democxy.common.global;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseFiled<T> implements Serializable {

    protected String id;

    private Integer pageNum;

    private Integer pageSize;
}
