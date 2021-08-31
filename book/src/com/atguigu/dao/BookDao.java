package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return
     */
    public int saveBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 根据id更新图书
     * @param book
     * @return
     */
    public int updateBookById(Book book);

    /**
     * 根据指定的id查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部图书
     * @return
     */
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(Integer begin, Integer pageSize);

    Integer queryForPageTotalCountByPrice(Integer min, Integer max);

    List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);
}
