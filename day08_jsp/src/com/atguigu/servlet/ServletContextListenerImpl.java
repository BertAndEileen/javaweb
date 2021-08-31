package com.atguigu.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Author Bert
 */
@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //可以做一些项目初始化工作
        System.out.println("ServletContextListener创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //释放一些项目的资源
        System.out.println("ServletContextListener销毁了");
    }
}
