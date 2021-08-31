package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Author Bert
 */
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //向下转型
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        Object user = httpServletRequest.getSession().getAttribute("user");
        if(user==null){
        request.getRequestDispatcher("/login.jsp").forward(request,response);
        return;
        }else {
            //放行-》让程序去执行用户访问的资源
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
