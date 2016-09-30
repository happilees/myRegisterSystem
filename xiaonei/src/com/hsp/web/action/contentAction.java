package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Carousel;
import com.hsp.domain.Fourword;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Teacher;
import com.hsp.domain.User;
import com.hsp.domain.Word;
import com.hsp.domain.Worddoc;
import com.hsp.domain.Ziyuan;
import com.hsp.service.Inter.thirdbarServiceInter;
import com.hsp.service.Inter.uploadServiceInter;
import com.hsp.service.Inter.wordServiceInter;

public class contentAction {
	
	private uploadServiceInter uploadServiceInter;
	private thirdbarServiceInter thirdbarServiceInter;
	private wordServiceInter wordServiceInter;
	private String fckword;
	private String ziyuanurl;
	
	
	public wordServiceInter getWordServiceInter() {
		return wordServiceInter;
	}

	public void setWordServiceInter(wordServiceInter wordServiceInter) {
		this.wordServiceInter = wordServiceInter;
	}

	public String getZiyuanurl() {
		return ziyuanurl;
	}

	public void setZiyuanurl(String ziyuanurl) {
		this.ziyuanurl = ziyuanurl;
	}

	public thirdbarServiceInter getThirdbarServiceInter() {
		return thirdbarServiceInter;
	}

	public void setThirdbarServiceInter(thirdbarServiceInter thirdbarServiceInter) {
		this.thirdbarServiceInter = thirdbarServiceInter;
	}

	public String getFckword() {
		return fckword;
	}

	public void setFckword(String fckword) {
		this.fckword = fckword;
	}

	public uploadServiceInter getUploadServiceInter() {
		return uploadServiceInter;
	}

	public void setUploadServiceInter(uploadServiceInter uploadServiceInter) {
		this.uploadServiceInter = uploadServiceInter;
	}
	
