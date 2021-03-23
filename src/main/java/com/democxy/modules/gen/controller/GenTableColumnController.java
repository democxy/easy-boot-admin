package com.democxy.modules.gen.controller;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.gen.entity.GenTableColumn;
import com.democxy.modules.gen.entity.field.GenTableColumnField;
import com.democxy.modules.gen.service.GenTableColumnService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shiling_deng
 */
@CrossOrigin
@RestController
@RequestMapping("gen/genTableColumn")
public class GenTableColumnController extends BaseController<GenTableColumnService, GenTableColumn, GenTableColumnField> {
	
	private final String PREFIX = "gen/";

    @RequestMapping("")
    @Permission(value = "gen:genTableColumn:view")
    @PassLogin
    private ModelAndView genTableColumn(){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"genTableColumnList");
        return modelAndView;
    }

    @RequestMapping("form")
    @Permission(value = "gen:genTableColumn:add")
    @PassLogin
    public ModelAndView courseTypeForm(String id){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"genTableColumnForm");
        if (StringUtils.isEmpty(id)){
            modelAndView.addObject("genTableColumn",new GenTableColumn());
        }else {
            modelAndView.addObject("genTableColumn",service.getById(id));
        }
        return modelAndView;
    }
}