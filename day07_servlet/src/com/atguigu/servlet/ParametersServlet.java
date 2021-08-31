package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 写一个servlet接收index.html表单
 * Author Bert
 */
@WebServlet(name = "ParametersServlet",urlPatterns = "/parametersServlet")
public class ParametersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //post需要设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //只能获取一个参数
        // String hobby = request.getParameter("hobby");
        //获取多个参数
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(username);
        System.out.println(password);
        //System.out.println(hobby);
        System.out.println(Arrays.asList(hobbies));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}
