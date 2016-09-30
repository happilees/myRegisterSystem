package com.hsp.web.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Homework;
import com.hsp.domain.Teacherphw;
import com.hsp.domain.User;
import com.hsp.service.Inter.studentServiceInter;
import com.hsp.util.FileOperation;
import com.hsp.util.MyUtil;

public class homeworkAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	private studentServiceInter studentServiceInter;
    private String require;
    private String hwname;
	
	
	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public String getHwname() {
		return hwname;
	}

	public void setHwname(String hwname) {
		this.hwname = hwname;
	}

	public studentServiceInter getStudentServiceInter() {
		return studentServiceInter;
	}

	public void setStudentServiceInter(studentServiceInter studentServiceInter) {
		this.studentServiceInter = studentServiceInter;
	}

	User user=(User)request.getSession().getAttribute("user");
	
	//前往作业界面
	public String gohomework(){
	
		if(user!=null)
		{
			String s_pageNow=request.getParameter("pageNow");
			//System.out.println("s_pageNow="+s_pageNow);
			int pageNow=1;
			if(s_pageNow!=null)
			{
				pageNow=Integer.parseInt(s_pageNow);
			}
			//List list=studentServiceInter.gethomeworkmc(10,pageNow);
			List list=studentServiceInter.getteacherhw(10, pageNow);
			int pageCount=studentServiceInter.getteacherphwPage(10);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("list",list);
			return "seestuhomework";
		}
		else
		{
			return "nouserlogin";
		}
	}
	
	//每个班级的验收界面
	public String gocheckhomework(){
		if(user!=null)
		{
			String path=ServletActionContext.getServletContext().getRealPath("/uploadstuword");
			FileOperation gf=new FileOperation();
			List<String> classRoomArray=gf.getFileNameInDirectory(path);
			request.setAttribute("classRoomArray", classRoomArray);
			return "goeveryone";
		}
		else
		{
			return "nouserlogin";
		}
	}
	
	//查看某个学生的作业
	public String deleteALl(){
		if(user!=null)
		{
			FileOperation fo=new FileOperation();
			String path=ServletActionContext.getServletContext().getRealPath("/uploadstuword");
			fo.clearFiles(path);
			List<Homework> hwList=studentServiceInter.getAllHomework();
			for(Homework hw:hwList){
				studentServiceInter.delete(hw);
			}
			return "goeveryone";
		}
		else
		{
			return "nouserlogin";
		}
	}
	
	//查看某个学生的作业
	public String seeoneguty(){
		if(user!=null)
		{
			String Homeworkid=request.getParameter("Homeworkid");
			Homework homework=(Homework)studentServiceInter.findById(Homework.class,Integer.parseInt(Homeworkid));
			request.setAttribute("homework",homework);
			return "gooneguy";
		}
		else
		{
			return "nouserlogin";
		}
	}
	
	//发布作业
	public String publishhw(){
		String flag=request.getParameter("flag");
		if(flag.equals("1"))
		{
			Teacherphw teacherphw=new Teacherphw();
			teacherphw.setHwname(hwname);
			teacherphw.setEwquire(require);
			studentServiceInter.save(teacherphw);
			request.setAttribute("message","布置作业成功！");
		}
		
		return "publishhw";
	}

}