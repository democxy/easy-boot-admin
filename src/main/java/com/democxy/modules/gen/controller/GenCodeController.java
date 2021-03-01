package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.Permission;
import com.democxy.common.config.ProjectConfig;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.entity.GenTable;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.service.GenTableColumnService;
import com.democxy.modules.gen.service.GenTableService;
import com.democxy.modules.gen.service.TemplateInfoService;
import com.democxy.modules.gen.utils.GenCodeUtil;
import com.democxy.modules.gen.vo.PreViewCode;
import com.google.common.collect.Lists;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiling_deng
 * @version 2021/02/03
 */
@Controller
@RequestMapping("gen/code")
public class GenCodeController {

    @Autowired
    FreeMarkerConfig freeMarkerConfig;
    @Autowired
    TemplateInfoService templateInfoService;
    @Autowired
    ProjectConfig projectConfig;
    @Autowired
    GenCodeUtil genCodeUtil;
    @Autowired
    GenTableService genTableService;
    @Autowired
    GenTableColumnService genTableColumnService;

    @GetMapping("test")
    public String gen(){
        /**/
        String temStr = templateInfoService.getById("830C7ABB2647410188C6682BE273E2C9").getContent();
        try {
            StringWriter result = new StringWriter();
            Template template = new Template("template", new StringReader(temStr),
                    new Configuration(Configuration.VERSION_2_3_23));
            Map<String,Object> map = new HashMap<>();
            map.put("packageName","com.democxy.test");
            map.put("moduleName","gen");
            map.put("ClassName","TemplateInfo");
            String string = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
//            FileUtils.writeStringToFile(new File("F://gencode/test.java"),string,"UTF-8");
            System.out.println("st0:   " + string);
            Configuration configuration = freeMarkerConfig.getConfiguration();
            configuration.setDirectoryForTemplateLoading(new File(projectConfig.getBasepath()));
            Template template1 = configuration.getTemplate("test.ftl", "utf-8");
            String string1 = FreeMarkerTemplateUtils.processTemplateIntoString(template1, map);
            System.out.println("st1:  " + string1);
            FileUtils.writeStringToFile(new File("F://gencode/test2.java"),string1,"UTF-8");



            return string;
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @GetMapping("test2")
    public String gen2(){
        /**/
            Map<String,Object> map = new HashMap<>();
            map.put("packageName","com.democxy.test");
            map.put("moduleName","gen");
            map.put("ClassName","TemplateInfo");

            return genCodeUtil.genCode("codetemp/entity.ftl",map,"F://gencode/entity.java");
    }

    @GetMapping(value = "previewCode")
    private ModelAndView preCode(String id) {
        GenTable genTable = genTableService.getById(id);
        ModelAndView modelAndView = new ModelAndView("gen/" + "genTablePreview");
        GenTableColumnField genTableColumnField = new GenTableColumnField();
        genTableColumnField.setGenTableId(id);
        List<GenTableColumn> list = genTableColumnService.findList(genTableColumnField);
        genTable.setColumnList(list);
        // 引用列表
        List<String> importList = Lists.newArrayList();
        for (GenTableColumn genTableColumn : list) {
            // 导入类型依赖包， 如果类型中包含“.”，则需要导入引用。
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
        map.put("columnList", list);
        map.put("table", genTable);
        map.put("importList", importList);
        List<PreViewCode> preViewCodes = new ArrayList<>();
        preViewCodes.add(new PreViewCode(genTable.getClassName()+".java",genCodeUtil.preViewCode("codetemp/entity.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"Filed.java",genCodeUtil.preViewCode("codetemp/filed.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"Service.java",genCodeUtil.preViewCode("codetemp/service.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"ServiceImp.java",genCodeUtil.preViewCode("codetemp/serviceImp.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"Dao.java",genCodeUtil.preViewCode("codetemp/dao.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"Controller.java",genCodeUtil.preViewCode("codetemp/controller.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"Mapper.xml",genCodeUtil.preViewCode("codetemp/mapper.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"ViewList.html",genCodeUtil.preViewCode("codetemp/viewList.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"ViewForm.html",genCodeUtil.preViewCode("codetemp/viewForm.ftl", map)));
        preViewCodes.add(new PreViewCode(genTable.getClassName()+"MenuSql.sql",genCodeUtil.preViewCode("codetemp/menuSql.ftl", map)));
        modelAndView.addObject("preViewCodes",preViewCodes);
        return modelAndView;
    }
}
