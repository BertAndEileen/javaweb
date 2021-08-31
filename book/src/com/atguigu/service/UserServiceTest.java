package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author Bert
 */
public class UserServiceTest {
UserService userService=new UserServiceImpl();
    @Test
    public void login() {
        User loginUser = userService.login(new User(null, "王安石", "123", "123@qq.com"));
        if(loginUser==null){
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existsUsername() {
        //用户名是否存在
        if(userService.existsUsername("王安石1")){
            System.out.println("用户名不可用，该名字已经注册过");
        }else {
            System.out.println("用户名可用，该名字未注册");
        }
    }

    @Test
    public void registUser() {
        userService.registUser(new User(null,"杜甫","456","456@qq.com"));
    }
}