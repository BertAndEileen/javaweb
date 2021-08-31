package com.atguigu.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /**
     * 将字符串转换成为int类型
     * @param intStr
     * @param defaultValue  如果转换失败,就返回defaultValue,使用这个默认值
     * @return
     */
    public static int parseInt(String intStr,int defaultValue){
        try {
            return Integer.parseInt(intStr);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 编写一个方法去将所有参数都一次性注入到JavaBean属性中 <br/>
     */
    public static <T> T copyParamToBean(T bean , Map value){
        try {
            /**
             * populate() 是把指定数据源中的值一次性注入到Bean的属性中 <br>
             *     第一个参数是要赋值的Bean对象 <br>
             *     第二个参数是数据源 <br>
             */
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
