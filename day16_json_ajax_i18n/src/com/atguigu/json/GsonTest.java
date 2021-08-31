package com.atguigu.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonTest {

    @Test
    public void test() {
        Person person = new Person(1,"国哥好帅");
        // 创建谷歌gson包中提供的工具类
        Gson gson = new Gson();
        // 使用gson.toJson();
        String jsonPersonString = gson.toJson(person);
        System.out.println( jsonPersonString );
        // 还可以把json字符串转换javaBean
        Person person1 = gson.fromJson(jsonPersonString, Person.class);
        System.out.println(person1);
    }

    @Test
    public void test2() {

        List<Person> people = new ArrayList<>();
        people.add(new Person(1,"老韩好帅"));
        people.add(new Person(2,"飞哥更帅"));
        people.add(new Person(3,"国哥最帅"));
        // 先创建gson工具类
        Gson gson = new Gson();
        // 把list集合转换为json数组
        String jsonPeopleString = gson.toJson(people);
        System.out.println( jsonPeopleString );
        // fromJson把json字符串转换回list集合
        // toJson() 是把对象转换为json字符串
        // fromJson是把json字符串转换回java对象
        // 如果是转回一个JavaBean.则第二个参数是 转换的javaBean的具体类型
        // 如果是转回一个集合.则第二个参数是type类型
//        List<Person> list = gson.fromJson(jsonPeopleString, new PersonListType().getType());

        List<Person> list = gson.fromJson(jsonPeopleString,new TypeToken< ArrayList<Person> >(){}.getType());

        Person person = (Person) list.get(0);
        System.out.println(person);
    }

    @Test
    public void test3() {

        Map<String,Person> personMap = new HashMap<>();
        personMap.put("p1",new Person(1,"伟德好帅"));
        personMap.put("p2",new Person(2,"陈智平好帅"));
        personMap.put("p3",new Person(3,"刘鸳好美"));

        Gson gson = new Gson();
        // 所有java对象转换为json字符串.都是统一使用 toJson()方法
        String json = gson.toJson(personMap);
        System.out.println(json);
        // 把json字符串转换回 map 集合
//        cgson.fromJson(json, new PersonMapType().getType());
        // 官方推荐使用匿名内部类
        Map<String,Person> o = gson.fromJson(json,new TypeToken< HashMap<String,Person> >(){}.getType());
        System.out.println( o );
        Person person = o.get("p1");
        System.out.println(person);

    }


}
