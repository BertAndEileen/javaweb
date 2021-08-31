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
@WebServlet(name = "Response1",value = "/response1")
public class Response1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("来过");
        //需要设置响应状态码302，和响应头location的值
        response.setStatus(302);
        //设置响应头
        response.setHeader("location","http://localhost:8080/day07_servlet/response2");
    }
}
