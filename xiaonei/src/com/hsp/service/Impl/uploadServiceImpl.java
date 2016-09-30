package com.hsp.service.Impl;

import java.util.List;

import com.hsp.baseService.BaseServiceImpl;
import com.hsp.domain.Fourword;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Word;
import com.hsp.domain.Worddoc;
import com.hsp.service.Inter.uploadServiceInter;

public class uploadServiceImpl extends BaseServiceImpl implements
		uploadServiceInter {

	public List<News> getnews(int newsTypeid) {
		// TODO Auto-generated method stub
		String hql="from News where newstype.id=?";
		Object []parameters={newsTypeid};
		return this.getResult(hql, parameters);
	}

	public List getnewsType(String templet,String templet2) {
		// TODO Auto-generated method stub
		String hql="from Newstype where templet in (?,?)";
		Object []parameters={templet,templet2};
		return this.getResult(hql, parameters);
	}
	
	public List<Newstype> getNewstype(int PageSize,int PageNow){
		String hql="from Newstype order by id";
		return this.executeQueryByPage(hql,null,PageSize,PageNow);
	}
	
	public int getPageCount(int PageSize){
		String hql="select count(*) from Newstype";
		return this.QueryPagecount(hql,null,PageSize);
	}
	
	public List<Word> getword(int newsTypeid){
		String hql="from Word where newstype.id=?";
		Object []parameters={newsTypeid};
		return this.getResult(hql, parameters);
	}
	
	public List<Fourword> getfourword(int newsid){
		String hql="from Fourword where news.id=?";
		Object []parameters={newsid};
		return this.getResult(hql, parameters);
	}
	
	public List<Worddoc> deleteworddoc(int newsTypeid){
		String hql="from Worddoc where newstype.id=?";
		Object []parameters={newsTypeid};
		return this.getResult(hql, parameters);
	}

}
