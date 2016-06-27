package com.hsp.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class LoadPhoto {
	
	public String uploadFengmian(File file,String fileFileName){
		
		String realpath=ServletActionContext.getServletContext().getRealPath("/upload");
		fileFileName=UUID.randomUUID()+fileFileName.substring(fileFileName.indexOf("."),fileFileName.length());
		if(file!=null)
		{
			File savefile=new File(new File(realpath),fileFileName);
			if(!savefile.getParentFile().exists())
			{
				savefile.getParentFile().mkdirs();
			}
			try {
				FileUtils.copyFile(file,savefile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fileFileName;
	}

}
