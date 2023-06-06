package com.example.sof3011_java5.infrastructure.bean;

import com.example.sof3011_java5.filter.AdminFilter;
import com.example.sof3011_java5.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<AdminFilter> sessionFilter() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/admin/*");
        return registrationBean;
    }

//    @Bean
//    public FilterRegistrationBean<UserFilter> userFilterFilterRegistrationBean() {
//        FilterRegistrationBean<UserFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new UserFilter());
//        registrationBean.addUrlPatterns("/user/*");
//        return registrationBean;
//    }

}

