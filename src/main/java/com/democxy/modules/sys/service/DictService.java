package com.democxy.modules.sys.service;

import com.democxy.common.global.BaseService;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;

import java.util.List;

public interface DictService extends BaseService<Dict, DictField> {

    List<Dict> findDistinct (DictField dictField);
}
