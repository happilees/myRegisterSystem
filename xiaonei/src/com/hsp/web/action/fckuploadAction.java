package com.hsp.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Fourword;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Word;
import com.hsp.service.Inter.fourthServiceInter;
import com.hsp.service.Inter.uploadServiceInter;

public class fckuploadAction {
	
    HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	private fourthServiceInter fourthServiceInter;
	private uploadServiceInter uploadServiceInter;
	private String nwesTitle;
	private String fckword;
	private int newsTypeid;
	
	
	public String getNwesTitle() {
		return nwesTitle;
	}
	public void setNwesTitle(String nwesTitle) {
		this.nwesTitle = nwesTitle;
	}
	public fourthServiceInter getFourthServiceInter() {
		return fourthServiceInter;
	}
	public void setFourthServiceInter(fourthServiceInter fourthServiceInter) {
		this.fourthServiceInter = fourthServiceInter;
	}
	public String getFckword() {
		return fckword;
	}
	public void setFckword(String fckword) {
		this.fckword = fckword;
	}
	public int getNewsTypeid() {
		return newsTypeid;
	}
	public void setNewsTypeid(int newsTypeid) {
		this.newsTypeid = newsTypeid;
	}
	
	public uploadServiceInter getUploadServiceInter() {
		return uploadServiceInter;
	}
	public void setUploadServiceInter(uploadServiceInter uploadServiceInter) {
		this.uploadServiceInter = uploadServiceInter;
	}
    
   public String execute(){
		
		System.out.println(fckword);
		//System.out.println(newsTypeid);
	   
	    Newstype newstype=(Newstype)fourthServiceInter.findById(Newstype.class,newsTypeid);
	    if(newstype.getTemplet().equals("2"))
	    {
	    	News news=new News();
	    	news.setAddtime(new java.util.Date());
	    	news.setNewsTitle(nwesTitle);
	    	news.setNewstype(newstype);
	    	news.setFlag(2);
	    	fourthServiceInter.save(news);
	    	Fourword fourword=new Fourword();
	    	fourword.setNews(news);
	    	fourword.setWordcontent(fckword);
	    	fourthServiceInter.save(fourword);
	    }
	    else{
	    Word word=new Word();
	    word.setAddtime(new java.util.Date());
	    word.setNewstype((Newstype)fourthServiceInter.findById(Newstype.class,newsTypeid));
	    word.setWordcontent(fckword);
	    fourthServiceInter.save(word);}
		List ntlist=uploadServiceInter.getnewsType("1","2");
		request.setAttribute("ntlist",ntlist);
		 request.setAttribute("message","success");
		return "success";
		
	}
}
	 
