package com.democxy.modules.sys.entity.field;

import com.democxy.common.global.BaseFiled;
import lombok.Data;

import java.util.List;

/**
 * @author shiling_deng
 */
@Data
public class DictField extends BaseFiled<DictField> {
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

    /**
     * 删除的IDS
     */
    private List<String> delIds;
    /**
     * 所有键值
     */
    private List<DictField> dictList;
}
