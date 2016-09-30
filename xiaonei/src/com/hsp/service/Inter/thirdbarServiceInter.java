package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Newstype;

public interface thirdbarServiceInter extends BaseServiceInter {
	
	//根据二级导航的id取出第三级导航目录
	public List getthirdbar(int id,int PageSize,int PageNow);
	
	//根据二级导航的id取出第三级导航目录(倒序)
	public List getthirdbardesc(int id,int PageSize,int PageNow);
	
	//根据二级导航的id取出第三级导航目录(ppt)
	public List getthirdbarnopage(int id);
	
	//public List getdate(int id,int PageSize,int PageNow);
	
	//根据二级导航的id取出同一一级导航下的二级目录
	public List<Newstype> getsecondbar(int id);
	
	//查找三级导航的页数
	public int getCount(int id,int PageSize);
	
	//根据二级导航的id取出第三级导航目录(word文档)
	public List getworddoc(int newsTypeid);
	
	//根据三级目录得到视频
	public List getvedio(int newsid);
	
	//取出第三级为资源的目录
	public List getziyuan(int newsTypeid);
	

}
