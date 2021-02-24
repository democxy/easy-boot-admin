package ${packageName}.modules.${moduleName}.entity;

import lombok.Data;
<#list importList as i>
import ${i};
</#list>

@Data
public class ${ClassName} {

<#list columnList as c>
    // ${c.comments}
    private ${c.javaType} ${c.javaField};
</#list>

}