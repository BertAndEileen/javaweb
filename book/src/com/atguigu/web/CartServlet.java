package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/cartServlet")
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取商品的编号
        Integer id = WebUtils.parseInt(request.getParameter("id"),0);
        //2 通过BookService.queryBookById(id):Book图书信息
        Book book = bookService.queryBookById(id);
        //3 把Book转换为CartItem
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //4 获取Cart购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //5 调用 cart.addItem( CartItem ) 添加商品项
        cart.addItem(cartItem);
        System.out.println(cart);
        // 保存到Session中,最后一个添加的商品
        request.getSession().setAttribute("last_name", cartItem.getName());

        //6 跳转回添加商品的页面
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 调用 cart.clear() 清空购物车
        if (cart != null) {
            // 清空购物车
            cart.clear();
            // 重定向回购物车页面
            response.sendRedirect(request.getHeader("referer"));
        }
    }


    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求的参数 图书编号
        Integer id = WebUtils.parseInt(request.getParameter("id"),0);
        //2 获取Cart购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        // 调用 cart.deleteItem(); 删除商品项
        if (cart != null) {
            cart.deleteItem(id );
            // 跳回原来购物车页面
            response.sendRedirect(request.getHeader("referer"));
        }
    }


    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数 商品编号和新数量
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(request.getParameter("count"),1);
        // 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 修改商品数量
            cart.updateCount(id,count) ;
            // 重定向回购物车页面
            response.sendRedirect(request.getHeader("referer"));
        }
    }


}
