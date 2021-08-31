package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemDaoTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"大话西游",10000,new BigDecimal(100),new BigDecimal(1000000),"1234123412341"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Macbook Pro",10000,new BigDecimal(100),new BigDecimal(1000000),"1234123412341"));

    }

    @Test
    public void queryOrderItemsByOrderId() {
        for (OrderItem orderItem : orderItemDao.queryOrderItemsByOrderId("1234123412341")) {
            System.out.println(orderItem);
        }
    }
}