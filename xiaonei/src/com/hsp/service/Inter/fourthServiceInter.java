package com.hsp.service.Inter;

import java.util.List;

import com.hsp.baseService.BaseServiceInter;

public interface fourthServiceInter extends BaseServiceInter {
	
	//获取第三级的第四级目录(ppt)
	public List getfourthbar(int newsid);
	
	//取出每个章节ppt的个数
	public int getpptcount(int newsid);
	
	//取出普通第三级第四级文本
	public List getfourword(int newsid);
	
	//取出第四级word文档
	public List getfourworddoc(int newsid);
	

}
