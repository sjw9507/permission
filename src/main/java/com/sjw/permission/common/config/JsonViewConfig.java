package com.sjw.permission.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author sjw
 */

@Configuration
public class JsonViewConfig {

    @Bean
    public BeanNameViewResolver beanNameViewResolver(){
        return new BeanNameViewResolver();
    }

    @Bean(name = "jsonView")
    public MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }
}
