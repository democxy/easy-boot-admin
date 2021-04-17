package com.democxy.common.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger配置类
 * @author shiling_deng
 * @version 2021/04/15
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 根据包名扫描接口，容易暴露不想公开的接口
                // .apis(RequestHandlerSelectors.basePackage("com.democxy"))
                // 根据注解扫描，建议使用这种方式，灵活性更高
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "EASYBOOT-ADMIN接口文档",
                "springboot简易开发平台" ,
                "V1.0.0",
                "https://gitee.com/shuangerduo",new Contact("shiling_deng", "", ""),
                "",
                "https://gitee.com/shuangerduo",
                new ArrayList<>()
        );
    }
}