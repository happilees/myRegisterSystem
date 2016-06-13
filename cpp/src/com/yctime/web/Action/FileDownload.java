package com.yctime.web.Action;  
  
import java.io.IOException;
import java.io.InputStream;  
  
  

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;  
  
  






import com.opensymphony.xwork2.ActionSupport;  
import com.yctime.pojo.Student;
import com.yctime.service.studentService;
import com.yctime.utils.Excel;
  
//文件下载  
public class FileDownload extends ActionSupport{  
      
    private int number ;  
    HttpServletRequest request=ServletActionContext.getRequest();
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
           this.fileName = "JavaBooks.xls" ;  
           //获取资源路径  
           return ServletActionContext.getServletContext().getResourceAsStream("upload/JavaBooks.xls") ;  
        }  
        else  
           return null ;  
    }  
      
    @Override  
    public String execute() throws Exception {
    	Object codekey=request.getSession().getAttribute("user");
		if(codekey!=null)
		{
    	studentService stuService=new studentService();
    	//导出execl表格
			String excelFilePath = ServletActionContext.getRequest().getRealPath("/upload/JavaBooks.xls");
			List<Student> studentlist=stuService.getSAllstudent();
			//System.out.println("excelFilePath-->"+excelFilePath);
			Excel excel=new Excel();
			try {
				excel.writeExcel(studentlist, excelFilePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return SUCCESS;  
    }  
		else{
			return "loginfail";
		}
    }
}  
