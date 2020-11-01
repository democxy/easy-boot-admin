package com.democxy.common.global;

import lombok.Data;

@Data
public class BasePageQuery<F> {

    private int pageNum;

    private int pageSize;

    private F entity;
}
