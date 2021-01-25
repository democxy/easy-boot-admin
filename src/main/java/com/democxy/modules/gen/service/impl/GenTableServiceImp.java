package com.democxy.modules.gen.service.impl;

import com.democxy.common.global.BaseServiceImp;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.dao.GenTableColumnDao;
import com.democxy.modules.gen.dao.GenTableDao;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.entity.field.GenTableField;
import com.democxy.modules.gen.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenTableServiceImp extends BaseServiceImp<GenTableDao, GenTable, GenTableField> implements GenTableService {

    @Autowired
    GenTableColumnDao genTableColumnDao;

    @Override
    public int save(GenTableField entity) {
        if (StringUtils.isEmpty(entity.getId())){
            entity.setId(IdGenUtil.getUUID());
            dao.insert(entity);
        }else {
            dao.update(entity);
        }
        List<GenTableColumnField> columnList = entity.getColumnList();
        for (GenTableColumnField genTableColumn : columnList) {
            genTableColumn.setGenTableId(entity.getId());
            if (StringUtils.isEmpty(genTableColumn.getId())){
                genTableColumn.setId(IdGenUtil.getUUID());
                genTableColumnDao.insert(genTableColumn);
            }else {
                genTableColumnDao.update(genTableColumn);
            }
        }
        return super.save(entity);
    }
}