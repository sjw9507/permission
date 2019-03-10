package com.sjw.permission.common.config;

import com.sjw.permission.common.interceptor.AclControlInterceptor;
import com.sjw.permission.common.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置
 *springboot
 * @author sjw
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/src/main/webapp/**").addResourceLocations("classpath:/webapp/");
    }

    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/sys/**","/admin/**");
        registry.addInterceptor(new AclControlInterceptor()).addPathPatterns("/sys/**","/admin/**").excludePathPatterns("/sys/user/noAuth.page","/login.page");
    }
}