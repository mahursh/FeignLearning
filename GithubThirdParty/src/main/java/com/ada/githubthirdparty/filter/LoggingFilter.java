package com.ada.githubthirdparty.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class LoggingFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


            long startTime = System.currentTimeMillis();

            logger.info("Incoming request: {} {}?{}",
                    httpServletRequest.getMethod(),
                    httpServletRequest.getRequestURI(),
                    httpServletRequest.getQueryString() != null ? httpServletRequest.getQueryString() : "");


            filterChain.doFilter(servletRequest, servletResponse);



            long duration = System.currentTimeMillis() - startTime;
            logger.info("Outgoing response: status={} duration={}ms", httpServletResponse.getStatus(), duration);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


}
