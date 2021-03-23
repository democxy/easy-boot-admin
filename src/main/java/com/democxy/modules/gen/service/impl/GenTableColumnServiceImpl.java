package com.democxy.modules.gen.service.impl;

import com.democxy.common.global.BaseServiceImpl;
import com.democxy.modules.gen.dao.GenTableColumnDao;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.service.GenTableColumnService;
import org.springframework.stereotype.Service;

/**
 * @author shiling_deng
 * @version 2021/03/03
 */
@Service
public class GenTableColumnServiceImpl extends BaseServiceImpl<GenTableColumnDao, GenTableColumn, GenTableColumnField> implements GenTableColumnService {

}