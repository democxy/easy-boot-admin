package com.democxy.modules.gen.service.impl;

import com.democxy.common.config.ProjectConfig;
import com.democxy.common.global.BaseServiceImpl;
import com.democxy.common.utils.IdGenUtil;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.dao.GenTableColumnDao;
import com.democxy.modules.gen.dao.GenTableDao;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.entity.field.GenTableField;
import com.democxy.modules.gen.service.GenTableService;
import com.democxy.modules.gen.utils.GenCodeUtil;
import com.democxy.modules.gen.vo.PreViewCode;
import com.google.common.collect.Lists;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.configuration.Configuration;

import java.util.*;

/**
 * @author shiling_deng
 * @version 2021/03/03
 */
@Service
public class GenTableServiceImpl extends BaseServiceImpl<GenTableDao, GenTable, GenTableField> implements GenTableService {

    @Autowired
    GenTableColumnDao genTableColumnDao;
    @Autowired
    GenCodeUtil genCodeUtil;
    @Autowired
    ProjectConfig projectConfig;

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
        //????????????
        Configuration config = getConfig();
        for (String tableName : tableNames) {
            // ??????????????????
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

                //??????????????????????????????Java??????
                String javaType = config.getString(genTableColumn.getJdbcType(), "unknowType");
                genTableColumn.setJavaType(javaType);
                genTableColumnDao.insert(genTableColumn);
                sort += 10;
            }
        }
    }

    @Override
    public Map<String, Object> getGenTempModelData(String id) {
        GenTable genTable = this.getById(id);
        List<GenTableColumn> columns = genTableColumnDao.findList(new GenTableColumnField(id));
        genTable.setColumnList(columns);
        // ????????????
        List<String> importList = Lists.newArrayList();
        for (GenTableColumn genTableColumn : columns) {
            // ???????????????????????? ????????????????????????.??????????????????????????????
            if (StringUtils.indexOf(genTableColumn.getJavaType(), ".") != -1 && !importList.contains(genTableColumn.getJavaType())){
                importList.add(genTableColumn.getJavaType());
                genTableColumn.setJavaType(genTableColumn.getJavaType().substring(genTableColumn.getJavaType().lastIndexOf(".") + 1));
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("packageName", genTable.getPackageName());
        map.put("moduleName", genTable.getModelName());
        map.put("ClassName", genTable.getClassName());
        map.put("className", StringUtils.toLowerForFistChar(genTable.getClassName()));
        map.put("columnList", columns);
        map.put("table", genTable);
        map.put("importList", importList);
        return map;
    }

    @Override
    public List<PreViewCode> preViewCode(String id) {
        Map<String,Object> map = getGenTempModelData(id);
        String filePath = projectConfig.getBasepath() + "/gencode/src/main" ;
        String javaPath = filePath + "/java/" + map.get("packageName").toString() + "/modules/" + map.get("moduleName").toString();
        String mapperPath = filePath + "/resources/mapper/" + map.get("moduleName").toString();
        String sqlPath = filePath + "/resources/sql/" + map.get("moduleName").toString();;
        String htmlPath = filePath + "/resources/templates/" + map.get("moduleName").toString();
        String ClassName = map.get("ClassName").toString();
        String className = map.get("className").toString();
        List<PreViewCode> preViewCodes = new ArrayList<>();
        preViewCodes.add(new PreViewCode(javaPath + "/entity", ClassName+".java",genCodeUtil.preViewCode("codetemp/entity.ftl", map)));
        preViewCodes.add(new PreViewCode(javaPath + "/entity/field",ClassName+"Field.java",genCodeUtil.preViewCode("codetemp/filed.ftl", map)));
        preViewCodes.add(new PreViewCode(javaPath + "/service",ClassName+"Service.java",genCodeUtil.preViewCode("codetemp/service.ftl", map)));
        preViewCodes.add(new PreViewCode(javaPath + "/service/impl",ClassName+"ServiceImpl.java",genCodeUtil.preViewCode("codetemp/serviceImpl.ftl", map)));
        preViewCodes.add(new PreViewCode(javaPath + "/dao",ClassName+"Dao.java",genCodeUtil.preViewCode("codetemp/dao.ftl", map)));
        preViewCodes.add(new PreViewCode(javaPath + "/controller",ClassName+"Controller.java",genCodeUtil.preViewCode("codetemp/controller.ftl", map)));
        preViewCodes.add(new PreViewCode(mapperPath,ClassName+"Mapper.xml",genCodeUtil.preViewCode("codetemp/mapper.ftl", map)));
        preViewCodes.add(new PreViewCode(htmlPath,className+"List.html",genCodeUtil.preViewCode("codetemp/viewList.ftl", map)));
        preViewCodes.add(new PreViewCode(htmlPath,className+"Form.html",genCodeUtil.preViewCode("codetemp/viewForm.ftl", map)));
        preViewCodes.add(new PreViewCode(sqlPath,ClassName+"MenuSql.sql",genCodeUtil.preViewCode("codetemp/menuSql.ftl", map)));
        return preViewCodes;
    }

    /**
     * ??????????????????
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("????????????????????????");
        }
    }
}