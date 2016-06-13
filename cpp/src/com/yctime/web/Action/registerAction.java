package com.yctime.web.Action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yctime.pojo.Flag;
import com.yctime.pojo.Selection;
import com.yctime.pojo.Student;
import com.yctime.service.studentService;
import com.yctime.utils.LoadPhoto;
import com.yctime.utils.xss;

public class registerAction extends ActionSupport{
	
	private String name;
	private String phone;
	private String classname;
	private String introduce;
	private String power;
	private String sex;
	private List<String> flag;
    private File file;
    private String fileFileName;
    private String qq;
    HttpServletRequest request=ServletActionContext.getRequest();
    
    //测试
    public String register(){
    	
    	xss xsss=new xss();
    	Student student=new Student();
    	student.setClassname(xsss.htmlEncode(classname));
    	student.setIntroduce(xsss.htmlEncode(introduce));
    	student.setSex(sex);
    	student.setTel(phone);
    	student.setUsername(xsss.htmlEncode(name));
    	student.setQq(qq);
    	student.setIsfile("无");
    	student.setFilename("无");
    	student.setMyflags("无");
    	System.out.println("classname-->"+student.getClassname());
    	System.out.println("introduce-->"+student.getIntroduce());
    	System.out.println("name-->"+student.getUsername());
    	String myflags=new String();
		Selection selection=new Selection();
    	if(power!=null)
    	{
    		student.setPower(xsss.htmlEncode(power));
    		System.out.println("power-->"+student.getPower());
    	}
    	if(power==null){
    		student.setPower("无");
    	}
    	//存储学生,先判断是否已报名
    	studentService studentSer=new studentService();
    	List<Student> oldStudent=studentSer.getSStudent(student);
    	LoadPhoto loadPhoto=new LoadPhoto();
    	if(oldStudent.size()!=0)
    	{
    		request.setAttribute("success","报名信息更改成功！");
    		Student oldstudent=oldStudent.get(0);
    		student.setId(oldstudent.getId());
    		selection.setStudentid(student.getId());
    		studentSer.deleteSSelection(selection);
    		for(int i=0;i<flag.size();i++)
        	{
    			myflags+="  "+flag.get(i)+"  ";
    			//存入selection
    			selection.setStudentid(student.getId());
    			switch(flag.get(i)){
    			case "Android":
    			selection.setFlagid(1);break;
    			case "IOS":
        			selection.setFlagid(2);break;
    			case "UI":
        			selection.setFlagid(3);break;
    			case "前端":
        			selection.setFlagid(4);break;
    			case "后台":
        			selection.setFlagid(5);break;
    			case "C++":
        			selection.setFlagid(6);break;
    			case "产品":
        			selection.setFlagid(7);break;
    			case "运营":
        			selection.setFlagid(8);break;
    			}
    			studentSer.insertSSelection(selection);
        	}
    		student.setMyflags(myflags);
        	if(file!=null)
        	{
        		String realFilename=student.getId()+"_"+student.getClassname()+"_"+student.getUsername();
            	loadPhoto.uploadFengmian(file, fileFileName,realFilename);
            	student.setIsfile("有");
            	student.setFilename(fileFileName);
        	}
        	studentSer.updateSStudent(student);
        	return "registered";
    	}
    	
    	
    	
    	
    	//如果是没有注册的
    	studentSer.insertSStudent(student);
    		for(int i=0;i<flag.size();i++)
        	{
    			myflags+="  "+flag.get(i)+"  ";
    			//存入selection
    			selection.setStudentid(student.getId());
    			switch(flag.get(i)){
    			case "Android":
    			selection.setFlagid(1);break;
    			case "IOS":
        			selection.setFlagid(2);break;
    			case "UI":
        			selection.setFlagid(3);break;
    			case "前端":
        			selection.setFlagid(4);break;
    			case "后台":
        			selection.setFlagid(5);break;
    			case "C++":
        			selection.setFlagid(6);break;
    			case "产品":
        			selection.setFlagid(7);break;
    			case "运营":
        			selection.setFlagid(8);break;
    			}
    			studentSer.insertSSelection(selection);
        	}
    		student.setMyflags(myflags);
    	if(file!=null)
    	{
    		String realFilename=student.getId()+"_"+student.getClassname()+"_"+student.getUsername();
        	loadPhoto.uploadFengmian(file, fileFileName,realFilename);
        	student.setIsfile("有");
        	student.setFilename(xsss.htmlEncode(fileFileName));
    	}
    	studentSer.updateSStudent(student);
    	request.setAttribute("success","恭喜你，报名成功！");
    	return "registered";
    }
    
    public String addfalg(){
    	Flag flag=new Flag();
    	flag.setName(name);
    	studentService studentSer=new studentService();
    	studentSer.insertSflag(flag);
    	request.setAttribute("success","恭喜你，add flag 成功！");
    	return "addedflag";
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getFlag() {
		return flag;
	}

	public void setFlag(List<String> flag) {
		this.flag = flag;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
    
	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}
	
}