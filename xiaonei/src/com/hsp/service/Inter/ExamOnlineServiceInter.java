package com.hsp.service.Inter;

import com.hsp.baseService.BaseServiceInter;
import com.hsp.domain.Exam;

public interface ExamOnlineServiceInter extends BaseServiceInter{

    public Exam findExamByExamIdStr(String examIdStr);

	

}
