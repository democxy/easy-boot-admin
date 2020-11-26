package com.democxy.modules.sys.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskJob {

    private String id;

    private String taskName;

    private String methodName;

    private String methodParams;

    private String cronType;

    private String remark;

    private String taskStatus;

    private Date createTime;
}
