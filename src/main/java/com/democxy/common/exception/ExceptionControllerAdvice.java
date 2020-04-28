package com.democxy.common.exception;

import com.democxy.common.global.ResponeData;
import com.democxy.common.global.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类 加上@ControllerAdvice注解或者@RestControllerAdvice,
 * 加@RestControllerAdvice只能全局处理RestFul接口异常
 * @author shiling
 * @version 2020-04-28
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    /**
     * 表单验证异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponeData<String> BindExceptionHandler(BindException e) {
        ObjectError objectError = e.getAllErrors().get(0);
        // 注意哦，这里传递的响应码枚举
        logger.error("表单数据校验异常",e);
        return new ResponeData<String>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResponeData<String> CustomExceptionHandler(CustomException e) {
        logger.error("自定义异常",e);
        // 注意哦，这里传递的响应码枚举
        return new ResponeData<String>(ResultCode.FAILED, e.getMsg());
    }

    /**
     * Exception异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponeData<String> ExceptionHandler(Exception e) {
        //记录日志信息
        logger.error("服务异常",e);
        // 注意哦，这里传递的响应码枚举
        return new ResponeData<String>(ResultCode.FAILED, "服务异常！");
    }


}
