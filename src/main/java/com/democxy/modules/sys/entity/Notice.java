package com.democxy.modules.sys.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author shiling_deng
 */
@Data
public class Notice {

    /**
     * ID
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型
     */
    private String type;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布时间
     */
    private Date createTime;
    /**
     * 发布人
     */
    private String createBy;

}