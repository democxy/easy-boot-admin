package ${packageName}.modules.${moduleName}.service.impl;

import org.springframework.stereotype.Service;

import ${packageName}.common.global.BaseServiceImpl;
import ${packageName}.modules.${moduleName}.dao.${ClassName}Dao;
import ${packageName}.modules.${moduleName}.entity.${ClassName};
import ${packageName}.modules.${moduleName}.entity.field.${ClassName}Field;
import ${packageName}.modules.${moduleName}.service.${ClassName}Service;

@Service
public class ${ClassName}ServiceImpl extends BaseServiceImpl<${ClassName}Dao, ${ClassName}, ${ClassName}Field> implements ${ClassName}Service {

}