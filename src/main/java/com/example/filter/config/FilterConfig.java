package com.example.filter.config;

import com.example.filter.utils.filter.RequestResponseLoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig{
    // uncomment this and comment the @Component in the filter class definition to register only for a url pattern
    // Nếu dùng @Bean đăng ký ở đây thì chỉ khi đúng patent là /users thì mới cho vượt qua sử dụng bộ lọc RequestResponseLoggingFilter đã định nghĩa
     @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter (){
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.addUrlPatterns("/users/*");
        return registrationBean;
    }
}
