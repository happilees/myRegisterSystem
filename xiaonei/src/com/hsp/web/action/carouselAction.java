package com.hsp.web.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hsp.domain.Carousel;
import com.hsp.domain.Newstype;
import com.hsp.domain.Teacher;
import com.hsp.domain.User;
import com.hsp.service.Inter.wordServiceInter;

public class carouselAction {
	
	private wordServiceInter wordServiceInter;
	private File image;
	private String imageFileName;
	private String intro;
	private Integer newsTypeid;
	private String teachername;
	
	
	public Integer getNewsTypeid() {
		return newsTypeid;
	}

	public void setNewsTypeid(Integer newsTypeid) {
		this.newsTypeid = newsTypeid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	HttpServletRequest request=ServletActionContext.getRequest();

	public wordServiceInter getWordServiceInter() {
		return wordServiceInter;
	}

	public void setWordServiceInter(wordServiceInter wordServiceInter) {
		this.wordServiceInter = wordServiceInter;
	}
	
	//添加一个
	public String addone(){
		
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		Newstype newstype=(Newstype)wordServiceInter.findById(Newstype.class,newsTypeid);
		if(newsTypeid.equals("9"))
		{
			Carousel carousel=new Carousel();
			carousel.setNewstype(newstype);
			carousel.setIntro(intro);
			carousel.setPictureurl(imageFileName);
			carousel.setTeachername(teachername);
			//System.out.println(imageFileName+teachername);
			wordServiceInter.save(carousel);
		}
		if(newsTypeid.equals("11"))
		{
			Teacher carousel=new Teacher();
			carousel.setNewstype(newstype);
			carousel.setIntro(intro);
			carousel.setPictureurl(imageFileName);
			carousel.setTeachername(teachername);
			//System.out.println(imageFileName+teachername);
			wordServiceInter.save(carousel);
		}
		return "imagesuccess";}
		else{
			return "userloginfail";
		}
	}
	
	//修改
	public String alreadychanged(){
		
		String newsTypeid=request.getParameter("newsTypeid");
		String newsid=request.getParameter("newsid");
		String realpath=ServletActionContext.getServletContext().getRealPath("/images");
		//String realpath="E:/uploadvideo";
		if(image!=null)
		{
			File savefile=new File(new File(realpath),imageFileName);
			if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(image, savefile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(newsTypeid.equals("9"))
		{
			Carousel carousel=(Carousel)wordServiceInter.findById(Carousel.class,Integer.parseInt(newsid));
			carousel.setIntro(intro);
			if(imageFileName!=null){
				carousel.setPictureurl(imageFileName);
			}
			wordServiceInter.update(carousel);
			request.setAttribute("carousel",carousel);
			//System.out.println(imageFileName);
		}
		if(newsTypeid.equals("11")||newsTypeid.equals("10"))
		{
			Teacher carousel=(Teacher)wordServiceInter.findById(Teacher.class,Integer.parseInt(newsid));
			carousel.setIntro(intro);
			if(imageFileName!=null){
				carousel.setPictureurl(imageFileName);
			}
			wordServiceInter.update(carousel);
			request.setAttribute("carousel",carousel);
			//System.out.println(imageFileName);
		}
		return "gochangecartea";
	}
	//删除/前往
	public String getcarousel(){
		
		String newsTypeid=request.getParameter("newsTypeid");
		String newsid=request.getParameter("newsid");
		String flag=request.getParameter("flag");
		if(newsTypeid.equals("9"))
		{
			Carousel carousel=(Carousel)wordServiceInter.findById(Carousel.class,Integer.parseInt(newsid));
			if(flag.equals("1"))
			{
				
				System.out.println(carousel.getIntro());
				wordServiceInter.delete(carousel);
			}
			if(flag.equals("2"))
			{
				request.setAttribute("carousel",carousel);
				return "gochangecartea";
			}
			List<Carousel> list=wordServiceInter.getcarousel();
			request.setAttribute("list",list);
		}
		if(newsTypeid.equals("11"))
		{
			Teacher carousel=(Teacher)wordServiceInter.findById(Teacher.class,Integer.parseInt(newsid));
			if(flag.equals("1"))
			{
				
				System.out.println(carousel.getIntro());
				wordServiceInter.delete(carousel);
			}
			if(flag.equals("2"))
			{
				request.setAttribute("carousel",carousel);
				return "gochangecartea";
			}
			List<Teacher> list=wordServiceInter.getteacher();
			request.setAttribute("list",list);
		}
		return "gocarousel";
	}

}