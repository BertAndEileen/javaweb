package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author Bert
 */
@WebServlet(name = "Servlet1",value = "/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("servlet1中的参数值是"+username);
        System.out.println("处理servlet1中的业务");
        request.setAttribute("key","柜台1");
        RequestDispatcher requestDispatcher =
                request.getRequestDispatcher("/servlet2");
        requestDispatcher.forward(request,response);
    }
}
