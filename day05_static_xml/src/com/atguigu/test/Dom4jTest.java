package com.atguigu.test;

import com.atguigu.pojo.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author Bert
 */
public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        //1.读取xml配置文件，生成Document对象
        SAXReader reader = new SAXReader();
        //2.读取xml文件
        Document read = reader.read("src/books.xml");
        System.out.println(read);
    }

    /*
     * 读取完xml后，要实现解析功能
     * 解析就是把xml中的内容转换为我们程序中需要的数据
     * 把xml转换成Book类
     * */
    @Test
    public void test2() {
        //1.读取xml配置文件，生成Document对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("src/books.xml");
            //2.通过Document对象获取root根元素,books
            Element rootElement = document.getRootElement();
            //asXML();是把标签对象转换成xml字符串
            //  System.out.println(rootElement.asXML());
            //4.通过根元素遍历每一个Book标签得到book类
            //element()和elements()是通过指定标签名得到子元素
            //element()查询单个子对象使用(只返回一个)
            //elements()查询多个子对象使用
            List<Element> books = rootElement.elements("book");
            for (Element book : books) {
                System.out.println(book.asXML());
                //获取sn属性
                String sn = book.attributeValue("sn");
                //获取name标签中的内容
                String nameText = book.elementText("name");
                String authorText = book.elementText("author");
                String priceText = book.elementText("price");
                Book book1 = new Book(sn,nameText,new BigDecimal(priceText),authorText);
                System.out.println(book1);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
