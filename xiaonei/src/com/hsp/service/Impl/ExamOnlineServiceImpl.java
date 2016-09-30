package com.hsp.service.Impl;

import com.hsp.baseService.BaseServiceImpl;
import com.hsp.domain.Exam;
import com.hsp.service.Inter.ExamOnlineServiceInter;

public class ExamOnlineServiceImpl extends BaseServiceImpl implements ExamOnlineServiceInter{

	public Exam findExamByExamIdStr(String examIdStr){
        Object[] obj = {Integer.parseInt(examIdStr)};
        return (Exam)this.uniqueQuery("from Exam exam where exam.id = ?",obj);
    }
}
