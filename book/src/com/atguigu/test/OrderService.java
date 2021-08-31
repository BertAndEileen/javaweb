package com.atguigu.test;

public class OrderService {

    public void createOrder(){
        String name = Thread.currentThread().getName();
//        Integer integer = ThreadLocalTest.map.get(name);
        Integer integer = ThreadLocalTest.threadLocal.get();
        System.out.println("OrderService  当前线程[" + name + "] 中关联的数据是:" + integer);

        new OrderDao().saveOrder();
        new OrderItemDao().saveOrderItem();
    }

}
