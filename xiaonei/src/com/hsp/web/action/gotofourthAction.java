package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Fourword;
import com.hsp.domain.Fourworddoc;
import com.hsp.domain.Navigationbar;
import com.hsp.domain.Newstype;
import com.hsp.domain.Pptorphoto;
import com.hsp.service.Inter.fourthServiceInter;
import com.hsp.service.Inter.thirdbarServiceInter;

public class gotofourthAction {
	
	private fourthServiceInter fourthServiceInter;
	private thirdbarServiceInter thirdbarServiceInter;
	
	
	public thirdbarServiceInter getThirdbarServiceInter() {
		return thirdbarServiceInter;
	}

	public void setThirdbarServiceInter(thirdbarServiceInter thirdbarServiceInter) {
		this.thirdbarServiceInter = thirdbarServiceInter;
	}

	public fourthServiceInter getFourthServiceInter() {
		return fourthServiceInter;
	}

	public void setFourthServiceInter(fourthServiceInter fourthServiceInter) {
		this.fourthServiceInter = fourthServiceInter;
	}

	HttpServletRequest request=ServletActionContext.getRequest();
	
	//视频的第四级目录
	public String gotovedio(){
		
		String newsid=request.getParameter("newsid");
		String navigationbarid=request.getParameter("navigationbarid");
		List<Newstype> al=thirdbarServiceInter.getsecondbar(Integer.parseInt(navigationbarid));
		String newsTypeid=request.getParameter("newsTypeid");
		//List al=thirdbarServiceInter.getthirdbarnopage(Integer.parseInt(newsTypeid));
		List list=thirdbarServiceInter.getvedio(Integer.parseInt(newsid));
		request.setAttribute("vedio",list.get(list.size()-1));
		request.setAttribute("al",al);
		Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
		request.setAttribute("newstype",newstype);
		return "gotovediodetail";
	}
	
	//取出第四级
	public String gotofourth(){
		
		String newsid=request.getParameter("newsid");
		String newsTypeid=request.getParameter("newsTypeid");
		String flag=request.getParameter("flag");
		String navigationbarid=request.getParameter("navigationbarid");
		List<Newstype> al=thirdbarServiceInter.getsecondbar(Integer.parseInt(navigationbarid));
		//List al=thirdbarServiceInter.getthirdbarnopage(Integer.parseInt(newsTypeid));
		//第四级为文字
		if(flag.equals("2"))
		{
			List wordlist=fourthServiceInter.getfourword(Integer.parseInt(newsid));
			Fourword fourword=(Fourword)wordlist.get(wordlist.size()-1);
			request.setAttribute("fourword",fourword);
			request.setAttribute("al",al);
			Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
			request.setAttribute("newstype",newstype);
			return "gofourword";
		}
		//第四级为word文档
		if(flag.equals("3"))
		{
			List wordlist=fourthServiceInter.getfourworddoc(Integer.parseInt(newsid));
			Fourworddoc fourworddoc=(Fourworddoc)wordlist.get(wordlist.size()-1);
			request.setAttribute("fourworddoc",fourworddoc);
			request.setAttribute("al",al);
			Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
			request.setAttribute("newstype",newstype);
			return "gofourworddoc";
		}
		else
		{
		List list=fourthServiceInter.getfourthbar(Integer.parseInt(newsid));
		request.setAttribute("list",list);
		request.setAttribute("al",al);
		//System.out.println(list.size());
		Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
		request.setAttribute("newstype",newstype);
		return "success";
		}
		
	}

}