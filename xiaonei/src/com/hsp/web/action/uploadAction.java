package com.hsp.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Fourworddoc;
import com.hsp.domain.News;
import com.hsp.domain.Newstype;
import com.hsp.domain.Pptorphoto;
import com.hsp.domain.User;
import com.hsp.domain.Video;
import com.hsp.domain.Word;
import com.hsp.domain.Worddoc;
import com.hsp.service.Inter.fourthServiceInter;
import com.hsp.service.Inter.uploadServiceInter;
import com.hsp.util.ConvertFlv;
import com.hsp.util.PPTtoImage;
import com.hsp.util.Word2Html;

public class uploadAction {
	
	HttpServletRequest request=ServletActionContext.getRequest();
	
	private uploadServiceInter uploadServiceInter;
	private fourthServiceInter fourthServiceInter;
	private File image;
	private String imageFileName;
	private String imageContentType;
	private String newsTypeid;
	private String flag;
	
	
	
    
	public fourthServiceInter getFourthServiceInter() {
		return fourthServiceInter;
	}
	public void setFourthServiceInter(fourthServiceInter fourthServiceInter) {
		this.fourthServiceInter = fourthServiceInter;
	}
	public uploadServiceInter getUploadServiceInter() {
		return uploadServiceInter;
	}
	public void setUploadServiceInter(uploadServiceInter uploadServiceInter) {
		this.uploadServiceInter = uploadServiceInter;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getNewsTypeid() {
		return newsTypeid;
	}
	public void setNewsTypeid(String newsTypeid) {
		this.newsTypeid = newsTypeid;
	}
	public String goloadppt(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		String flag=request.getParameter("flag");
		if(flag.equals("2"))
		{
			String templet="1";
			String templet2="2";
			int newsflag=2;
			List ntlist=uploadServiceInter.getnewsType(templet,templet2);
			//List nlist=uploadServiceInter.getnews(newsflag);
			request.setAttribute("ntlist",ntlist);
			//request.setAttribute("nlist",nlist);
			return "gouploadword";
		}
		else{
		return "goloadppt";
		}
		}
		else{
			return "userloginfail";
		}
	}

	
	//上传视频
	public String uploadvideo(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		String realpath=ServletActionContext.getServletContext().getRealPath("/uploadvideo");
		//String realpath="E:/uploadvideo";
		if(image!=null)
		{
			File savefile=new File(new File(realpath),imageFileName);
			if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(image, savefile);
				ConvertFlv.savevedio(realpath+"\\"+imageFileName, realpath+"\\100.flv",realpath+"\\"+newsTypeid+".jpg");
				//ConvertVideo.save(realpath,imageFileName,Integer.parseInt(newsTypeid));
				News news=new News();
				news.setAddtime(new java.util.Date());
				news.setFlag(1);
				news.setNewsTitle(imageFileName);
				news.setNewstype((Newstype)fourthServiceInter.findById(Newstype.class, Integer.parseInt(newsTypeid)));
				fourthServiceInter.save(news);
				ConvertFlv.savevedio(realpath+"\\"+imageFileName, realpath+"\\"+news.getId()+".flv",realpath+"\\"+newsTypeid+".jpg");
				Video video=new Video();
				video.setNews(news);
				video.setUrl((imageFileName.substring(0,imageFileName.indexOf(".")))+".flv");
				fourthServiceInter.save(video);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{

			}
		}
		request.setAttribute("message","上传成功");
		return "videosuccess";}else{
			return "userloginfail";
		}
	}
	//上传word文档
	public String updateword(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		String realpath=ServletActionContext.getServletContext().getRealPath("/uploadword");
		if(image!=null)
		{
			File savefile=new File(new File(realpath),imageFileName);
			if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(image, savefile);
				request.setAttribute("message","上传成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
		String newrealpath=realpath+"/"+imageFileName;
		int newid=Integer.parseInt(newsTypeid);
		//如果是课程公告，就储存在fourworddoc表
		if(newid==31)
		{
			News news=new News();
			news.setAddtime(new java.util.Date());
			news.setFlag(3);
			news.setNewsTitle(imageFileName.substring(0,imageFileName.indexOf(".")));
			news.setNewstype((Newstype)fourthServiceInter.findById(Newstype.class, newid));
			fourthServiceInter.save(news);
			Fourworddoc fourworddoc=new Fourworddoc();
			fourworddoc.setNews(news);
			fourworddoc.setWordname(imageFileName);
			fourworddoc.setWordurl(news.getId()+".html");
			Word2Html.changeWord2html(newrealpath,realpath,news.getId());
			fourthServiceInter.save(fourworddoc);
		}
		else{
		Word2Html.changeWord2html(newrealpath,realpath,newid);
		String saveload=newid+".html";
		Worddoc worddoc=new Worddoc();
		worddoc.setAddtime(new java.util.Date());
		worddoc.setNewstype((Newstype)fourthServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid)));
		worddoc.setWordname(imageFileName);
		worddoc.setWordurl(saveload);
		fourthServiceInter.save(worddoc);}
		return "wordsuccess";}
	    else{
			return "userloginfail";
		}
	}
	//上传ppt
	public String uploadppt(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		String realpath=ServletActionContext.getServletContext().getRealPath("/uploadppt");
		String filepath=request.getSession().getServletContext().getRealPath("/");
		
		if(image!=null)
		{
			File savefile=new File(new File(realpath),imageFileName);
			if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(image, savefile);
				request.setAttribute("message","上传成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//将ppt转化为图片并将图片路径存入数据库
		String pptload=realpath+"/"+imageFileName;
		//System.out.println(pptload);
		/*System.out.println("imageFileName"+imageFileName);
		System.out.println("flag"+flag);
		System.out.println("newsTypeid"+newsTypeid);*/
		News news=new News();
		news.setNewsTitle(imageFileName);
		news.setFlag(Integer.parseInt(flag));
		news.setAddtime(new java.util.Date());
		news.setNewstype((Newstype)fourthServiceInter.findById(Newstype.class,Integer.parseInt(newsTypeid)));
		fourthServiceInter.save(news);
		String newfullnewpath=filepath+"\\pptphoto\\"+news.getId()+"\\";
		List list=PPTtoImage.changppttoimage(pptload,newfullnewpath,news.getId());
		for(int i=0;i<list.size();i++)
		{
			Pptorphoto pptorphoto=new Pptorphoto();
			pptorphoto.setNews(news);
			pptorphoto.setUrl(list.get(i)+"");
		    fourthServiceInter.save(pptorphoto);
		}
		return "success";}else{
			return "userloginfail";
		}
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
	

}