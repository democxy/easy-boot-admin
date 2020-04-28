package com.democxy.common.exception;

import com.democxy.common.global.ResponeData;
import com.democxy.common.global.ResultCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 暂时主要是为了处理404请求
 * @author shiling
 * @version 2020-04-28
 */
@RestController
public class NotFoundException implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public ResponeData error(HttpServletRequest request, HttpServletResponse response){
        return new ResponeData(ResultCode.NOT_FOUND,"链接不存在");
    }
}
