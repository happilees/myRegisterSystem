package com.hsp.service.Impl;

import java.util.List;

import com.hsp.baseService.BaseServiceImpl;
import com.hsp.service.Inter.fourthServiceInter;

public class fourthServiceImpl extends BaseServiceImpl implements
		fourthServiceInter {

	public List getfourthbar(int newsid) {
		// TODO Auto-generated method stub
		String hql="from Pptorphoto where news.id=? order by id";
		Object []parameters={newsid};
		return this.getResult(hql, parameters);
	}

	public List getfourword(int newsid) {
		// TODO Auto-generated method stub
		String hql="from Fourword where news.id=?";
		Object []parameters={newsid};
		return this.getResult(hql, parameters);
	}
	
	public List getfourworddoc(int newsid){
		String hql="from Fourworddoc where news.id=?";
		Object []parameters={newsid};
		return this.getResult(hql, parameters);
	}
	
	public int getpptcount(int newsid){
		String hql="select count(*) from Fourworddoc where news.id=?";
		Object []parameters={newsid};
		return this.QueryPagecount(hql, parameters,1);
	}

}
