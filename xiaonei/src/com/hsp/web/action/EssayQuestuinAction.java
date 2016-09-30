package com.hsp.web.action;

import com.hsp.domain.Essay;
import com.hsp.domain.Exam;
import com.hsp.service.Inter.ExamOnlineServiceInter;
import org.apache.struts2.json.annotations.JSON;

import java.util.List;

/**
 * Created by zhanhengkitt on 2015/12/26.
 */
public class EssayQuestuinAction {
    private ExamOnlineServiceInter examOnlineServiceInter;

    @JSON(serialize=false)
    public ExamOnlineServiceInter getExamOnlineServiceInter() {
        return examOnlineServiceInter;
    }

    public void setExamOnlineServiceInter(ExamOnlineServiceInter examOnlineServiceInter) {
        this.examOnlineServiceInter = examOnlineServiceInter;
    }

    private Exam exam;
    private Essay essay;
    private List<Essay> essayList;


    public Essay getEssay() {
        return essay;
    }

    public void setEssay(Essay essay) {
        this.essay = essay;
    }

    @JSON(serialize = false)
    public List<Essay> getEssayList() {
        return essayList;
    }

    public void setEssayList(List<Essay> essayList) {
        this.essayList = essayList;
    }

    @JSON(serialize = false)
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    /*public String addEssay(){
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        int essayNo = exam.getEssaies().size()+1;
        essay.setExam(exam);
        essay.setEssayNo(essayNo);
        examOnlineServiceInter.save(essay);
        Object[] objects = {exam};
        essayList = examOnlineServiceInter.getResult("from Essay e where e.exam = ?",objects);
        return "addEssay";
    }*/

    public String addEssay(){
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        Object[] examobj = {exam};
        List essayNo = examOnlineServiceInter.getResult("select count(*) from Essay c where c.exam = ?", examobj);//essayNO加一
        essay.setExam(exam);
        Integer count = Integer.parseInt(essayNo.get(0).toString())+1;
        essay.setEssayNo(count);
        examOnlineServiceInter.save(essay);
        essay.setExam(null);//去除多余数据，否则会附带很多信息
        return "addEssay";
    }

    public String updateEssay(){
        exam = (Exam)examOnlineServiceInter.findById(Exam.class,exam.getId());
        essay.setExam(exam);
        examOnlineServiceInter.update(essay);
        essay.setExam(null);
        return "addEssay";
    }
}
