package com.democxy.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.democxy.common.annotation.Permission;
import com.democxy.common.exception.CustomException;
import com.democxy.common.global.SystemCache;
import com.democxy.common.utils.ServletUtils;
import com.democxy.modules.sys.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Aspect
@Component
public class PermissionAspect {

    Logger logger = LoggerFactory.getLogger(SysLogAspect.class);


    /**
     * 切入点  这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.democxy.common.annotation.Permission)")
    public void permissionPoint(){
    }

    @Before("permissionPoint()")
    public void recordLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取方法上的指定注解
        Permission annotation = signature.getMethod().getAnnotation(Permission.class);
        // 获取注解中的参数
        String resourceId = getAnnotationValue(joinPoint, annotation.value());
        String annotationValue = getAnnotationValue(joinPoint, annotation.func());
        // 将注解中测参数值保存到数据库，实现记录接口调用日志的功能(以下内容省略...)
        String permission = resourceId+annotationValue;
        System.out.println("permission:" + permission);
        Object perms = ServletUtils.getSession().getAttribute("login");
        if (perms!=null && perms instanceof Account){
            Account account = (Account)perms;
            Set<String> permsSet = SystemCache.ROLE_MENU_CACHE.get(account.getRole());
            if (!permsSet.contains(permission)){
                logger.info("无权限操作！");
                throw new CustomException(4041, "您无操作权限！");
            }
        }
    }

    /**
     * 获取注解中传递的动态参数的参数值
     *
     * @param joinPoint
     * @param name
     * @return
     */
    public String getAnnotationValue(JoinPoint joinPoint, String name) {
        String paramName = name;
        // 获取方法中所有的参数
        Map<String, Object> params = getParams(joinPoint);
        // 参数是否是动态的:#{paramName}
        if (paramName.matches("^#\\{\\D*\\}")) {
            // 获取参数名
            paramName = paramName.replace("#{", "").replace("}", "");
            // 是否是复杂的参数类型:对象.参数名
            if (paramName.contains(".")) {
                String[] split = paramName.split("\\.");
                // 获取方法中对象的内容
                Object object = getValue(params, split[0]);
                // 转换为JsonObject
                JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(object));
                // 获取值
                Object o = jsonObject.get(split[1]);
                return String.valueOf(o);
            }
            // 简单的动态参数直接返回
            return String.valueOf(getValue(params, paramName));
        }
        // 非动态参数直接返回
        return name;
    }

    /**
     * 根据参数名返回对应的值
     *
     * @param map
     * @param paramName
     * @return
     */
    public Object getValue(Map<String, Object> map, String paramName) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().equals(paramName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * 获取方法的参数名和值
     *
     * @param joinPoint
     * @return
     */
    public Map<String, Object> getParams(JoinPoint joinPoint) {
        Map<String, Object> params = new HashMap<>(8);
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] names = signature.getParameterNames();
        for (int i = 0; i < args.length; i++) {
            params.put(names[i], args[i]);
        }
        return params;
    }

    }
