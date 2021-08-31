package com.atguigu.json;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * 泛型是要把json转换回去的具体类型
 */
public class PersonListType extends TypeToken<ArrayList<Person>> {
}
