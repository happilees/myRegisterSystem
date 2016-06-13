package com.yctime.persistence;

import java.util.List;

import com.yctime.pojo.Flag;
import com.yctime.pojo.FlagCustom;
import com.yctime.pojo.Page;
import com.yctime.pojo.Selection;
import com.yctime.pojo.Student;

public interface StudentMapper {
	
	public void insertStudent(Student student);
    
	public int getstupageCount();
	
	public List<Student> getstudentBypage(Page page);
	
	public Student getstudentById(int id);
	
	public void insertSelection(Selection selection);
	
	public void updateStudent(Student student);
	
	public FlagCustom selectFlagStudent(int id);
	
	public Flag getflagById(int id);
	
	public void insertflag(Flag flag);
	
	public List<Student> getstudent(Student student);
	
	public int getSelectionId(Selection selection); 
	
	public void deleteSelection(Selection selection);
	
	public List<Student> getAllstudent();
}
