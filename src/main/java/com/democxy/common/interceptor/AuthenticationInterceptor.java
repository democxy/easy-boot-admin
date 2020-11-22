package com.democxy.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.democxy.common.annotation.LoginRequired;
import com.democxy.common.annotation.Permission;
import com.democxy.common.exception.CustomException;
import com.democxy.common.utils.JwtUtil;
import com.democxy.common.utils.ServletUtils;
import com.democxy.modules.sys.entity.Account;
import com.democxy.modules.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;

/**
 * 授权验证拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    MenuService menuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //基于注解配置登录拦截
        if (handler instanceof  HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 接口是否有@LoginRequired注解, 有则需要判断是否登录
            boolean annotationPresent = method.isAnnotationPresent(LoginRequired.class);
            if (annotationPresent) {
                // 验证token
                String token = request.getHeader("token");
                boolean verity = JwtUtil.validateToken(token);
                if (!verity) {
                    throw new CustomException(4040, "token过期，请重新登录");
                }
                // token不过期的情况下，判断session是否过期，session过期重新设置
                Object perms = ServletUtils.getSession().getAttribute("perms");
                if (Objects.isNull(perms)){
                    String subject = JwtUtil.parseToken(token).getSubject();
                    Account account = JSON.parseObject(subject, Account.class);
                    Set<String> permsForRole = menuService.getPermsForRole(Integer.parseInt(account.getRole()));
                    ServletUtils.getSession().setAttribute("perms",permsForRole);
                }
//                return true;
            }
            // 验证是否有操作权限
//            boolean permisson = method.isAnnotationPresent(Permission.class);
//            if (permisson){
//                // 存在注解
//                Permission annotation = method.getAnnotation(Permission.class);
//                String value = annotation.value();
//                System.out.println("权限注解值：" + value);
//                Object perms = ServletUtils.getSession().getAttribute("perms");
//                if (perms!=null && perms instanceof Set){
//                    Set<String> permsSet = (Set<String>) perms;
//                    if (!permsSet.contains(value)){
//                        throw new CustomException(4041, "您无权限操作此项！");
//                    }
//                }
//            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
