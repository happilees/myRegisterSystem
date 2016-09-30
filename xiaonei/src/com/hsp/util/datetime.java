package com.hsp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class datetime {
	
	public List getdate(List list){	
		  List<String> al=new ArrayList<String>();
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		  for(int i=0;i<list.size();i++)
		  {
		       String s=sdf.format(list.get(i));
		       al.add(s);
		  }
		  
		  return al;
		    
	}
	
	public static String formateDateTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentDate = sdf.format(date);
		return currentDate;
	}



}
