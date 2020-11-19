package com.democxy.common.config;

import com.democxy.common.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 定义bean，方便在拦截器AuthenticationInterceptor类中注入其他bean
    @Bean
    public AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthenticationInterceptor())
//                .addPathPatterns("/","/admin/**")
//                .excludePathPatterns("/admin/account/login","/admin/account/logout");

        //基于注解配置拦截，只需要注册拦截器，不在需要指定拦截方法
        registry.addInterceptor(authenticationInterceptor());
    }

}
