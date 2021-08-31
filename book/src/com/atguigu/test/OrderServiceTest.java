package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"母猪产后护理I",
                1,new BigDecimal(10000),new BigDecimal(10000)));
        cart.addItem(new CartItem(1,"母猪产后护理I",
                1,new BigDecimal(10000),new BigDecimal(10000)));
        cart.addItem(new CartItem(2,"母猪产后护理II",
                1,new BigDecimal(20000),new BigDecimal(20000)));
        cart.addItem(new CartItem(3,"ThinkPad T490",
                1,new BigDecimal(15000),new BigDecimal(15000)));

        orderService.createOrder(cart,2);

    }

    @Test
    public void queryAllOrders() {
        for (Order order : orderService.queryAllOrders()) {
            System.out.println(order);
        }
    }

    @Test
    public void queryMyOrders() {
        orderService.queryMyOrders(2).forEach(System.out::println);
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("15875180696511");
    }

    @Test
    public void reveiveOrder() {
        orderService.reveiveOrder("15875180696511");
    }

    @Test
    public void queryOrderDetails() {
        for (OrderItem orderItem : orderService.queryOrderDetails("15875180696511")) {
            System.out.println(orderItem);
        }
    }
}