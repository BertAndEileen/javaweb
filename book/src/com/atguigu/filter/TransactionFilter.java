package com.atguigu.filter;

import com.atguigu.util.JdbcUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * value = "/*" 表示拦截http://ip:port/工程路径/所有请求
 */
@WebFilter(value = "/*")
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            chain.doFilter(request,response);// 间接给所有 XxxService.xxx()方法都加上try..catch
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();// 不要吃掉错误,一定要抛给Tomcat服务器
            JdbcUtils.rollbackAndClose();
            throw  new RuntimeException(e);/// ==>>>把异常抛给Tomcat
        }


    }

    @Override
    public void destroy() {

    }
}
