package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author Bert
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        //1.获取Context-param 上下文初始化参数
        System.out.println(context.getInitParameter("password"));
        System.out.println(context.getInitParameter("url"));
        //2.获取工程路径
        System.out.println(context.getContextPath());
        //3.可以获取工程部署到tomcat服务器上后在硬盘上的绝对路径
         /*
            getRealPath("") 是获取文件在服务器硬盘上真实的绝对路径.
            / 表示===>>> http://ip:port/工程路径/
            /index.html 表示===>>> http://ip:port/工程路径/index.html
            / 翻译过来是  linux  根 ROOT
            / 表示的地址为 : http://ip:port/工程路径/
            映射到IDEA代码中的web目录
        */
        System.out.println(context.getRealPath("/"));
        System.out.println(context.getRealPath("/css"));
    }
}
