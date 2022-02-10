package com.example.config;

import com.example.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class AdminConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  /**默认拦截所有请求(包括静态资源),addPathPatterns表示拦截的路径
        //  但 / 和 /login 是用户可以访问的，所有要将这两个路径放行，不进行拦截
        //  这里使用 excludePathPatterns("")
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
        //我们要把这些静态资源也要放行
    }
}
