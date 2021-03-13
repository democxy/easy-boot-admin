package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.annotation.Permission;
import com.democxy.common.global.BaseController;
import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.entity.Notice;
import com.democxy.modules.sys.entity.field.NoticeField;
import com.democxy.modules.sys.service.NoticeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
@RequestMapping("sys/notice")
public class NoticeController extends BaseController<NoticeService, Notice, NoticeField> {

    private final String PREFIX = "sys/";

    @RequestMapping("")
    @Permission(value = "sys:notice:view")
    @PassLogin
    private ModelAndView notice(){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"noticeList");
        return modelAndView;
    }

    @RequestMapping("form")
    @Permission(value = "sys:notice:add")
    @PassLogin
    public ModelAndView courseTypeForm(String id){
        ModelAndView modelAndView = new ModelAndView(PREFIX+"noticeForm");
        if (StringUtils.isEmpty(id)){
            modelAndView.addObject("notice",new Notice());
        }else {
            modelAndView.addObject("notice",service.getById(id));
        }
        return modelAndView;
    }
}