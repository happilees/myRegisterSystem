package com.hsp.web.action;

import com.hsp.domain.Exam;
import com.hsp.domain.Torfquestions;
import com.hsp.service.Inter.ExamOnlineServiceInter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhanhengkitt on 2015/12/26.
 */
public class TureOrFalseQuestionAction {
    private Exam exam;
    private Torfquestions torfquestions;
    private List<Torfquestions> torfquestionses;
    @JSON(serialize = false)
    public List<Torfquestions> getTorfquestionses() {
        return torfquestionses;
    }

    public void setTorfquestionses(List<Torfquestions> torfquestionses) {
        this.torfquestionses = torfquestionses;
    }

    @JSON(serialize = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }


    public Torfquestions getTorfquestions() {
        return torfquestions;
    }

    public void setTorfquestions(Torfquestions torfquestions) {
        this.torfquestions = torfquestions;
    }

    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();

    @Resource
    private ExamOnlineServiceInter examOnlineServiceInter;
    @JSON(serialize = false)
    public ExamOnlineServiceInter getExamOnlineServiceInter(){
        return examOnlineServiceInter;
    }
    public void setExamOnlineServiceInter(
            ExamOnlineServiceInter examOnlineServiceInter) {
        this.examOnlineServiceInter = examOnlineServiceInter;
    }

   /* public String addTrueOrFalse(){
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?",examId);

        int torfNo = exam.getTorfquestionses().size()+1;
        torfquestions.setQuestionNo(torfNo);
        torfquestions.setExam(exam);
        examOnlineServiceInter.save(torfquestions);
        Object[] obj = {exam};
        torfquestionses = examOnlineServiceInter.getResult("from Torfquestions t where t.exam = ?",obj);
        *//*Object[] obj = {exam,torfNo};*//*
        *//*torfquestions = (Torfquestions)examOnlineServiceInter.uniqueQuery("from Torfquestions t where t.exam = ? and t.questionNo = ?",obj);*//*
        return "addTrueOrFalse";
    }*/
    public String addTrueOrFalse(){
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        Object[] examobj = {exam};
        List torfNo = examOnlineServiceInter.getResult("select count(*) from Torfquestions c where c.exam = ?", examobj);//essayNO加一
        torfquestions.setExam(exam);
        Integer count = Integer.parseInt(torfNo.get(0).toString())+1;
        torfquestions.setQuestionNo(count);
        examOnlineServiceInter.save(torfquestions);
        torfquestions.setExam(null);//去除多余数据，否则会附带很多信息
        return "addTrueOrFalse";
    }


    public String updateTrueOrFalse(){
        exam = (Exam)examOnlineServiceInter.findById(Exam.class,exam.getId());
        torfquestions.setExam(exam);
        examOnlineServiceInter.update(torfquestions);
        torfquestions.setExam(null);
        return "addTrueOrFalse";
    }
}
