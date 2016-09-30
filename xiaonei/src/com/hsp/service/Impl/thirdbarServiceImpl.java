package com.hsp.service.Impl;

import java.util.List;

import com.hsp.baseService.BaseServiceImpl;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.service.Inter.thirdbarServiceInter;

public class thirdbarServiceImpl extends BaseServiceImpl implements
thirdbarServiceInter {

	public List getthirdbar(int id,int PageSize,int PageNow) {
		// TODO Auto-generated method stub
		
		String hql="from News where newstype.id=?";
		Object []parameters={id};
		return this.executeQueryByPage(hql, parameters, PageSize, PageNow);
	}
	
	public List getthirdbardesc(int id,int PageSize,int PageNow)
	{
		String hql="from News where newstype.id=? order by id desc";
		Object []parameters={id};
		return this.executeQueryByPage(hql, parameters, PageSize, PageNow);
	}

	public List<Newstype> getsecondbar(int id) {
		// TODO Auto-generated method stub
		
		String hql="from Newstype where navigationbar.id=?";
		Object []parameters={id};
		return this.getResult(hql, parameters);
	}

	public int getCount(int id,int PageSize) {
		// TODO Auto-generated method stub
		
		String hql="select count(*) from News where newstype.id=?";
		Object []parameters={id};
		return this.QueryPagecount(hql, parameters, PageSize);
	}

	public List getthirdbarnopage(int id) {
		// TODO Auto-generated method stub
		String hql="from News where newstype.id=?";
		Object []parameters={id};
		return this.getResult(hql, parameters);
	}

	public List getworddoc(int newsTypeid) {
		// TODO Auto-generated method stub
		String hql="from Worddoc where newstype.id=?";
		Object []parameters={newsTypeid};
		return this.getResult(hql, parameters);
	}

	public List getvedio(int newsid) {
		// TODO Auto-generated method stub
		String hql="from Video where news.id=?";
		Object []parameters={newsid};
		return this.getResult(hql, parameters);
	}

	public List getziyuan(int newsTypeid) {
		// TODO Auto-generated method stub
		String hql="from Ziyuan where newstype.id=?";
		Object []parameters={newsTypeid};
		return this.getResult(hql,parameters);
	}

	/*public List getdate(int id, int PageSize, int PageNow) {
		// TODO Auto-generated method stub
		
		String hql="select addtime from News where newstype.id=?";
		Object []parameters={id};
		return this.executeQueryByPage(hql, parameters, PageSize, PageNow);
	}*/
	
	

}
