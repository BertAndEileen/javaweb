package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author Bert
 */
@WebServlet(name="RequestServlet",urlPatterns = "/requestServlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.getRequestURI,获取请求资源路径
        System.out.println(req.getRequestURI());
        //2.getRequestURL,获取请求统一资源定位符，也就是绝对路径
        System.out.println(req.getRequestURL());
        //3.getRemoteHost(),获取客户端ip地址
        //如果使用Localhost访问得到的客户端ip地址是: 0:0:0:0:0:0:0:1 <br />
        //如果使用127.0.0.1访问，得到的是127.0.0.1
        //如果使用真实ip访问，就可以得到客户端的真实ip地址
        System.out.println(req.getRemoteHost());
        //4.getHeader(), 获取请求头
        System.out.println("Host");
        System.out.println("User-Agent");
        //5.getMethod(),获取请求的方式
        System.out.println(req.getMethod());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
