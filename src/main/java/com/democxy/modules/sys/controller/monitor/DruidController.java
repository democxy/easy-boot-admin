package com.democxy.modules.sys.controller.monitor;

import com.democxy.common.annotation.PassLogin;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * druid 监控
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/data")
public class DruidController {
    private String prefix = "/druid";

    @GetMapping()
    public String index()
    {
        return"redirect:"+prefix + "/index";
    }
}