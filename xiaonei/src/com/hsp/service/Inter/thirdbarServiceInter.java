package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Newstype;

public interface thirdbarServiceInter extends BaseServiceInter {
	
	//���ݶ���������idȡ������������Ŀ¼
	public List getthirdbar(int id,int PageSize,int PageNow);
	
	//���ݶ���������idȡ������������Ŀ¼(����)
	public List getthirdbardesc(int id,int PageSize,int PageNow);
	
	//���ݶ���������idȡ������������Ŀ¼(ppt)
	public List getthirdbarnopage(int id);
	
	//public List getdate(int id,int PageSize,int PageNow);
	
	//���ݶ���������idȡ��ͬһһ�������µĶ���Ŀ¼
	public List<Newstype> getsecondbar(int id);
	
	//��������������ҳ��
	public int getCount(int id,int PageSize);
	
	//���ݶ���������idȡ������������Ŀ¼(word�ĵ�)
	public List getworddoc(int newsTypeid);
	
	//��������Ŀ¼�õ���Ƶ
	public List getvedio(int newsid);
	
	//ȡ��������Ϊ��Դ��Ŀ¼
	public List getziyuan(int newsTypeid);
	

}
