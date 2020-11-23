package com.democxy.modules.sys.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.sys.dao.DictDao;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.field.DictField;
import com.democxy.modules.sys.service.DictService;
import org.springframework.stereotype.Service;

@Service("dict")
public class DictServiceImp extends BaseServiceImp<DictDao, Dict, DictField> implements DictService {
}
