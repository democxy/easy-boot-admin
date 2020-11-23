package com.democxy.modules.route;

import com.democxy.common.global.TreeEntity;
import com.democxy.common.utils.StringUtils;
import com.democxy.common.utils.TreeUtils;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.Dict;
import com.democxy.modules.sys.entity.Menu;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.entity.field.MenuField;
import com.democxy.modules.sys.service.AccountService;
import com.democxy.modules.sys.service.DictService;
import com.democxy.modules.sys.service.MenuService;
import com.democxy.modules.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("login")
    public String login(){
        System.out.println("login");
        return PREFIX+"login";
    }

    /**
     * 跳转到系统账户列表界面
     * @return
     */
    @RequestMapping("account")
    public String account(){
        return PREFIX+"account";
    }

    @RequestMapping("accountForm")
    public String accountForm(String id, Model model){
        if (StringUtils.isEmpty(id)){
            model.addAttribute("account",new Account());
        }else {
            model.addAttribute("account",accountService.getById(id));
        }
        return PREFIX+"accountForm";
    }

    @RequestMapping("dict")
    public String dict(){
        return PREFIX+"dict";
    }

    @RequestMapping("dictForm")
    public String dictForm(String id, Model model){
        if (StringUtils.isEmpty(id)){
            model.addAttribute("dict",new Dict());
        }else {
            Dict byId = dictService.getById(id);
            model.addAttribute("dict", byId);
        }
        return PREFIX+"dictForm";
    }

    /**
     * 跳转到系统账户列表界面
     * @return
     */
    @RequestMapping("role")
    public String roleList(){
        return PREFIX+"role";
    }

    @RequestMapping("roleForm")
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
    public String menuList(){
        return PREFIX+"menu";
    }

    @RequestMapping("menuForm")
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
}
