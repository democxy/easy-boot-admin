package com.democxy.modules.route;

import com.democxy.common.utils.StringUtils;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.entity.Role;
import com.democxy.modules.sys.service.AccountService;
import com.democxy.modules.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        }else {
            model.addAttribute("role",roleService.getById(id));
        }
        return PREFIX+"roleForm";
    }
}
