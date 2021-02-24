package ${packageName}.modules.${moduleName}.controller;

import ${packageName}.common.annotation.Permission;
import ${packageName}.common.global.BaseController;
import ${packageName}.common.utils.StringUtils;
import ${packageName}.modules.${moduleName}.entity.${ClassName};
import ${packageName}.modules.${moduleName}.entity.field.${ClassName}Field;
import ${packageName}.modules.${moduleName}.service.${ClassName}Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
@RequestMapping("${moduleName}/${className}")
public class ${ClassName}Controller extends BaseController<${ClassName}Service, ${ClassName}, ${ClassName}Field> {

    private final String PREFIX = "${moduleName}/";

    @RequestMapping("")
    @Permission(value = "${moduleName}:${className}:view")
    private ModelAndView ${className}(){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"${className}List");
        return modelAndView;
    }

    @RequestMapping("form")
    @Permission(value = "${moduleName}:${className}:add")
    public ModelAndView courseTypeForm(String id){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"${className}Form");
        if (StringUtils.isEmpty(id)){
            modelAndView.addObject("${className}",new ${ClassName}());
        }else {
            modelAndView.addObject("${className}",service.getById(id));
        }
        return modelAndView;
    }
}