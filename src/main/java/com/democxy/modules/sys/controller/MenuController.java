package com.democxy.modules.sys.controller;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.annotation.Permission;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.global.BaseController;
import com.democxy.common.global.BasePageQuery;
import com.democxy.common.global.ResponeData;
import com.democxy.common.global.TreeEntity;
import com.democxy.common.utils.AccountUtils;
import com.democxy.common.utils.TreeUtils;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.UserMenuInfo;
import com.democxy.modules.sys.entity.field.MenuField;
import com.democxy.modules.sys.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin/menu")
public class MenuController extends BaseController<MenuService, Menu, MenuField> {

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @Override
    public ResponeData<List> findList(MenuField menuField){
        //调用业务逻辑，处理业务
        List<Menu> list = service.findList(menuField);
        return new ResponeData<List>(ResultEnum.SUCCESS,list);
    }

    @ResponseBody
    @RequestMapping(value = "tree",method = RequestMethod.GET)
    public List<Menu> treeMenu(){
        List<Menu> list = service.findList(new MenuField());
        return TreeUtils.getChildPerms(list,"0");
    }

    @ResponseBody
    @RequestMapping(value = "treeSelect",method = RequestMethod.GET)
    public List<TreeEntity> treeLayUi(){
        List<Menu> list = service.findList(new MenuField());
        return new TreeEntity().sortMenuList(TreeUtils.getChildPerms(list,"0"));
    }

    @ResponseBody
    @RequestMapping(value = "delByPid/{id}",method = RequestMethod.GET)
    @Override
    public ResponeData<String> delById(@PathVariable("id") String id){
        service.delMore(id);
        return new ResponeData<>(ResultEnum.SUCCESS,"删除成功");
    }

    /**
     * 初始化用户菜单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "initUserMenu",method = RequestMethod.GET)
    public ResponeData<Map<String,Object>> initUserMenu(){
        Account accountByToken = AccountUtils.getAccount();
        Map<String,Object> userMenu = new HashMap<>();
        Map<String,String> homeInfo = new HashMap<>();
        homeInfo.put("title","首页");
        homeInfo.put("href","/admin/main");
        userMenu.put("homeInfo",homeInfo);
        Map<String,String> logoInfo = new HashMap<>();
        logoInfo.put("title","EasyAdmin");
        logoInfo.put("image","/images/logo.png");
        logoInfo.put("href","");
        userMenu.put("logoInfo",logoInfo);

        List<Menu> list = service.findByRoleId(Integer.parseInt(accountByToken.getRole()));
        userMenu.put("menuInfo",new UserMenuInfo().sortMenuList(TreeUtils.getChildPerms(list,"0")));
        return  new ResponeData<>(ResultEnum.SUCCESS,userMenu);
    }

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @Permission(value = "sys:dict:add")
    @Override
    public ResponeData<String> save(@Valid @RequestBody MenuField f ){
        //调用业务逻辑，处理业务
        return super.save(f);
    }

    /**
     * 添加用户
     * @param f
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @Permission(value = "sys:dict:add")
    @Override
    public ResponeData<String> addUser(@Valid @RequestBody MenuField f ){
        return super.addUser(f);
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @Permission(value = "sys:dict:edit")
    @Override
    public ResponeData<String> update(@Valid @RequestBody MenuField f){
        return super.update(f);
    }

    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.POST)
    @Override
    public ResponeData<PageInfo> findPage(@RequestBody BasePageQuery<MenuField> basePageQuery){
        return super.findPage(basePageQuery);
    }

    @ResponseBody
    @RequestMapping(value = "get/{id}",method = RequestMethod.GET)
    @Permission(value = "sys:dict:view")
    @Override
    public ResponeData<Menu> getById(@PathVariable("id") String id){
        return super.getById(id);
    }
}
