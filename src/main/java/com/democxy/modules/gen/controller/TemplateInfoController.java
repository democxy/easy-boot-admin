package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.entity.TemplateInfo;
import com.democxy.modules.gen.entity.field.TemplateInfoField;
import com.democxy.modules.gen.service.TemplateInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
@RequestMapping("gen/templateInfo")
public class TemplateInfoController extends BaseController<TemplateInfoService, TemplateInfo, TemplateInfoField> {
	
	private final String PREFIX = "gen/";

    @RequestMapping("")
    @Permission(value = "gen:templateInfo:view")
    private ModelAndView templateInfo(){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"templateInfoList");
        return modelAndView;
    }

    @RequestMapping("form")
    @Permission(value = "gen:templateInfo:add")
    public ModelAndView courseTypeForm(String id){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"templateInfoForm");
        if (StringUtils.isEmpty(id)){
            modelAndView.addObject("templateInfo",new TemplateInfo());
        }else {
            modelAndView.addObject("templateInfo",service.getById(id));
        }
        return modelAndView;
    }
}