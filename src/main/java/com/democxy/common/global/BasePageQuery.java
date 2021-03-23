package com.democxy.common.global;

import lombok.Data;

/**
 * @author shiling_deng
 */
@Data
public class BasePageQuery<F extends BaseFiled<F>> {

    private int pageNum;

    private int pageSize;

    private F entity;
}
