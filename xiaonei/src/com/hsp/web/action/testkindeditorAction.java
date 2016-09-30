package com.hsp.web.action;

public class testkindeditorAction {
	
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String testkindeditor(){
		
		
		System.out.println(content);
		return "success";
	}

}
