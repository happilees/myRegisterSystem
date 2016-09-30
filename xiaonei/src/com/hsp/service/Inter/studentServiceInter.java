package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Homework;
import com.hsp.domain.Student;
import com.hsp.domain.User;

public interface studentServiceInter extends BaseServiceInter {
	
	//验证用户
		public Student checkstudent(Student student);
		
		//验证老师
		public User checkuser(User user);
		
		//取出留言
		public List getComments(int PageSize,int PageNow);
		
		//计算一共有几页留言
		public int commentcount(int PageSize);
		
		//计算一共有几页作业
		public int homeworkcount(int PageSize);
		
		//取出所有的作业名
		public List<Homework> gethomeworkmc(int PageSize, int PageNow);
		
		//取出有几页作业
		public int homeworkmccount(int PageSize);
		
		//取出某一个作业名称的所有学生
		public List<Homework> everyhomework(String homeworkName, int PageSize, int PageNow);
		
		//取出某一个作业名称有几页学生
		public int homeworkcount(String homeworkName, int PageSize);
		
		//取出老师布置的作业题目和作业要求
		public List getteacherhw(int PageSize, int PageNow);
        
		//判断是否已经提交了
		public Homework checkhw(Homework homework);
		
		//取出有几页作业
		public int getteacherphwPage(int pageSize);
		
		//删除所有作业
		public List getAllHomework();

}
