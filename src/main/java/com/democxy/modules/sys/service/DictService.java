package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;

import java.util.List;

/**
 * @author shiling_deng
 */
public interface DictService extends BaseService<Dict, DictField> {

    /**
     * 查询字典列表
     * @param dictField
     * @return 字典列表
     */
    List<Dict> findDistinct (DictField dictField);
}
