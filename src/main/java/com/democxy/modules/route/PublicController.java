package com.democxy.modules.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class PublicController {

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
        return "page/welcome-1";
    }

    @RequestMapping("/page/{name}.html")
    public String toPage(@PathVariable("name") String name){
        return "page/"+name;
    }
}
