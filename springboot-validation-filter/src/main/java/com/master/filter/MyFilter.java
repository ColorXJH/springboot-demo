package com.master.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/7/11 16:42
 */
@WebFilter(filterName = "myFiler",urlPatterns = "/*")
public class MyFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String url=request.getRequestURI();
        if(url.contains("my")){
            System.out.println("处理该请求：哈哈哈哈");
        }
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destory the filter...");
    }
}
