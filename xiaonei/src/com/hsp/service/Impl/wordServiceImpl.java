package com.hsp.service.Impl;

import java.util.List;

import com.hsp.baseService.BaseServiceImpl;
import com.hsp.domain.Carousel;
import com.hsp.domain.Newstype;
import com.hsp.domain.Teacher;
import com.hsp.domain.Word;
import com.hsp.service.Inter.wordServiceInter;

public class wordServiceImpl extends BaseServiceImpl implements
		wordServiceInter {

	public List<Word> getword(int Newstypeid) {
		// TODO Auto-generated method stub
		String hql="from Word where newstype.id=?";
		Object []parameters={Newstypeid};
		List<Word> list=this.getResult(hql, parameters);
		return list;
	}

	public List<Newstype> getsecondbar(int id) {
		// TODO Auto-generated method stub
		String hql="from Newstype where navigationbar.id=?";
		Object []parameters={id};
		return this.getResult(hql, parameters);
	}
	
	public List<Teacher> getteacher(){
		String hql="from Teacher order by id";
		return this.getResult(hql,null);
	}
	
	public List<Carousel> getcarousel(){
		String hql="from Carousel order by id";
		return this.getResult(hql,null);
	}

}
