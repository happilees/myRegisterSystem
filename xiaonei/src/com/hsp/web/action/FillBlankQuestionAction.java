package com.hsp.web.action;

import com.hsp.domain.Exam;
import com.hsp.domain.Fillblank;
import com.hsp.service.Inter.ExamOnlineServiceInter;
import org.apache.struts2.json.annotations.JSON;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhanhengkitt on 2015/12/26.
 */
public class FillBlankQuestionAction {
    private ExamOnlineServiceInter examOnlineServiceInter;
    @JSON(serialize=false)
    public ExamOnlineServiceInter getExamOnlineServiceInter() {
        return examOnlineServiceInter;
    }
    public void setExamOnlineServiceInter(ExamOnlineServiceInter examOnlineServiceInter) {
        this.examOnlineServiceInter = examOnlineServiceInter;
    }

    private  Exam exam;

    @JSON(serialize = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    private Fillblank fillblank;
    private List<Fillblank> fillblankList;


    public Fillblank getFillblank() {
        return fillblank;
    }

    public void setFillblank(Fillblank fillblank) {
        this.fillblank = fillblank;
    }

    @JSON(serialize=false)
    public List<Fillblank> getFillblankList() {
        return fillblankList;
    }
    public void setFillblankList(List<Fillblank> fillblankList) {
        this.fillblankList = fillblankList;
    }

   /* public String addFillBlank(){
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        int fillBlankNo = exam.getFillblanks().size() + 1;//NO加一
        fillblank.setExam(exam);
        fillblank.setFillBlankNo(fillBlankNo);
        examOnlineServiceInter.save(fillblank);
       *//* Object[] obj = {exam ,choiceNo};
        choice = (Choice)examOnlineServiceInter.uniqueQuery("from Choice choice where choice.exam = ? and choice.choiceNo=?",obj);*//*
        Object[] obj = {exam};
        fillblankList = examOnlineServiceInter.getResult("from Fillblank fillblank where fillblank.exam = ?",obj);
        return "addFillBlank";
    }*/

    public String addFillBlank(){
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        Object[] examobj = {exam};
        List fillBlankNo = examOnlineServiceInter.getResult("select count(*) from Fillblank c where c.exam = ?", examobj);//essayNO加一
        fillblank.setExam(exam);
        Integer count = Integer.parseInt(fillBlankNo.get(0).toString())+1;
        fillblank.setFillBlankNo(count);
        examOnlineServiceInter.save(fillblank);
        fillblank.setExam(null);//去除多余数据，否则会附带很多信息
        return "addFillBlank";
    }

    public String updateFillBlank(){
        exam = (Exam)examOnlineServiceInter.findById(Exam.class,exam.getId());
        fillblank.setExam(exam);
        examOnlineServiceInter.update(fillblank);
        fillblank.setExam(null);
        return "addFillBlank";
    }
}
