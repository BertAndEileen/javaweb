package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author Bert
 */
@WebServlet(name = "ResponseIOServlet",value = "responseIO")
public class ResponseIOServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*//第一种方案，不推荐
        response.setCharacterEncoding("utf-8");
       response.setHeader("Content-type","text/html;charset=utf-8");*/
       //第二种
        //同时设置客户端和服务器端
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("hello,客户端");
    }
}
