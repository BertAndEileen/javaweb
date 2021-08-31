package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234123412344", new Date(), new BigDecimal(10000), 0,10));
        orderDao.saveOrder(new Order("1234123412345", new Date(), new BigDecimal(10000), 0,10));
    }

    @Test
    public void queryAllOrders() {
        orderDao.queryAllOrders().forEach(System.out::println);
    }

    @Test
    public void queryOrdersByUserId() {
        orderDao.queryOrdersByUserId(2).forEach(System.out::println);
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("1234123412341",1);
    }
}