	HttpServletRequest request=ServletActionContext.getRequest();
	//前往有第三级的内容
	public String gocontent(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null)
			{
				pageNow=Integer.parseInt(s_pageNow);
			}
			List<Newstype> list=uploadServiceInter.getNewstype(12,pageNow);
			//System.out.println("list="+list.size());
			int pageCount=uploadServiceInter.getPageCount(12);
			//System.out.println("pageCount="+pageCount);
			request.setAttribute("pageCount",pageCount);
			request.setAttribute("list",list);
			return "gocontent";
		}
		else{
			return "userloginfail";
		}
	}
	//前往修改第三级内容
	public String gochangeword(){
		String newsTypeid=request.getParameter("newsTypeid");
		String newsid=request.getParameter("newsid");
		if(newsid!=null)
		{
			
			List<Fourword> list=uploadServiceInter.getfourword(Integer.parseInt(newsid));
			Fourword word=list.get(list.size()-1);
			request.setAttribute("word",word);
			return "gochangefourword";
		}
		if(newsTypeid.equals("10"))
		{
			List<Teacher> list=wordServiceInter.getteacher();
			Teacher carousel=list.get(list.size()-1);
			request.setAttribute("carousel",carousel);
			return "gochangecartea";
		}
		else{
			List<Word> list=uploadServiceInter.getword(Integer.parseInt(newsTypeid));
			Word word=list.get(list.size()-1);
			request.setAttribute("word",word);
			return "gochangeword";
		}
	}
	//查看视频详情
	public String goseevedio(){
		String newsid=request.getParameter("newsid");
		String newsTypeid=request.getParameter("newsTypeid");
		//List al=thirdbarServiceInter.getthirdbarnopage(Integer.parseInt(newsTypeid));
		List list=thirdbarServiceInter.getvedio(Integer.parseInt(newsid));
		request.setAttribute("vedio",list.get(list.size()-1));
		return "seevedio";
	}
	//修改第三级内容
	public String changeword(){
		String wordid=request.getParameter("wordid");
		Word word=(Word)uploadServiceInter.findById(Word.class,Integer.parseInt(wordid));
		word.setWordcontent(fckword);
		uploadServiceInter.update(word);
		request.setAttribute("word",word);
		request.setAttribute("message","修改成功");
		return "changedword";
	}
	//修改第四级级内容
	public String changefourword(){
		String fourwordid=request.getParameter("fourwordid");
		Fourword word=(Fourword)uploadServiceInter.findById(Fourword.class,Integer.parseInt(fourwordid));
		word.setWordcontent(fckword);
		uploadServiceInter.update(word);
		request.setAttribute("word",word);
		request.setAttribute("message","修改成功");
		return "gochangefourword";
	}
	//前往和删除第三级目录
	public String godeletethirdbar(){
		String newsTypeid=request.getParameter("newsTypeid");
		String s_pageNow=request.getParameter("pageNow");
		String newsid=request.getParameter("newsid");
		int pageNow=1;
		if(s_pageNow!=null)
		{
			pageNow=Integer.parseInt(s_pageNow);
		}
		
		if(newsid!=null)
		{
			News news=(News)uploadServiceInter.findById(News.class,Integer.parseInt(newsid));
			uploadServiceInter.delete(news);
		}
		if(newsTypeid.equals("9"))
		{
			List<Carousel> list=wordServiceInter.getcarousel();
			request.setAttribute("list", list);
		    return "gocarousel";
		}
		
		if(newsTypeid.equals("11"))
		{
			List<Teacher> list=wordServiceInter.getteacher();
			request.setAttribute("list", list);
		    return "gocarousel";
		}
		List list=thirdbarServiceInter.getthirdbar(Integer.parseInt(newsTypeid),8, pageNow);
		int pageCount=thirdbarServiceInter.getCount(Integer.parseInt(newsTypeid),8);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("newsTypeid",newsTypeid);
		request.setAttribute("list",list);
		return "godeletethirdbar";
	}
	
	//前往和删除word文档
	public String godeleteworddoc(){
		String newsTypeid=request.getParameter("newsTypeid");
		String flag=request.getParameter("flag");
		List worddocList=uploadServiceInter.deleteworddoc(Integer.parseInt(newsTypeid));
		if(flag.equals("1"))
		{
			Worddoc worddoc=(Worddoc)worddocList.get(worddocList.size()-1);
			request.setAttribute("worddoc",worddoc);
			request.setAttribute("newsTypeid",newsTypeid);
			return "seeworddoc";
		}
		else{	
		for(int i=0;i<worddocList.size();i++)
		{
			Worddoc worddoc=(Worddoc)worddocList.get(i);
			//System.out.println(worddoc.getWordurl()+worddoc.getWordname());
			uploadServiceInter.delete(worddoc);
		}
		List<Newstype> list=uploadServiceInter.getNewstype(12,1);
		int pageCount=uploadServiceInter.getPageCount(12);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("list",list);
		return "gocontent";
		}
	}
	
	//查看/删除资源
	public String goziyuanbar(){
		String newsTypeid=request.getParameter("newsTypeid");
		String Ziyuanid=request.getParameter("Ziyuanid");
		String flag=request.getParameter("flag");
		if(Ziyuanid!=null&&flag.equals("2"))
		{
		Ziyuan ziyuan=(Ziyuan)thirdbarServiceInter.findById(Ziyuan.class,Integer.parseInt(Ziyuanid));
		thirdbarServiceInter.delete(ziyuan);
		}
		if(Ziyuanid!=null&&flag.equals("3"))
		{
			Ziyuan ziyuan=(Ziyuan)thirdbarServiceInter.findById(Ziyuan.class,Integer.parseInt(Ziyuanid));
			ziyuan.setZiyuanurl(ziyuanurl);
			ziyuan.setIntro(fckword);
			System.out.println(fckword);
			System.out.println(ziyuanurl);
			thirdbarServiceInter.update(ziyuan);
			request.setAttribute("message","修改成功");
		}
		if(flag.equals("4"))
		{
			Ziyuan ziyuan=new Ziyuan();
			ziyuan.setIntro(fckword);
			ziyuan.setZiyuanurl(ziyuanurl);
			Newstype newstype=(Newstype)thirdbarServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid));
			ziyuan.setNewstype(newstype);
			thirdbarServiceInter.save(ziyuan);
			request.setAttribute("message","添加成功");
		}
		List<Ziyuan> ziyuans=thirdbarServiceInter.getziyuan(Integer.parseInt(newsTypeid));
		request.setAttribute("ziyuans",ziyuans);
		return "goziyuanbar";
	}
	

}