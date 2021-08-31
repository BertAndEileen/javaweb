package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 生成订单
     * @param cart
     * @param userId
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 管理员查询全部订单
     * @return
     */
    public List<Order> queryAllOrders();

    /**
     * 根据用户查询用户订单
     * @param userId
     * @return
     */
    public List<Order> queryMyOrders(Integer userId);

    /**
     * 管理员发货
     * @param orderId
     */
    public void sendOrder(String orderId);

    /**
     * 用户签收
     * @param orderId
     */
    public void reveiveOrder(String orderId);

    /**
     * 根据订单号查询订单项
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderDetails(String orderId);
}
