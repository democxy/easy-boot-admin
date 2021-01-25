package com.democxy.modules.gen.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.modules.gen.dao.GenTableColumnDao;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.service.GenTableColumnService;
import org.springframework.stereotype.Service;

@Service
public class GenTableColumnServiceImp extends BaseServiceImp<GenTableColumnDao, GenTableColumn, GenTableColumnField> implements GenTableColumnService {

}