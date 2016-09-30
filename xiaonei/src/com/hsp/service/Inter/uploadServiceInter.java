package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Fourword;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Worddoc;

public interface uploadServiceInter extends BaseServiceInter {
	
	//取出templet为templet的newsType
	public List getnewsType(String templet,String templet2);
	
	//取出flag为flag的news
	public List<News> getnews(int newsTypeid);
	
	//取出所有的第二级
	public List<Newstype> getNewstype(int PageSize,int PageNow);
	
	//共有几页二级页面
	public int getPageCount(int PageSize);
	
	//取出二级目录为newsTypeid的word
	public List getword(int newsTypeid);
	
	//取出第三季目录为newsid的fourword
	public List<Fourword> getfourword(int newsid);
	
	//取出第二级为worddoc的newsTypeId的worddoc
	public List<Worddoc> deleteworddoc(int newsTypeid);
	

}
