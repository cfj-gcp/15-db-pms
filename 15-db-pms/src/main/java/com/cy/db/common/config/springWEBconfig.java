package com.cy.db.common.config;

import com.cy.db.common.web.TimeAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.imageio.spi.RegisterableService;

@Configuration
public class springWEBconfig  implements WebMvcConfigurer {
//    配置spring mvc 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeAccessInterceptor())
        .addPathPatterns("/doLogin");
    }
}
