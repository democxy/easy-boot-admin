package com.democxy.common.interceptor;

import com.democxy.common.annotation.PassLogin;
import com.democxy.common.exception.CustomException;
import com.democxy.common.utils.JwtUtil;
import com.democxy.common.utils.ServletUtils;
import com.democxy.common.utils.StringUtils;
import com.democxy.common.utils.redis.RedisUtil;
import com.democxy.modules.sys.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 授权验证拦截器
 *
 * @author shiling_deng
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    MenuService menuService;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //基于注解配置登录拦截
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            // 接口是否有@PassLogin注解, 没有则需要判断是否登录
            log.info("accept request={}", request.getRequestURI());
            boolean annotationPresent = method.isAnnotationPresent(PassLogin.class);
            if (!annotationPresent) {
                // 验证是否登录
                String token = request.getHeader("token");
                if (StringUtils.isNotEmpty(token)) {
                    // 手机登录
                    boolean verity = JwtUtil.validateToken(token);
                    if (!verity) {
                        // 从redis中获取过期token 刷新token
                        Object o = redisUtil.get(JwtUtil.REDIS_KEY_PREFIX + token);
                        if (o != null) {
                            // 返回auto代表可以自动刷新
                            throw new CustomException(4040, "auto");
                        }
                        throw new CustomException(4040, "token过期，请重新登录");
                    }
                } else {
                    // 后台管理端登录，判断session是否过期，session过期重新设置
                    Object perms = ServletUtils.getSession().getAttribute("login");
                    if (Objects.isNull(perms)) {
                        //如果不是ajax请求，则直接重定向
                        String type = request.getHeader("X-Requested-With") == null ? "" : request.getHeader("X-Requested-With");
                        if ("XMLHttpRequest".equals(type)) {
                            //告诉ajax这是重定向
                            response.setHeader("REDIRECT", "REDIRECT");
                            //重定向地址
                            response.setHeader("CONTEXTPATH", request.getContextPath() + "/admin/sys/login");
                            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                            return false;
                        } else {
                            response.sendRedirect(request.getContextPath() + "/admin/sys/login");
                            return false;
                        }

                    }
                }
            }
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
