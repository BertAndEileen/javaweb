package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        System.out.println(" OrderServiceImpl 当前线程名是:" +Thread.currentThread().getName());

        // 订单号,要确保唯一,
        // 这里订单号的算法,简单的使用时间+用户编号
        String orderId = System.currentTimeMillis() + "" + userId;
        // 创建一个订单对象
        Order order = new Order(orderId,new Date(), cart.getTotalPrice(),0,userId);
        // 保存订单
        orderDao.saveOrder(order);

        int i = 12 / 0; // 故意 产生异常.看看,有没有事务

        // 保存订单项
        // 遍历购物车中的商品项,生成订单项,保存到数据库
        for (CartItem cartItem : cart.getItems().values()) {
            // 把购物车商品项转换成为了订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            // 保存订单项
            orderItemDao.saveOrderItem(orderItem);

            // 还要修改图书的销量和库存
            // 得到原来的商品信息
            Book book = bookDao.queryBookById(cartItem.getId());
            // 修改库存
            book.setStock( book.getStock() - cartItem.getCount() );
            // 修改销量
            book.setSales(book.getSales() + cartItem.getCount());
            // 保存商品信息
            bookDao.updateBookById(book);
        }

        // 清空购物车
        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> queryAllOrders() {
        return orderDao.queryAllOrders();
    }

    @Override
    public List<Order> queryMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public void reveiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);
    }

    @Override
    public List<OrderItem> queryOrderDetails(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }
}
