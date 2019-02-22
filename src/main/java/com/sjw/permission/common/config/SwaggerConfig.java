package com.sjw.permission.common.config;

import com.fasterxml.classmate.TypeResolver;
import com.sjw.permission.common.constant.ControllerUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;


/**
 * @author sjw
 * @date 2019/1/22
 * ref: https://springfox.github.io/springfox/docs/current/#introduction
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket api1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sjw.permission.modules.sys.controller"))
                .paths(PathSelectors.ant("/**"))
                .paths(PathSelectors.any())
                .build()

                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "demo for spring boot",
                "",
                "API TOS",
                "Terms of service",
                new Contact("sjw", "", ""),
                "License of API", "API license URL", Collections.emptyList());
    }
}