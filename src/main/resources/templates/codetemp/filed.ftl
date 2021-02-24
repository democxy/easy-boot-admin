package ${packageName}.modules.${moduleName}.entity.field;

<#list importList as i>
import ${i};
</#list>

import lombok.Data;

import ${packageName}.common.global.BaseFiled;

@Data
public class ${ClassName}Filed extends BaseFiled<${ClassName}Field> {

<#list columnList as c>
    // ${c.comments}
    private ${c.javaType} ${c.javaField};
</#list>

}