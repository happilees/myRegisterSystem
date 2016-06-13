package com.yctime.utils;

public class xss {
	
	private  String htmlEncode(char c) {  
	    switch(c) {  
	       case '&':  
	           return"&amp;";  
	       case '<':  
	           return"&lt;";  
	       case '>':  
	           return"&gt;";  
	       case '"':  
	           return"&quot;";  
	       case ' ':  
	           return"&nbsp;";  
	       default:  
	           return c +"";  
	    }  
	}  
	   
	/** 对传入的字符串str进行Html encode转换 */  
	public  String htmlEncode(String str) {  
	    if(str ==null || str.trim().equals(""))   return str;  
	    StringBuilder encodeStrBuilder = new StringBuilder();  
	    for (int i = 0, len = str.length(); i < len; i++) {  
	       encodeStrBuilder.append(htmlEncode(str.charAt(i)));  
	    }  
	    return encodeStrBuilder.toString();  
	}  

}
