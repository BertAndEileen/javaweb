package com.atguigu.pojo;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * Author Bert
 */
@WebServlet(name = "DownloadServlet",urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        // 获取数据类型
        String mimeType = servletContext.getMimeType("/file/c.jpg");
        //    3 设置返回的数据类型
        response.setContentType(mimeType);
//        4 还要设置响应头,告诉客户端,收到的数据用来下载
        // Content-Disposition表示收到的内容怎么处理
        // attachemnt是附件,就是用于下载
        // filename是文件名

        // 如果浏览器是IE或谷歌,使用URL编码
        // url编码是把汉字转换成为 %xx%xx

        response.setHeader("Content-Disposition", "attachment; filename="
                + URLEncoder.encode("爱谁谁.jpg","UTF-8"));

        // 如果是老版本的火狐,使用base64
//        response.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?"
//                + new BASE64Encoder().encode("爱谁谁.jpg".getBytes("UTF-8")) + "?=");




//        1 读取需要下载的文件( 得到字节数组 )
        InputStream inputStream = servletContext.getResourceAsStream("/file/c.jpg");
//        2 获取响应的字节流,并输出数据给客户端
        ServletOutputStream outputStream = response.getOutputStream();

        //把输入流中的数据,写到输出流中
        IOUtils.copy(inputStream,outputStream);
        inputStream.close();
        outputStream.close();
    }
}
