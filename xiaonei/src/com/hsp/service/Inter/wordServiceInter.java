package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Carousel;
import com.hsp.domain.Newstype;
import com.hsp.domain.Teacher;
import com.hsp.domain.Word;

public interface wordServiceInter extends BaseServiceInter {
	
	//ȡ������
	public List<Word> getword(int Newstypeid);
	
	//ȡ�����������ĵ�һ�������µĵڶ�������
	public List<Newstype> getsecondbar(int id);
	
	//ȡ����ʦ����
	public List<Teacher> getteacher();
	
	//ȡ����תľ������
	public List<Carousel> getcarousel();

}
