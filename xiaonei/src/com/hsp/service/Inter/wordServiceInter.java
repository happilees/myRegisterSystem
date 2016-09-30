package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Carousel;
import com.hsp.domain.Newstype;
import com.hsp.domain.Teacher;
import com.hsp.domain.Word;

public interface wordServiceInter extends BaseServiceInter {
	
	//取出文字
	public List<Word> getword(int Newstypeid);
	
	//取出文字所属的第一级导航下的第二级导航
	public List<Newstype> getsecondbar(int id);
	
	//取出教师资料
	public List<Teacher> getteacher();
	
	//取出旋转木马资料
	public List<Carousel> getcarousel();

}
