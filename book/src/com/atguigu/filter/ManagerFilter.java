package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @WebFilter 表示配置Filter过滤器 <br>
 *     value 表示配置拦截路径 <br>
 */
@WebFilter(value={"/pages/manager/*","/manager/bookServlet"})
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 写上检查用户是否登录的代码
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 获取用户登录之后的信息
        Object user = httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
            // 跳转登录页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else {
            // 放行
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
