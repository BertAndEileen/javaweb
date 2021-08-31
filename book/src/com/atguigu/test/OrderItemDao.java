package com.atguigu.test;

public class OrderItemDao {

    public void saveOrderItem(){
        String name = Thread.currentThread().getName();
        Integer integer = ThreadLocalTest.threadLocal.get();
        System.out.println("OrderItemDao  当前线程[" + name + "] 中关联的数据是:" + integer);
    }

}
