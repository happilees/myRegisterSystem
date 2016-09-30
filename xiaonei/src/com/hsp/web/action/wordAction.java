package com.hsp.web.action;

import static com.hsp.util.Word2Html.changeWord2html;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Carousel;
import com.hsp.domain.Homework;
import com.hsp.domain.Navigationbar;
import com.hsp.domain.Newstype;
import com.hsp.domain.Student;
import com.hsp.domain.Teacher;
import com.hsp.domain.Teacherphw;
import com.hsp.domain.User;
import com.hsp.domain.Word;
import com.hsp.service.Inter.studentServiceInter;
import com.hsp.service.Inter.wordServiceInter;
import com.hsp.util.Word2Html;

public class wordAction {
	
	private wordServiceInter wordServiceInter;
	private studentServiceInter studentServiceInter;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	private File image;
	private String imageFileName;
	private String homeName;
	
	
	
	public File getImage() {
		return image;
	}



	public void setImage(File image) {
		this.image = image;
	}



	public studentServiceInter getStudentServiceInter() {
		return studentServiceInter;
	}



	public void setStudentServiceInter(studentServiceInter studentServiceInter) {
		this.studentServiceInter = studentServiceInter;
	}



	public File getWorddoc() {
		return image;
	}



	public void setWorddoc(File image) {
		this.image = image;
	}



