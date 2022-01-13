package com.javacode.springboot_program.config;

import com.javacode.springboot_program.interceptor.CrossInterceptor;
import com.javacode.springboot_program.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author shkstart
 * @create 2022-01-09 14:51
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public CrossInterceptor crossInterceptor() {
        return new CrossInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*跨域拦截器配置,放在最上面*/
        registry.addInterceptor(crossInterceptor()).addPathPatterns("/**");
        //拦截全部
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/**")
                .excludePathPatterns("/api/v1/pri/user/register", "/api/v1/pri/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
