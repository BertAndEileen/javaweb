package com.atguigu.servlet;

import com.atguigu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author Bert
 */
@WebServlet(name = "CookieServlet",value = "/cookieServlet")
public class CookieServlet extends BaseServlet {
    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookieA = new Cookie("cookieA", "aValue");
        cookieA.setPath(request.getContextPath()); // 设置为工程路径 ==>>> /13_cookie_session  也是默认值
        response.addCookie(cookieA);

        Cookie cookieB = new Cookie("cookieB", "bValue");
        cookieB.setPath(request.getContextPath() + "/abc"); // 设置为工程路径 ==>>> /13_cookie_session/abc
        response.addCookie(cookieB);

        response.getWriter().write("创建了两个Cookie用于对比");
    }
    // 创建可以存活3600秒的Cookie
    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);//存活1小时
        response.addCookie(cookie);
        response.getWriter().write("创建一个可以存活一小时的Cookie");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除bbb的Cookie
        Cookie bbb = CookieUtils.findCookie("bbb", req.getCookies());
        if (bbb != null) {
            bbb.setMaxAge(0); // 表示马上删除，不需要等浏览器关闭
            resp.addCookie(bbb);//通知客户端对cookie的操作
            resp.getWriter().write("已经删除了bbb的Cookie");
        }
    }
    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie cookie=new Cookie("defaultLife","defaultLife");
         cookie.setMaxAge(-1);
        response.addCookie(cookie);
        response.getWriter().write("创建了一个默认时长的cookie");
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        方案一:
//        1 直接在服务器端创建一个同名的cookie对象   === 修改aaa值为aaaNewValue
//        2 在创建的构造器方法中直接赋于新值
//        Cookie cookie = new Cookie("aaa","aaaNewValue");
//        3 调用 response.addCookie( cookie ); 通知客户端保存修改
//        response.addCookie(cookie);

//        方案二:
//        1 先查找到需要修改的Cookie对象
        Cookie iWantCookie = CookieUtils.findCookie("bbb", request.getCookies());
        if (iWantCookie != null) {
            //2 调用 setValue() 方法设置新的值
            iWantCookie.setValue("bbbNewValue");//如果Cookie值为中文，建议使用BASE64编码后再保存
//        3 调用 response.addCookie() 通知客户端保存悠
            response.addCookie(iWantCookie);
        }

        response.getWriter().write("已修改好aaa的Cookie的值");
    }

    /**
     * 获取客户端发送过来的Cookie
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 只需要调用一个api即可.
        Cookie[] cookies = request.getCookies();//:Cookie[]得到全部Cookie

        if (cookies != null && cookies.length > 0) {
            // 遍历Cookie输出
            for (Cookie cookie : cookies) {
                // cookie.getName() 获取Cookie的键或名称  值
                // cookie.getValue() 获取当前Cookie的值
                response.getWriter().write("Cookie[" + cookie.getName()
                        + " = " + cookie.getValue() + " ] <br/>");
            }
        }

//        比如我需要获取aaa的Cookie

        Cookie iWantCookie = null;

        iWantCookie = CookieUtils.findCookie("bbb", cookies);

        // 判断是否找到
        if (iWantCookie != null) {
            response.getWriter().write(" 亲爱的.我找到了你要的Cookie <br>");
        }
    }

    /**
     * 创建Cookie对象
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 在服务器端new Cookie( name, value ) ;
        Cookie cookie = new Cookie("bbb", "bbbValue");
        //2 调用 response.addCookie( cookie ); 通知客户端Cookie 保存( 或修改 )
        response.addCookie(cookie);

        Cookie cookie1 = new Cookie("ccc", "cccValue");
        response.addCookie(cookie1);

        response.getWriter().write("已经创建了Cookie返回!!!");
    }
}
