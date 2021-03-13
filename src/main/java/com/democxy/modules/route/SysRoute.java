package com.democxy.modules.route;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.global.TreeEntity;
import com.democxy.common.utils.StringUtils;
import com.democxy.common.utils.TreeUtils;
import com.democxy.modules.sys.entity.*;
import com.democxy.modules.sys.entity.field.DictField;
import com.democxy.modules.sys.entity.field.MenuField;
import com.democxy.modules.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统模块路由控制类
 * @author shilingdeng
 * @version 2020-11-01
 */
@Controller
@RequestMapping("admin/sys")
public class SysRoute {

    private final String PREFIX = "sys/";

    @Autowired
    AccountService accountService;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @Autowired
    DictService dictService;
    @Autowired
    TaskJobService taskJobService;
    @Autowired
    SysLogService sysLogService;

    @RequestMapping("login")
    @PassLogin
    public String login(){
        System.out.println("login");
        return PREFIX+"login";
    }

    /**
     * 跳转到系统账户列表界面
     * @return
     */
    @RequestMapping("account")
    @PassLogin
    public String account(){
        return PREFIX+"account";
    }

    @RequestMapping("accountForm")
    @PassLogin
    public String accountForm(String id, Model model){
        if (StringUtils.isEmpty(id)){
            model.addAttribute("account",new Account());
        }else {
            model.addAttribute("account",accountService.getById(id));
        }
        return PREFIX+"accountForm";
    }

    @RequestMapping("dict")
    @PassLogin
    public String dict(){
        return PREFIX+"dict";
    }

    @RequestMapping("dictForm")
    @PassLogin
    public String dictForm( DictField dictField, Model model){
        if (StringUtils.isEmpty(dictField.getType())){
            model.addAttribute("dictList",new ArrayList<Dict>());
            model.addAttribute("type","");
            model.addAttribute("description","");
        }else {
            List<Dict> dictList = dictService.findList(dictField);
            model.addAttribute("dictList", dictList);
            Dict dict = dictList.get(0);
            model.addAttribute("type",dict.getType());
            model.addAttribute("description",dict.getDescription());
        }
        return PREFIX+"dictForm";
    }

    @RequestMapping("taskJob")
    @PassLogin
    public String taskJob(){
        return PREFIX+"taskJob";
    }

    @RequestMapping("taskJobForm")
    @PassLogin
    public String taskJobForm( String id, Model model){
        if (StringUtils.isEmpty(id)){
            model.addAttribute("taskJob",new TaskJob());
        }else {
            model.addAttribute("taskJob",taskJobService.getById(id));
        }
        return PREFIX+"taskJobForm";
    }

    /**
     * 跳转到系统账户列表界面
     * @return
     */
    @RequestMapping("role")
    @PassLogin
    public String roleList(){
        return PREFIX+"role";
    }

    @RequestMapping("roleForm")
    @PassLogin
    public String roleForm(String id, Model model){
        if (StringUtils.isEmpty(id)){
            model.addAttribute("role",new Role());
            List<Menu> list = menuService.findList(new MenuField());
            List<TreeEntity> treeDatas = new TreeEntity().sortMenuList(TreeUtils.getChildPerms(list, "0"));
            model.addAttribute("treeDatas",treeDatas);
        }else {
            Role byId = roleService.getById(id);
            model.addAttribute("role", byId);
            List<Menu> list = menuService.findList(new MenuField());
            List<TreeEntity> treeDatas = new TreeEntity().sortMenuList(TreeUtils.getChildPerms(list, "0"),byId.getMenuIds());
            model.addAttribute("treeDatas",treeDatas);
        }

        return PREFIX+"roleForm";
    }

    @RequestMapping("menu")
    @PassLogin
    public String menuList(){
        return PREFIX+"menu";
    }

    @RequestMapping("menuForm")
    @PassLogin
    public String menuForm(String id, Model model){
        if (StringUtils.isEmpty(id)){
            Menu menu = new Menu();
            menu.setParentId("0");
            model.addAttribute("menu",menu);
        }else {
            model.addAttribute("menu",menuService.getById(id));
        }
        List<Menu> list = menuService.findList(new MenuField());
        List<TreeEntity> treeDatas = new TreeEntity().sortMenuList(TreeUtils.getChildPerms(list, "0"));
        model.addAttribute("treeDatas",treeDatas);
        return PREFIX+"menuForm";
    }

    @RequestMapping("addChildren")
    @PassLogin
    public String addChildren(String id, Model model){
        Menu byId = menuService.getById(id);
        Menu menu = new Menu();
        menu.setParentId(byId.getId());
        menu.setParentName(byId.getMenuName());
        model.addAttribute("menu",menu);
        List<Menu> list = menuService.findList(new MenuField());
        List<TreeEntity> treeDatas = new TreeEntity().sortMenuList(TreeUtils.getChildPerms(list, "0"));
        model.addAttribute("treeDatas",treeDatas);
        return PREFIX+"menuForm";
    }


    @RequestMapping("sysLog")
    @PassLogin
    public String sysLogList(){
        return PREFIX+"sysLog";
    }

    @RequestMapping("sysLogForm")
    @PassLogin
    public String sysLogForm(String id,Model model){
        SysLog sysLog = sysLogService.getById(id);
        model.addAttribute("sysLog",sysLog);
        return PREFIX+"sysLogForm";
    }

}
