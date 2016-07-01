package com.hsp.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class LoadPhoto {
	
	public String uploadFengmian(String fileFileName,HttpServletRequest request){
		
		//转换request
		MultipartHttpServletRequest rm=(MultipartHttpServletRequest)request;
		//获得文件
		CommonsMultipartFile cfile=(CommonsMultipartFile)rm.getFile(fileFileName);
		//获得文件的字节数组
		byte[] bfile=cfile.getBytes();
		String filename="";
		//获得当前时间
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		filename=format.format(new Date());
		Random random=new Random();
		//获得三位随机数
		for(int i=0;i<3;i++)
		{
		     filename =filename+random.nextInt(9);
		}
		//获取原始文件名
		String origFileName=cfile.getOriginalFilename();
		//xxx.jsp/png/...
	    String suffix=origFileName.substring(origFileName.lastIndexOf("."));
		//拿到项目的部署路径
		String path=request.getSession().getServletContext().getRealPath("/");
		OutputStream out=null;
		try {
			out=new FileOutputStream(new File(path+"/upload/"+filename+suffix));
			out.write(bfile);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename+suffix;
	}

}
