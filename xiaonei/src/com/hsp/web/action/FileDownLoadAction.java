package com.hsp.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zhanhengkitt on 2016/1/17.
 */
//文件下载
public class FileDownLoadAction extends ActionSupport{

    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    private int number ;

    private String fileName;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流
    public InputStream getDownloadFile() throws Exception
    {
        if(1 == number)
        {
            this.fileName = className+".txt" ;
            System.out.println(this.fileName);
            String path = ServletActionContext.getServletContext().getRealPath("/");//得到项目的根目
            //获取资源路径
            System.out.println(path);
            //解解乱码
            System.out.println(this.fileName);
            String realPath = path+"/studentScore/"+this.fileName;
            System.out.println(realPath);
            this.fileName = new String(this.fileName.getBytes("GBK"),"ISO-8859-1");//解决乱码问题
            return new FileInputStream(realPath);
        }

        else if(2 == number)
        {
            this.fileName = "jd2chm源码生成chm格式文档.rar" ;
            System.out.println(this.fileName);
            //解解乱码
            System.out.println(this.fileName);
            return ServletActionContext.getServletContext().getResourceAsStream("images/jd2chm源码生成chm格式文档.rar") ;
        }
        else
            return null ;
    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

}