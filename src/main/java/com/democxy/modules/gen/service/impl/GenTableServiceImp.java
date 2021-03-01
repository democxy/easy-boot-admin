package com.democxy.modules.gen.service.impl;

import com.alibaba.fastjson.JSON;
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
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.configuration.Configuration;

import java.util.Date;
import java.util.List;

@Service
public class GenTableServiceImp extends BaseServiceImp<GenTableDao, GenTable, GenTableField> implements GenTableService {

    @Autowired
    GenTableColumnDao genTableColumnDao;

    @Override
    public int save(GenTableField entity) {
        if (StringUtils.isEmpty(entity.getId())){
            entity.setId(IdGenUtil.getUUID());
            entity.setCreateTime(new Date());
            entity.setUpdateTime(new Date());
            dao.insert(entity);
        }else {
            entity.setUpdateTime(new Date());
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

    @Override
    public List<GenTable> selectAllTableForDatabase() {
        return dao.selectAllTableForDatabase();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGenTableForTableName(List<String> tableNames) {
        //配置信息
        Configuration config = getConfig();
        for (String tableName : tableNames) {
            // 查询出表描述
            String comments = dao.selectCommentsForTableName(tableName);
            GenTableField genTable = new GenTableField();
            genTable.setId(IdGenUtil.getUUID());
            genTable.setName(tableName);
            genTable.setComments(comments);
            genTable.setClassName(StringUtils.toCapitalizeCamelCase(tableName));
            genTable.setDelFlag("0");
            dao.insert(genTable);
            List<GenTableColumnField> genTableColumns = genTableColumnDao.selectColumnsForTableName(tableName);
            int sort = 10;
            for (GenTableColumnField genTableColumn : genTableColumns) {
                genTableColumn.setId(IdGenUtil.getUUID());
                genTableColumn.setSort(sort);
                genTableColumn.setGenTableId(genTable.getId());
                genTableColumn.setJavaField(StringUtils.toCamelCase(genTableColumn.getName()));
                genTableColumn.setDelFlag("0");
                genTableColumn.setIsEdit(true);
                genTableColumn.setIsInsert(true);
                genTableColumn.setIsList(true);
                genTableColumn.setIsQuery(false);
                genTableColumn.setShowType("input");

                //列的数据类型，转换成Java类型
                String javaType = config.getString(genTableColumn.getJdbcType(), "unknowType");
                genTableColumn.setJavaType(javaType);
                genTableColumnDao.insert(genTableColumn);
                sort += 10;
            }
        }
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("获取配置文件失败");
        }
    }
}