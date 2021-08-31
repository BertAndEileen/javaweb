package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * value = "/manager/bookServlet" 地址中添加/manager/是为了后面方便做权限检查
 */
@WebServlet(name = "BookServlet", value = "/manager/bookServlet")
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * page是分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 1 获取请求的参数 pageNo 和 pageSize
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE );
        //2 调用 bookService.page( pageNo , pageSize ) : Page对象;
        Page<Book> page = bookService.page( pageNo,pageSize );

        // 设置分页条的请求地址
        page.setUrl("manager/bookServlet?action=page");

        //3 把page分页对象保存到request域中
        request.setAttribute("page", page);
        //4 请求转发到 /pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    /**
     * 列表查询(查询全部图书)
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1 . 获取请求的参数 ( 如果有 )
//        2 . 调用BookService.queryBooks()查询全部图书
        List<Book> books = bookService.queryBooks();
//        3 . 把图书信息到Request域中
        request.setAttribute("books", books);
//        4 . 请求转发到
//           /pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }

    /**
     * 添加图书
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求的参数,封装为Book对象
        Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
        //2 调用 BookService.addBook(Book)添加图书
        bookService.addBook(book)  ;
//        // 3 查询全部图书,保存到reqeust域中
//        request.setAttribute("books", bookService.queryBooks());
//        // 4 请求转发到/pages/manager/book_manager.jsp页面
//        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response)   ;

        response.sendRedirect(request.getContextPath()
                + "/manager/bookServlet?action=page&pageNo=" + Integer.MAX_VALUE);

    }

    /**
     * 更新图书
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的全部参数.封装为book对象
        Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
        // 调用 bookService.updateBookById(book);
        bookService.updateBookById(book);
        // 重定向到图书列表管理页面
        response.sendRedirect(request.getContextPath()
                + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    /**
     * 查询要修改的图书信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取请求的参数图书信息
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2 调用 bookService.queryBookById(id):Book图书信息;
        Book book = bookService.queryBookById(id);
        // 3 保存图书信息到Request域中
        request.setAttribute("book",book);
        // 4 请求转发到book_edit.jsp页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp")
                .forward(request,response);
    }
    /**
     * 删除图书
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2 调用bookService.deleteBookById(id) 删除图书
        bookService.deleteBookById(id);
        // 3 重定向回图书列表管理页面
        response.sendRedirect(request
                .getContextPath() + "/manager/bookServlet?action=page&pageNo=" +request.getParameter("pageNo"));
    }
}
