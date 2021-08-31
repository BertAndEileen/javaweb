package com.atguigu.web;

import com.atguigu.json.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AjaxServlet",value = "/ajaxServlet")
public class AjaxServlet extends BaseServlet {
    /**
     * 表示我们演示的第一个Ajax请求的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax 兄弟,你来了!!!");

        Person person = new Person(1,"0211.你们好帅!");
        // 先把要返回的数据转为json字符串
        Gson gson=new Gson();
        String json = gson.toJson(person);
        response.getWriter().write(json);

    }

      /**
     * 表示我们演示的第一个Ajax请求的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuery 的 ajax() 方法");

        Person person = new Person(1,"jQuery 的 ajax() 方法");
        // 先把要返回的数据转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);
        response.getWriter().write(json);
    }

      /**
     * 表示我们演示的第一个Ajax请求的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuery 的 get() 方法");
        Person person = new Person(1,"jQuery 的 get() 方法");
        // 先把要返回的数据转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);
        response.getWriter().write(json);
    }


      /**
     * 表示我们演示的第一个Ajax请求的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuery 的 Post() 方法");
        Person person = new Person(1,"jQuery 的 post() 方法");
        // 先把要返回的数据转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);
        response.getWriter().write(json);
    }




      /**
     * 表示我们演示的第一个Ajax请求的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void jQueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuery 的 getJSON() 方法");
        Person person = new Person(1,"jQuery 的 getJSON() 方法");
        // 先把要返回的数据转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);
        response.getWriter().write(json);
    }





      /**
     * 表示我们演示的第一个Ajax请求的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuery 的 serialize() 方法");

        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        System.out.println(Arrays.asList(request.getParameterValues("check")));


        Person person = new Person(1,"jQuery 的 serialize() 方法");


        // 先把要返回的数据转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(person);
        response.getWriter().write(json);
    }



}
