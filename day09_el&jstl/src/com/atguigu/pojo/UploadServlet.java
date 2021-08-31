package com.atguigu.pojo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Author Bert
 */
@WebServlet(name = "UploadServlet",value = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //判断是否是多段的内容
   if(ServletFileUpload.isMultipartContent(request)){
     //创建一个FileItem类
     FileItemFactory fileItemFactory=new DiskFileItemFactory();
    //创建一个用于解析上传数据的工具类
    ServletFileUpload  servletFileUpload=new ServletFileUpload(fileItemFactory);
     try {
        //解析上传的数据，得到每一个表单项
      List<FileItem> list = servletFileUpload.parseRequest(request);
       //循环遍历每一个表单项
       for (FileItem fileItem : list) {
     //判断是否是普通的表单项
      if(fileItem.isFormField()){
       //普通表单项，只关心name属性值，和表单项的值
      System.out.println("name属性值："+fileItem.getFieldName());
      //写上utf-8，可以解决中文乱码
    System.out.println("表单项的值"+fileItem.getString("utf-8"));
     }else {
       //上传文件，关心name属性值，上传文件名，以及把上传的文件保存起来
    System.out.println("name属性值："+fileItem.getFieldName());
    System.out.println("上传的文件名"+fileItem.getName());
    //保存到d盘
    fileItem.write(new File("d:/"+fileItem.getName()));
     }
        }
      } catch (Exception e) {
      e.printStackTrace();
       }
        }
    }

}
