package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
@WebServlet 注解表示当前类是一个Servlet程序 <br/>
value = "/hello4" 表示配置访问地址.
loadOnStartup = 2表示web工程启动就自动创建Servlet实例.
*/
@WebServlet("/hello4")
public class HelloServlet4 extends HttpServlet {

    public HelloServlet4() {
        System.out.println(" HelloServlet4 构造 器 ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet4 doGet 方法");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet4 doPost 方法");
    }
}
