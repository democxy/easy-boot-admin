package ${packageName}.modules.${moduleName}.dao;

import ${packageName}.common.global.BaseDao;
import ${packageName}.modules.${moduleName}.entity.${ClassName};
import ${packageName}.modules.${moduleName}.entity.field.${ClassName}Field;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ${ClassName}Dao extends BaseDao<${ClassName}, ${ClassName}Field> {

}