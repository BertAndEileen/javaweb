package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public Integer queryForPageTotalCountByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where price between ? and ? ";
        Number number = (Number) queryForSingleValue(sql,min,max);
        return  number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` " +
                "from t_book where price between ? and ? order by price limit ? , ?";

        return queryForList(Book.class, sql,min,max,begin,pageSize);
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {

        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book limit ? , ?";

        return queryForList(Book.class, sql,begin,pageSize);

    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number) queryForSingleValue(sql);
        return  number.intValue();
    }

    public int saveBook(Book book) {

        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    public int updateBookById(Book book) {

        System.out.println(" BookDaoImpl 当前线程名是:" +Thread.currentThread().getName());

        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    public Book queryBookById(Integer id) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    public List<Book> queryBooks() {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book";
        return queryForList(Book.class, sql);
    }
}
