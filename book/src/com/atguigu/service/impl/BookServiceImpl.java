package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        // 设置每页显示数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice( min,max );
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / page.getPageSize();
        // 如果除不尽,总页码+1
        if (pageTotalCount % page.getPageSize() > 0) {
            pageTotal++;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 由公式求得begin的值( pageNo - 1 ) x 每页数量
        Integer begin = ( page.getPageNo() - 1 ) * page.getPageSize();
        // 求当前页数量
        List<Book> items = bookDao.queryForPageItemsByPrice( begin,page.getPageSize(),min,max );
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        // 设置每页显示数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / page.getPageSize();
        // 如果除不尽,总页码+1
        if (pageTotalCount % page.getPageSize() > 0) {
            pageTotal++;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);

        // 由公式求得begin的值( pageNo - 1 ) x 每页数量
        Integer begin = ( page.getPageNo() - 1 ) * page.getPageSize();
        // 求当前页数量
        List<Book> items = bookDao.queryForPageItems( begin,page.getPageSize() );
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public void addBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBookById(Book book) {
        bookDao.updateBookById(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
