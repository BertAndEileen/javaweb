package com.atguigu.test;

import java.lang.reflect.Method;

public class UserServletTest {

    public void login(){
        System.out.println("我登录了");
    }

    public void login(Integer id){
        System.out.println("我登录了");
    }

    public void regist(){
        System.out.println("我注册了");
    }

    public void updatePassword(){
        System.out.println("我密码修改了");
    }

    public void fly(){
        System.out.println("我飞,我得瑟了..   带我xxx.还有飞");
    }

    public static void main(String[] args) throws Exception {
        UserServletTest userServletTest = new UserServletTest();
        String action = "updatePassword";
        /**
         * getDeclaredMethod()给过给定的方法名和参数类型,返回方法的反射对象 <br>
         *     第一个参数是方法名
         *     之后的参数是方法的参数类型列表
         */
        Method method = UserServletTest.class.getDeclaredMethod(action);

//        System.out.println(method);
        // invoke() 方法是通过反射的方式 调用 方法
        // 第一个参数是 方法所属的对象实例
        // 之后的参数是. 方法的具体参数
        method.invoke(userServletTest);
    }

}
