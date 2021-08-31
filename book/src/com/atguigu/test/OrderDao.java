package com.atguigu.test;

public class OrderDao {

    public void saveOrder(){
        String name = Thread.currentThread().getName();
        Integer integer = ThreadLocalTest.threadLocal.get();
        System.out.println("OrderDao  当前线程[" + name + "] 中关联的数据是:" + integer);
    }

}
