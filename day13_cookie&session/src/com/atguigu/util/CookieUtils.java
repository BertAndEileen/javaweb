package com.atguigu.util;

import javax.servlet.http.Cookie;

public class CookieUtils {
    /**
     * 查找指定名称的Cookie
     * @param name 要找的Cookie名称
     * @param cookies 全部的Cookie
     * @return
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (cookies == null || name == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }

}
