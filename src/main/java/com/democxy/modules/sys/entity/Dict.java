package com.democxy.modules.sys.entity;

import com.democxy.common.global.BaseFiled;
import lombok.Data;

@Data
public class Dict extends BaseFiled<Dict> {

    /**
     * 数据值
     */
    private String value;
    /**
     * 标签名
     */
    private String label;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String description;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父Id
     */
    private String parentId;
}
