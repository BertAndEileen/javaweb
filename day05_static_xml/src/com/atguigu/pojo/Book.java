package com.atguigu.pojo;

import org.dom4j.Attribute;

import java.math.BigDecimal;

/**
 * Author Bert
 */
public class Book {

    private String sn;
    private String name;
    private BigDecimal price;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }

    public Book(String sn, String name, BigDecimal price, String author) {
        this.sn = sn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book() {
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        double d1 = 0.01;
        double d2 = 0.06;

        System.out.println( d1 + d2 );

        BigDecimal b1 = new BigDecimal("0.000000000000000000001");
        BigDecimal b2 = new BigDecimal("0.000000000000000000006");

        // 快捷生成main方法   ===>>>  main
        // 快捷生成System.out.println ===>>>>  sout
        System.out.println(b1.add(b2));

        // 最最常用的快捷键 ALT + Insert(个别同学电脑需要ALT+FN+Insert) 可以生成各种代码.get/set   构造器 toString 重载  实现接口方法
        // ALT + Enter 可以用来生成变化 或者 Try+catch

    }
}
