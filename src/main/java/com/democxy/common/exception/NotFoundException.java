package com.democxy.common.exception;

import com.democxy.common.global.ResponeData;
import com.democxy.common.enums.ResultEnum;
import com.democxy.common.utils.StringUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 暂时主要是为了处理404请求
 * @author shiling
 * @version 2020-04-28
 */
@Controller
public class NotFoundException implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public String error(HttpServletRequest request, HttpServletResponse response){
        // 伪代码 未测试
        String token = request.getHeader("token");
        if (StringUtils.isNotEmpty(token)) {
            return "redirect: /mobileError";
        }
        return "page/404";
    }

    @RequestMapping(value = "/mobileError")
    @ResponseBody
    public ResponeData mobileError(HttpServletRequest request, HttpServletResponse response){
        return new ResponeData(ResultEnum.NOT_FOUND,"链接不存在");
    }
}
