package com.example.filter.utils.filter;

import com.example.filter.model.User;
import org.apache.logging.log4j.core.config.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
@Order(2)
//RequestResponseLoggingFilter – to log requests and responses
public class RequestResponseLoggingFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Initializing filter: {}", this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        servletRequest.setAttribute("user",new User());

        logger.info("RequestResponseLoggingFilter.doFilter Logging request: {}"+ req.getMethod(), req.getRequestURI());
        //sử dụng hàm doFilter() của FilterChain để gọi hàm doFilter() của Filter tiếp theo trong chuỗi Filter,
        // cho đến đến khi chạm tới endpoint (servlet, JSP, static file, …), thì endpoint sẽ được thực thi.
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("RequestResponseLoggingFilter.doFilter Logging response: {}", res.getContentType());
    }

    @Override
    public void destroy() {
        logger.warn("Destructing filter: {}", this);
    }
}
