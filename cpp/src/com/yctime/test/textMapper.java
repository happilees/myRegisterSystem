package com.yctime.test;

import java.util.List;

import org.junit.Test;

import com.yctime.pojo.Flag;
import com.yctime.pojo.FlagCustom;
import com.yctime.pojo.Selection;
import com.yctime.pojo.Student;
import com.yctime.service.MybatisUtil;
import com.yctime.service.studentService;

public class textMapper {
	
	
	public void teststudentMapper(){
		Student student=new Student();
		student.setClassname("通信1146");
		student.setIntroduce("我是一名勤勤恳恳的程序员！");
		student.setPower("我会写Hello world.");
		student.setSex("男");
		student.setTel("13413608264");
		student.setQq("2286390712");
		student.setUsername("郑浩");
		student.setMyflags("后台");
		student.setIsfile("无");
		student.setFilename("无");
		studentService studentser=new studentService();
		studentser.insertSStudent(student);
	}
	
	@Test
	public void testupdatstuMapper(){
		Student student=new Student();
		student.setId(66);
		student.setClassname("通信1146");
		student.setIntroduce("我是一名勤勤恳恳的程序员！");
		student.setPower("我会写Hello world.");
		student.setSex("男");
		student.setTel("13413608264");
		student.setUsername("郑浩荣");
		student.setMyflags("后台");
		student.setIsfile("有");
		student.setFilename("wwww.zip");
		studentService studentser=new studentService();
		studentser.updateSStudent(student);;
	}
	
	public void testgetpagecount(){
		studentService studentser=new studentService();
		int pagecount=studentser.getSstupageCount(2);
		System.out.println("pagecount-->"+pagecount);
	}
	
	
	public void teststudentByPage(){
		studentService studentser=new studentService();
		List<Student> studentlist=studentser.getSstudentByPage(3, 2);
		System.out.println("studentlist.size()-->"+studentlist.size());
		for(int i=0;i<studentlist.size();i++)
		{
			System.out.println(studentlist.get(i).getId()+"-->"+studentlist.get(i).getMyflags());
		}
	}
	

	public void testgetstuById(){
		studentService studentser=new studentService();
		Student student=new Student();
		student=studentser.getSstudentById(13);
		System.out.println(student.getId()+"-->"+student.getMyflags());
	}
	
	public void testinsertSSelection(){
		studentService studentser=new studentService();
		Selection selection=new Selection();
		selection.setFlagid(1);
		selection.setStudentid(23);
		studentser.insertSSelection(selection);
	}
	
	public void testselectSFlagStudent(){
		studentService studentser=new studentService();
		FlagCustom flagcustom=studentser.selectSFlagStudent(8);
		System.out.println(flagcustom.getName());
		System.out.println("*******************");
		for(Student student:flagcustom.getStudents())
		{
			System.out.println(student.getUsername());
		}
	}
	
	public void testgetSflagById(){
		studentService studentser=new studentService();
		Flag flag=studentser.getSflagById(6);
		System.out.println(flag.getName());
	}
	
	
	public void testgetSelectionid(){
		studentService studentser=new studentService();
		Selection selection=new Selection();
		selection.setFlagid(8);
		selection.setStudentid(37);
		int id=studentser.getSSelectionId(selection);
		System.out.println("id-->"+id);
	}
	
	
	public void testdeleteSelectionn(){
		studentService studentser=new studentService();
		Selection selection=new Selection();
		selection.setStudentid(60);
		studentser.deleteSSelection(selection);
	}
	
	
	public void testgetallstudent(){
		studentService studentser=new studentService();
		List<Student> studentlist=studentser.getSAllstudent();
		System.out.println(studentlist.size());
	}

}
