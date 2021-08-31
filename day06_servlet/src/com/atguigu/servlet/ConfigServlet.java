package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Author Bert
 */
public class ConfigServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.获取Servlet的别名
        System.out.println(config.getServletName());
        //2.获取Servlet程序初始化参数
        System.out.println(config.getInitParameter("username"));
        System.out.println(config.getInitParameter("url"));
        //3.获取ServletContext的对象实例
        System.out.println(config.getServletContext());
    }
}
