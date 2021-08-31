package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet",value = "/orderServlet")
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 结账
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 获取Session中保存的用户信息
        User user = (User) request.getSession().getAttribute("user");
        // 用户还没登录
        if (user == null) {
            // 注意 请求转发,或重定向执行后,后面一般不要再写任何代码
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else {
            // orderService.createOrder(cart,userId);
            String orderId = null;

            orderId = orderService.createOrder(cart,user.getId());

            // 保存到request域中
//            request.setAttribute("orderId", orderId);
            request.getSession().setAttribute("orderId", orderId);
            // 请求转发到 http://localhost:8080/book/pages/cart/checkout.jsp 页面
//            request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response);
            response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求的参数
        String orderId = request.getParameter("orderId");
        // 2 调用 orderService.sendOrder(orderId);
        orderService.sendOrder(orderId);
        // 3 考虑页面是否需要数据==保存域对象中
        String referer = request.getHeader("referer");
        // 4 考虑页面跳转
        response.sendRedirect(referer);
    }

    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数 orderId
        String orderId = request.getParameter("orderId");
        // 调用 OrderService.receiverOrder( orderId );
        orderService.reveiveOrder(orderId);
        // 3 考虑页面是否需要数据==保存域对象中
        String referer = request.getHeader("referer");
        // 4 考虑页面跳转
        response.sendRedirect(referer);
    }

    /**
     * 管理员,查询全部订单列表功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void allOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用orderService.queryAllOrders()查询全部订单
        List<Order> orders = orderService.queryAllOrders();
        // 保存到request域中.
        request.setAttribute("orders", orders);
        // 请求转发到 pages/manager/order_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    protected void myOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户的编号
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else {
            Integer id = user.getId();
            // 调用 orderService.queryMyOrders() 查询用户订单
            List<Order> orders = orderService.queryMyOrders(id);
            // 把数据保存到reqeust域中
            request.setAttribute("orders", orders);
            // 请求转发到 pages/order/order.jsp页面
            request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
        }
    }

    /**
     * 订单详情查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String orderId = request.getParameter("orderId");
        // 调用 orderService.orderDetails();
        List<OrderItem> orderItems = orderService.queryOrderDetails(orderId);
        // 保存数据到request域中
        request.setAttribute("orderItems", orderItems);
        // 请求转发到 pages/manager/orderDetails.jsp页面
        request.getRequestDispatcher("/pages/manager/order_details.jsp").forward(request,response);
    }



    /**
     * 订单详情查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void orderDetailsForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String orderId = request.getParameter("orderId");
        // 调用 orderService.orderDetails();
        List<OrderItem> orderItems = orderService.queryOrderDetails(orderId);
        // 保存数据到request域中
        request.setAttribute("orderItems", orderItems);
        // 请求转发到 pages/manager/orderDetails.jsp页面
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request,response);
    }




}