	public String getImageFileName() {
		return imageFileName;
	}



	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}



	public String getHomeName() {
		return homeName;
	}



	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}



	public wordServiceInter getWordServiceInter() {
		return wordServiceInter;
	}



	public void setWordServiceInter(wordServiceInter wordServiceInter) {
		this.wordServiceInter = wordServiceInter;
	}
	
    //取出word资料
	public String getword(){
		
		String newstypeid=request.getParameter("newsTypeid");
		String navigationbarid=request.getParameter("navigationbarid");
		List<Word> list=wordServiceInter.getword(Integer.parseInt(newstypeid));
		List<Newstype> al=wordServiceInter.getsecondbar(Integer.parseInt(navigationbarid));
		Word word=list.get(0);
		//System.out.println(word.getAddtime());
		Newstype newstype=(Newstype)wordServiceInter.findById(Newstype.class,Integer.parseInt(newstypeid));
		request.setAttribute("newstype",newstype);
		request.setAttribute("al",al);
		request.setAttribute("list",list);
		return "success";
	}
	
	//取出教师/木马资料
	public String getteacher(){
		String newstypeid=request.getParameter("newsTypeid");
		String navigationbarid=request.getParameter("navigationbarid");
		List<Newstype> al=wordServiceInter.getsecondbar(Integer.parseInt(navigationbarid));
		
		if(newstypeid.equals("11"))
		{
			List<Teacher> list=wordServiceInter.getteacher();
			request.setAttribute("list",list);
			request.setAttribute("al",al);
			Newstype newstype=(Newstype)wordServiceInter.findById(Newstype.class,Integer.parseInt(newstypeid));
			request.setAttribute("newstype",newstype);
			return "gototeacher";
		}
		if(newstypeid.equals("9"))
		{
			List<Carousel> list=wordServiceInter.getcarousel();
			request.setAttribute("list",list);
			request.setAttribute("al",al);
			Newstype newstype=(Newstype)wordServiceInter.findById(Newstype.class,Integer.parseInt(newstypeid));
			request.setAttribute("newstype",newstype);
			return "gototeacher";
		}
		else{
			Teacher teacher=(Teacher)wordServiceInter.findById(Teacher.class,1);
			request.setAttribute("teacher",teacher);
			request.setAttribute("al",al);
			Newstype newstype=(Newstype)wordServiceInter.findById(Newstype.class,Integer.parseInt(newstypeid));
			request.setAttribute("newstype",newstype);
			return "gotooneteacher";
		}
	}
	
	//取出单个教师/木马资料
	public String gooneteacher(){
		String newstypeid=request.getParameter("newstypeid");
		String navigationbarid=request.getParameter("navigationbarid");
		String teacherid=request.getParameter("teacherid");
		if(newstypeid.equals("11"))
		{
		Teacher teacher=(Teacher)wordServiceInter.findById(Teacher.class,Integer.parseInt(teacherid));
		request.setAttribute("teacher",teacher);
		}
		else{
		Carousel teacher=(Carousel)wordServiceInter.findById(Carousel.class,Integer.parseInt(teacherid));
		request.setAttribute("teacher",teacher);
		}
		List<Newstype> al=wordServiceInter.getsecondbar(Integer.parseInt(navigationbarid));
		request.setAttribute("al",al);
		Newstype newstype=(Newstype)wordServiceInter.findById(Newstype.class,Integer.parseInt(newstypeid));
		request.setAttribute("newstype",newstype);
		return "gotooneteacher";
	}
	
	//前往提交作业界面
	public String gohandinhw(){
		Student student=(Student)request.getSession().getAttribute("student");
		if(student!=null)
		{
		    String hwid=request.getParameter("hwid");
		    Teacherphw tphw=(Teacherphw)studentServiceInter.findById(Teacherphw.class,Integer.parseInt(hwid));
		    request.setAttribute("tphw", tphw);
		    request.setAttribute("student",student);
		    return "gohandinhw";
		}
		else
		{
			return "nologin";
		}
	}
	
	//前往作业提交系统首页
	public String gohomework(){
		Student student=(Student)request.getSession().getAttribute("student");
		if(student!=null)
		{
			String pageNow_s=request.getParameter("pageNow");
			Integer pageNow=1;
			if(pageNow_s!=null){
				pageNow=Integer.parseInt(pageNow_s);
			}
			Integer pageCount=studentServiceInter.homeworkcount(10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("student",student);
			List hwlist=studentServiceInter.getteacherhw(10,pageNow);
			request.setAttribute("hwlist",hwlist);
		    return "gohomework";
		}
		else{
			String flag=request.getParameter("flag");
			request.setAttribute("flag",flag);
			return "nologin";
		}
	}
	//学生上传word文档作业
	public String uploadhomework(){
		
		
		Student student=(Student)request.getSession().getAttribute("student");
		if(student!=null)
		{
			String className=student.getClassName();
			String realpath=ServletActionContext.getServletContext().getRealPath("/uploadstuword/"+className);
			System.out.println("realpath"+realpath);
			if(image!=null)
			{
				//System.out.println("before"+imageFileName);
				imageFileName=student.getClassName()+student.getStudentName()+student.getStudentNo()+homeName+
						imageFileName.substring(imageFileName.indexOf("."),imageFileName.length());
				//System.out.println("after"+imageFileName);
				File savefile=new File(new File(realpath),imageFileName);
				if(!savefile.getParentFile().exists()){
					savefile.getParentFile().mkdirs();
				}
				try {
					//System.out.println("正在上传");
					FileUtils.copyFile(image, savefile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	    Homework homework=new Homework();
	    homework.setFileUrl("111");
	    homework.setDownloadTime(0);
	    homework.setHomeName(imageFileName);
	    homework.setStudent(student);
	    Homework homeworkchecked=studentServiceInter.checkhw(homework);
	    if(homeworkchecked!=null)
	    {
	    	request.setAttribute("message","你已经提交过 "+homeName+" 的作业了");
			request.setAttribute("student",student);
			return "homeworksuccess";
	    }
	    else
	    {
	    	homework.setSubmitTime(new java.util.Date());
		    studentServiceInter.save(homework);
		    String newrealpath=realpath+"/"+imageFileName;
			//Word2Html.changeWord2html(newrealpath,realpath,homework.getId());
			//homework.setFileUrl(homework.getId()+".html");
			//studentServiceInter.update(homework);
			request.setAttribute("message","恭喜你，"+homeName+" 提交作业成功！");
			request.setAttribute("student",student);
			return "homeworksuccess";
	    }
	    
	}
		else{
			return "nologin";
		}
	}	

}