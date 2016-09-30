package com.hsp.web.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Navigationbar;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Worddoc;
import com.hsp.service.Impl.thirdbarServiceImpl;
import com.hsp.service.Inter.thirdbarServiceInter;
import com.hsp.util.datetime;

public class thirdbarAction{
	
	private  thirdbarServiceInter thirdbarServiceInter;
    
    public thirdbarServiceInter getThirdbarServiceInter() {
		return thirdbarServiceInter;
	}
	public void setThirdbarServiceInter(thirdbarServiceInter thirdbarServiceInter) {
		this.thirdbarServiceInter = thirdbarServiceInter;
	}
	HttpServletRequest request=ServletActionContext.getRequest();
    HttpServletResponse response=ServletActionContext.getResponse();
	//取出第三级目录
	public String getthirdbar()
	{
		String newsTypeid=request.getParameter("newsTypeid");
		String navigationbarid=request.getParameter("navigationbarid");
		String templet=request.getParameter("templet");
		Navigationbar navigationbar=(Navigationbar)thirdbarServiceInter.findById(Navigationbar.class,Integer.parseInt(navigationbarid));
		/*System.out.println("newsTypeid"+newsTypeid);
		System.out.println("navigationbarid"+navigationbarid);
		System.out.println("templet"+templet);*/
		List<Newstype> al=thirdbarServiceInter.getsecondbar(Integer.parseInt(navigationbarid));
		String s_pageNow=request.getParameter("pageNow");
		//System.out.println("s_pageNow="+s_pageNow);
		int pageNow=1;
		if(s_pageNow!=null)
		{
			pageNow=Integer.parseInt(s_pageNow);
		}
		//第三级目录下有资源链接的
		if(templet.equals("6")){
			List ziyuanlist=thirdbarServiceInter.getziyuan(Integer.parseInt(newsTypeid));
			request.setAttribute("ziyuanlist",ziyuanlist);
			request.setAttribute("al",al);
			request.setAttribute("navigationbar",navigationbar);
			Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
			request.setAttribute("newstype",newstype);
			return "goziyuan";
		}
		//第三级目录下有word文档的
		if(templet.equals("3")){
			List worddoclist=thirdbarServiceInter.getworddoc(Integer.parseInt(newsTypeid));
			Worddoc worddoc=(Worddoc)worddoclist.get(worddoclist.size()-1);
			request.setAttribute("worddoc",worddoc);
			request.setAttribute("al",al);
			request.setAttribute("navigationbar",navigationbar);
			Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
			request.setAttribute("newstype",newstype);
			return "gotoworddoc";
		}
		//第三级目录下有视频列表的
		if(templet.equals("4")){
			List vediolist=thirdbarServiceInter.getthirdbar(Integer.parseInt(newsTypeid),9,pageNow);
			int pageCount=thirdbarServiceInter.getCount(Integer.parseInt(newsTypeid),9);
			request.setAttribute("vediolist",vediolist);
			request.setAttribute("al",al);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("newsTypeid",newsTypeid);
			request.setAttribute("navigationbarid",navigationbarid);
			request.setAttribute("templet",templet);
			Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
			request.setAttribute("newstype",newstype);
			return "gotovedio";
		}
		else{
		int pageCount=thirdbarServiceInter.getCount(Integer.parseInt(newsTypeid),10);
		//System.out.println(pageCount);
		List list=thirdbarServiceInter.getthirdbar(Integer.parseInt(newsTypeid),10,pageNow);
		request.setAttribute("list",list);
		request.setAttribute("al",al);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("newsTypeid",newsTypeid);
		request.setAttribute("navigationbarid",navigationbarid);
		request.setAttribute("templet",templet);
		Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
		request.setAttribute("newstype",newstype);
		return "getthirdbar";
		}
	}

}