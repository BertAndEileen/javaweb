package com.atguigu.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Author Bert
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2.获取Document
        //2.1获取student.xml的路径
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //获取第一个name的element对象
        Element element = elements.get(0);
        //获取数据
        String name = element.text();
        System.out.println(name);

    }
}
