package com.atguigu.servlet;



import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取Session中的验证码
        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        String code = request.getParameter("code");
        String username = request.getParameter("username");
        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println("保存【" + username + "】到数据库！！！");
//        request.getRequestDispatcher("/ok.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/ok.jsp");
        } else {
            System.out.println("请不要重复提交表单！！！");
        }

    }
}
