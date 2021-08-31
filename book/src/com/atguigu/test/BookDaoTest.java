package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,"国哥为什么你这么优秀" ,
                "0211",new BigDecimal(999), 100000,0 ,null ));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBookById() {
        bookDao.updateBookById(new Book(21,"史丹阳说,你这样好吗?" ,
                "0211",new BigDecimal(9.9), 0,100000 ,null ));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){

        bookDao.queryForPageItems(0, Page.PAGE_SIZE).forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItemsByPrice(){
        bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50).forEach(System.out::println);
    }


    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }
}