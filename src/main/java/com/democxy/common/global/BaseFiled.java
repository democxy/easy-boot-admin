package com.democxy.common.global;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseFiled<T> implements Serializable {

    protected String id;

    protected String createBy;

    protected Date createTime;

    protected String updateBy;

    protected String updateTime;

    protected String remark;

    protected String delFlag;

}
