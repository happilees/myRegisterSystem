package com.yctime.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yctime.persistence.StudentMapper;
import com.yctime.pojo.Flag;
import com.yctime.pojo.FlagCustom;
import com.yctime.pojo.Page;
import com.yctime.pojo.Selection;
import com.yctime.pojo.Student;

public class studentService {
	
	//存储student
	public void insertSStudent(Student student){
		StudentMapper mapper = getMapper();
		mapper.insertStudent(student);
		sessionCommit();
		MybatisUtil.closeSession();
	}

	//获取student的页数
	public int getSstupageCount(int pageSize){
		StudentMapper mapper = getMapper();
		int pageCount=mapper.getstupageCount();
		MybatisUtil.closeSession();
		return ((pageCount-1)/pageSize)+1;
	}
	
	//对student分页获取数据
	public List<Student> getSstudentByPage(int pageSize,int pageNow){
		StudentMapper mapper = getMapper();
		Page page=new Page();
		page.setPageBegin((pageNow-1)*pageSize);
		page.setPageGet(pageSize);
		List<Student> studentlist=mapper.getstudentBypage(page);
		MybatisUtil.closeSession();
		return studentlist;
	}
	
	//通过id获取student
	public Student getSstudentById(int id){
		StudentMapper mapper = getMapper();
		Student student=mapper.getstudentById(id);
		MybatisUtil.closeSession();
		return student;
	}
	
	//插入selection记录
	public void insertSSelection(Selection selection){
		StudentMapper mapper = getMapper();
		mapper.insertSelection(selection);
		sessionCommit();
		MybatisUtil.closeSession();
	}
	
	//更新student
	public void updateSStudent(Student student){
		StudentMapper mapper = getMapper();
		mapper.updateStudent(student);
		sessionCommit();
		MybatisUtil.closeSession();
	}
	
	//根据方向查找到所有选择的学生
	public FlagCustom selectSFlagStudent(int id){
		StudentMapper mapper = getMapper();
		FlagCustom falgcustom=mapper.selectFlagStudent(id);
		MybatisUtil.closeSession();
		return falgcustom;
	}
	
	//通过id获取flag
	public Flag getSflagById(int id){
		StudentMapper mapper = getMapper();
		Flag flag=mapper.getflagById(id);
		MybatisUtil.closeSession();
		return flag;
	}
	
	//存储flag
	public void insertSflag(Flag flag){
		StudentMapper mapper = getMapper();
		mapper.insertflag(flag);
		sessionCommit();
		MybatisUtil.closeSession();
	}
	
	//判断是否已经报名
	public List<Student> getSStudent(Student student){
		StudentMapper mapper = getMapper();
		List<Student> studentlist=mapper.getstudent(student);
		MybatisUtil.closeSession();
		return studentlist;
	}
	
	//取出selectionid
	public int getSSelectionId(Selection selection)
	{
		StudentMapper mapper = getMapper();
		int selectionid=mapper.getSelectionId(selection);
		MybatisUtil.closeSession();
		return selectionid;
	}
	
	//更新selection
    public void deleteSSelection(Selection selection)
    {
    	StudentMapper mapper = getMapper();
		mapper.deleteSelection(selection);
		sessionCommit();
		MybatisUtil.closeSession();
    }

	public void sessionCommit() {
		SqlSession session=MybatisUtil.getcurrentSession();
		session.commit();
	}
    
    //获取全部student
    public List<Student> getSAllstudent()
    {
    	StudentMapper mapper = getMapper();
		List<Student> studentlist=mapper.getAllstudent();
		MybatisUtil.closeSession();
		return studentlist;
    }

	public StudentMapper getMapper() {
		SqlSession session=MybatisUtil.getcurrentSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		return mapper;
	}
}
