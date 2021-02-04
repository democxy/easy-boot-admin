package com.democxy.modules.gen.controller;

import com.democxy.common.config.ProjectConfig;
import com.democxy.modules.gen.service.TemplateInfoService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiling_deng
 * @version 2021/02/03
 */
@RestController
@RequestMapping("gen/code")
public class GenCodeController {

    @Autowired
    FreeMarkerConfig freeMarkerConfig;
    @Autowired
    TemplateInfoService templateInfoService;
    @Autowired
    ProjectConfig projectConfig;

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
}
