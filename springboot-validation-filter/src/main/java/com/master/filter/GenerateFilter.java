package com.master.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 16:53
 */
//这是传统的过滤器，可以设置过滤器的顺序，@WebFilter不能设置过滤器顺序
public class GenerateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("GenerateFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do GenerateFilter...");
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        if(request.getRequestURI().contains("saveUser")){
            System.out.println("执行该filter:servletRequest-------");
        }
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destory GenerateFilter...");
    }
}
