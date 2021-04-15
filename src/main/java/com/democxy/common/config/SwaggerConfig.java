package com.democxy.common.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Slf4j
@Configuration
@EnableSwagger2
@ConditionalOnClass(Contact.class)
public class SwaggerConfig {

    @Bean
    public Docket docker(){
        log.info("Read document configuration information");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("")
                .enable(true)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.democxy"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "EASYBOOT-ADMIN",
                "springboot简易开发平台" ,
                "V1.0.0",
                "https://gitee.com/shuangerduo",new Contact("shiling_deng", "", ""),
                "",
                "https://gitee.com/shuangerduo",
                new ArrayList<>()
        );
    }
}