package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;

public interface fourthServiceInter extends BaseServiceInter {
	
	//��ȡ�������ĵ��ļ�Ŀ¼(ppt)
	public List getfourthbar(int newsid);
	
	//ȡ��ÿ���½�ppt�ĸ���
	public int getpptcount(int newsid);
	
	//ȡ����ͨ���������ļ��ı�
	public List getfourword(int newsid);
	
	//ȡ�����ļ�word�ĵ�
	public List getfourworddoc(int newsid);
	

}
