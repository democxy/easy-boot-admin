package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.LoginRequired;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.ResponeData;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.field.MenuField;
import com.democxy.modules.sys.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/menu")
public class MenuController extends BaseController<MenuService, Menu, MenuField> {

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @LoginRequired
    public ResponeData<List> findList(MenuField menuField){
        //调用业务逻辑，处理业务
        List<Menu> list = service.findList(menuField);
        return new ResponeData<List>(ResultEnum.SUCCESS,list);
    }
}
