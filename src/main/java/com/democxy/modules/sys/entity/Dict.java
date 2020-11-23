package com.democxy.modules.sys.entity;

import com.democxy.common.global.BaseFiled;
import lombok.Data;

@Data
public class Dict extends BaseFiled<Dict> {

    private String value;	// 数据值
    private String label;	// 标签名
    private String type;	// 类型
    private String description;// 描述
    private Integer sort;	// 排序
    private String parentId;//父Id
}
