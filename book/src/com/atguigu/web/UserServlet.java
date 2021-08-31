package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.WebUtils;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UserServlet",value = "/userServlet")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 定义一个regist方法用于处理注册业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 取出Session中的验证码
        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        //        1 获取表单信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        // 请求参数的格式是: name=value&name=value
        // 把所有请求的参数封装为map返回
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user = WebUtils.copyParamToBean(new User(),request.getParameterMap());

        // 假设验证码必须是:abcde.
        //        2 检查验证码是否正确
        if ( token != null && token.equalsIgnoreCase(code)) {
//        3 检查用户名是否可用
            if (userService.existsUsername(username)) {

                request.setAttribute("msg", "用户名已存在!");
                request.setAttribute("username", username);
                request.setAttribute("email", email);


                //        用户名不可用
                System.out.println("用户名[" + username + "]已存在!");
                //        跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

            } else {
                //        用户名可用
                //        保存用户信息
                userService.registUser(new User(null,username,password,email));
                //                跳到注册成功页面
                //        regist_success.jsp
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "验证码错误!");
            request.setAttribute("username", username);
            request.setAttribute("email", email);

//                验证码错误
            System.out.println("验证码 [" + code + "] 错误!");
//        跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 销毁Session( Session中保存的数据也一起被销毁.也就是用户登录的信息 )
        request.getSession().invalidate(); // 马上销毁
        //2 重定向到登录页面  或  网站首页
        response.sendRedirect(request.getContextPath());
    }

    /**
     * 定义一个login方法处理登录的业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 调用userServcie.login():User检查用户登录
        User loginUser = userService.login(new User(null, username, password, null));
        // 根据login的返回结果判定用户是否登录成功
        if (loginUser == null) {
            System.out.println(username + " , 用户登录失败");

            // 保存错误信息,和表单项信息,到reqeust域中,给jsp页面回显使用
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);

            // 登录失败
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else {
            // 登录成功
            System.out.println(username + " , 用户登录成功");
            // 保存用户登录成功的信息到Session中
            request.getSession().setAttribute("user", loginUser);

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }


}
