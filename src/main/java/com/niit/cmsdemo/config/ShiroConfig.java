package com.niit.cmsdemo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.niit.cmsdemo.service.PermissionService;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Autowired(required = false)
    private PermissionService permissionService;

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * ShiroDialect,为了在thymeleaf里使用shiro的标签bean
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return  new ShiroDialect();
    }
    /**
     * ShiroFiterFactoryBean处理拦截资源文件问题
     */
}
