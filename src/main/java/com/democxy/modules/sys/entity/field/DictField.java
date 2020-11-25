package com.democxy.modules.sys.entity.field;

import com.democxy.common.global.BaseFiled;
import lombok.Data;

import java.util.List;

@Data
public class DictField extends BaseFiled<DictField> {
    private String value;	// 数据值
    private String label;	// 标签名
    private String type;	// 类型
    private String description;// 描述
    private Integer sort;	// 排序
    private String parentId;//父Id

    // 业务字段
    private List<String> delIds; // 删除的IDS
    private List<DictField> dictList; // 所有键值
}
