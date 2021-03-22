package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.config.ProjectConfig;
import com.democxy.modules.gen.service.GenTableColumnService;
import com.democxy.modules.gen.service.GenTableService;
import com.democxy.modules.gen.utils.GenCodeUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    ProjectConfig projectConfig;
    @Autowired
    GenCodeUtil genCodeUtil;
    @Autowired
    GenTableService genTableService;
    @Autowired
    GenTableColumnService genTableColumnService;

    @GetMapping("test")
    public String gen(){
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
    @PassLogin
    private ModelAndView preCode(String id) {
        ModelAndView modelAndView = new ModelAndView("gen/" + "genTablePreview");
        modelAndView.addObject("preViewCodes",genTableService.preViewCode(id));
        return modelAndView;
    }
}
