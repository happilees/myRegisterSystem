package com.hsp.service.Impl;

import java.util.List;

import com.hsp.baseService.BaseServiceImpl;
import com.hsp.domain.Homework;
import com.hsp.domain.Student;
import com.hsp.domain.User;
import com.hsp.service.Inter.studentServiceInter;

public class studentServiceImpl extends BaseServiceImpl implements
		studentServiceInter {

	public Student checkstudent(Student student) {
		// TODO Auto-generated method stub
		String hql="from Student where studentNo=? and password=?";
		Object []parameters={student.getStudentNo(),student.getPassword()};
		List<Student> list=this.getResult(hql, parameters);
		if(list.size()==1)
		{
			return list.get(0);
		}
		else{
		return null;
		}
	}

	public User checkuser(User user) {
		// TODO Auto-generated method stub
		String hql="from User where userName=? and userPassword=?";
		Object []parameters={user.getUserName(),user.getUserPassword()};
		List<User> list=this.getResult(hql, parameters);
		if(list.size()==1)
		{
			return list.get(0);
		}
		else{
		return null;
		}
	}

	public List getComments(int PageSize,int PageNow){
		// TODO Auto-generated method stub
		String hql="from Comments order by commentsTime desc";
		return this.executeQueryByPage(hql,null, PageSize, PageNow);
	}
	
	public int commentcount(int PageSize){
		String hql="select count(*) from Comments";
		return this.QueryPagecount(hql,null, PageSize);
	}

	public List<Homework> everyhomework(String homeworkName, int PageSize, int PageNow) {
		// TODO Auto-generated method stub
		String hql="from Homework where homeName=?";
		Object []parameters={homeworkName};
		return this.executeQueryByPage(hql, parameters, PageSize, PageNow);
	}

	public List<Homework> gethomeworkmc(int PageSize, int PageNow) {
		// TODO Auto-generated method stub
		String hql="select distinct homeName from Homework order by submitTime desc";
		return this.executeQueryByPage(hql,null, PageSize, PageNow);
	}

	public int homeworkcount(String homeworkName, int PageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Homework where homeName=?";
		Object []parameters={homeworkName};
		return this.QueryPagecount(hql,parameters,PageSize);
	}

	public int homeworkmccount(int PageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Homework where HomeName in(select distinct homeName from Homework order by submitTime desc)";
		return this.QueryPagecount(hql,null, PageSize);
	}

	public List getteacherhw(int PageSize, int PageNow) {
		// TODO Auto-generated method stub
		String hql="from Teacherphw order by id desc";
		return this.executeQueryByPage(hql, null, PageSize, PageNow);
	}

	public Homework checkhw(Homework homework) {
		String hql="from Homework where homeName=? and student.id=?";
		Object []parameters={homework.getHomeName(),homework.getStudent().getId()};
		Homework homeworkchecked=(Homework)this.uniqueQuery(hql, parameters);
		return homeworkchecked;
	}

	public int getteacherphwPage(int pageSize) {
		String hql="select count(*) from Teacherphw";
		return this.QueryPagecount(hql,null, pageSize);
	}

	public int homeworkcount(int PageSize) {
		String hql="select count(*) from Homework";
		return this.QueryPagecount(hql, null, PageSize);
	}

	public List getAllHomework() {
		String hql="from Homework";
		return this.getResult(hql, null);
	}
	
	
}
