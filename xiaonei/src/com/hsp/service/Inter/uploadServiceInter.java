package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Fourword;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Worddoc;

public interface uploadServiceInter extends BaseServiceInter {
	
	//ȡ��templetΪtemplet��newsType
	public List getnewsType(String templet,String templet2);
	
	//ȡ��flagΪflag��news
	public List<News> getnews(int newsTypeid);
	
	//ȡ�����еĵڶ���
	public List<Newstype> getNewstype(int PageSize,int PageNow);
	
	//���м�ҳ����ҳ��
	public int getPageCount(int PageSize);
	
	//ȡ������Ŀ¼ΪnewsTypeid��word
	public List getword(int newsTypeid);
	
	//ȡ��������Ŀ¼Ϊnewsid��fourword
	public List<Fourword> getfourword(int newsid);
	
	//ȡ���ڶ���Ϊworddoc��newsTypeId��worddoc
	public List<Worddoc> deleteworddoc(int newsTypeid);
	

}
