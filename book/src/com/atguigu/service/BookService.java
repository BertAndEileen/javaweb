package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {

    /**
     * 添加图书
     *
     * @param book
     */
    public void addBook(Book book);

    /**
     * 根据id删除图书
     *
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 更新图书
     *
     * @param book
     */
    public void updateBookById(Book book);

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部图书
     *
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> page(Integer pageNo, Integer pageSize);

    Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
