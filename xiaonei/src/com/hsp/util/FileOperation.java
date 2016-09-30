package com.hsp.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class FileOperation {
	
	public List<String> getFileNameInDirectory(String path){
	
	    File file=new File(path);
		File[] tempList = file.listFiles();
		if(tempList!=null){
			List<String> directoryNameList=new ArrayList<String>();
			for (int i = 0; i < tempList.length; i++) {
			   if (tempList[i].isDirectory()) {
			    String classRoom=tempList[i].getName();
			    directoryNameList.add(classRoom);
			   }
			  }
			return directoryNameList;
		}
		else{
			return null;
		}
	}
	
	public void clearFiles(String workspaceRootPath){
		      File file = new File(workspaceRootPath);
		      if(file.exists()){
		           deleteFile(file);
		      }
		 }
	public void deleteFile(File file){
		      if(file.isDirectory()){
		           File[] files = file.listFiles();
		           for(int i=0; i<files.length; i++){
		                deleteFile(files[i]);
		           }
		      }
		      file.delete();
		 }
}
