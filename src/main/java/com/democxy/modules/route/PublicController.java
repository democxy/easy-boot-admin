package com.democxy.modules.route;

import com.democxy.common.utils.ServletUtils;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/admin")
@Controller
public class PublicController {

    @Autowired
    MenuService menuService;

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "page/login-1";
    }


    @RequestMapping("/main")
    public String main(){
        Object login = ServletUtils.getSession().getAttribute("login");
        if (login!=null && login instanceof Account){
            Account account = (Account) login;
            Set<String> permsForRole = menuService.getPermsForRole(Integer.parseInt(account.getRole()));
            ServletUtils.getSession().setAttribute("perms",permsForRole);
        }

        return "page/welcome-1";
    }

    @RequestMapping("/page/{name}.html")
    public String toPage(@PathVariable("name") String name){
        return "page/"+name;
    }
}
