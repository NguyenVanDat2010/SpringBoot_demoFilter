package com.example.filter.utils.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
//TransactionFilter – to start and commit transactions
public class TransactionFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Initializing filter : {}", this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        logger.info("--TransactionFilter.doFilter Start transaction for req: {}", req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("--TransactionFilter.doFilter Commit transaction for req: {}", req.getRequestURI());
    }


    @Override
    public void destroy() {
        logger.warn("Destructing filter: {}", this);
    }
}
