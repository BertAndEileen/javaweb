package com.atguigu.test;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {
    // hashTable()
    public static Map<String,Integer> map = new Hashtable<>();
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
    // 随机数对象
    public static Random random = new Random();

    /**
     * 自定义线程工作类
     */
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            /**
             * 我们要在线程开始的时候,获取当前线程名.然后为此线程关联一个数据,保存到map中 <br/>
             *  以线程名做为key,关联的数据做为值保存到map中 <br>
             *
             *  在线程快结束的时候,再以当前线程名取出关联的数据,查看数据和当前是否一致!!!
             */
            // 获取当前线程名
            String name = Thread.currentThread().getName();
            // 随机生成100以内的数
            int i = random.nextInt(100);

            System.out.println(" 当前线程名为: " + name + " , 随机生成的数据是: " + i);
            // 保存到map中 === 将线程和数据相关联
//            map.put(name,i);
            threadLocal.set(i);

            threadLocal2.set(0);

            threadLocal2.remove();
            threadLocal.remove();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();

            // 线程快结束,取出数据
//            Integer integer = map.get(name);
            Integer integer = threadLocal.get();

            System.out.println("当前线程[" + name + "] 中关联的数据是:" + integer);
            System.out.println("ThreadLocal2的值是:" +threadLocal2.get());
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 3; i++){
            new Thread(new MyTask()).start();
//        }
    }

}
