package com.hsp.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hsp.service.Inter.thirdbarServiceInter;
import com.hsp.service.Inter.wordServiceInter;

public class goshouyeAction {
	
	private thirdbarServiceInter thirdbarServiceInter;
	private wordServiceInter wordServiceInter;
	
	
	public wordServiceInter getWordServiceInter() {
		return wordServiceInter;
	}



	public void setWordServiceInter(wordServiceInter wordServiceInter) {
		this.wordServiceInter = wordServiceInter;
	}



	HttpServletRequest request=ServletActionContext.getRequest();

    
	
	public thirdbarServiceInter getThirdbarServiceInter() {
		return thirdbarServiceInter;
	}



	public void setThirdbarServiceInter(thirdbarServiceInter thirdbarServiceInter) {
		this.thirdbarServiceInter = thirdbarServiceInter;
	}



	public String gotoshouye(){
		
		List kecheng=thirdbarServiceInter.getthirdbardesc(31, 8, 1);
		List carousel=wordServiceInter.getcarousel();
		request.setAttribute("carousel",carousel);
		request.setAttribute("kecheng",kecheng);
		return "gotoshouye";
	}

}
