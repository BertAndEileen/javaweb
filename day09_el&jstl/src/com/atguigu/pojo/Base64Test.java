package com.atguigu.pojo;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Author Bert
 */
public class Base64Test {
    public static void main(String[] args) throws Exception {
        String str="中国";
        // 生成BASE64的编码器
        BASE64Encoder base64Encoder=new BASE64Encoder();
        // 编码操作
        String encode1 = base64Encoder.encode(str.getBytes("utf-8"));
        System.out.println(encode1);
        //转回去// 生成一个BASE64的解码器
        BASE64Decoder base64Decoder=new BASE64Decoder();
        // 解码为byte数组
        byte[] bytes = base64Decoder.decodeBuffer(encode1);
        System.out.println(new String(bytes,"utf-8"));

    }
}
