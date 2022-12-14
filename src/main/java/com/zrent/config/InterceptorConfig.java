package com.zrent.config;

import com.zrent.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:登陆拦截器
 * @author:Zrent
 * @date : 2022/10/18
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new JWTInterceptor());
        registration.addPathPatterns("/admin/**");                      //所有/admin/路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                "你的登陆路径",            //登录
                "/admin/**/*.html",            //html静态资源
                "/admin/**/*.js",              //js静态资源
                "/admin/**/*.css",             //css静态资源
                "/admin/**/*.woff",
                "/admin/**/*.ttf",
                "/admin/**/*.jpg",
                "/admin/**/*.png",
                "/admin/**/verify",
                "/admin/**/login",
                "/admin/**/userLogin"
        );
    }
}