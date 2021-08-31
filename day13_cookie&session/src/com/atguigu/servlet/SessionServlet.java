package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author Bert
 */
@WebServlet(name = "SessionServlet", value = "/sessionServlet")
public class SessionServlet extends BaseServlet {
    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // invalidate() 让Session会话马上无效
        request.getSession().invalidate();
        response.getWriter().write("当前会话Session已经失效");
    }
    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int maxInactiveInterval = session.getMaxInactiveInterval();

        response.getWriter().write("Session默认的超时时长为： " + maxInactiveInterval + " 秒！");

    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("key","keyData");
        response.getWriter().write("已经往Session中保存了数据");
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object attribute = request.getSession().getAttribute("key");
        response.getWriter().write("从Session中获取前面保存的数据：" + attribute);
    }
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建或获取
        HttpSession session = request.getSession();
        // 获取Session是否是新创建出来的状态  ，true表示新创建的，false表示前面创建好，获取的
        boolean isNew = session.isNew();
        // 获取会话的唯一标识
        String sessionId = session.getId();

        response.getWriter().write("创建或获取Session对象 <br/>");
        response.getWriter().write("isNew ==>> " + isNew + " <br/>");
        response.getWriter().write("session id ==>> " + sessionId + " <br/>");

    }
}
