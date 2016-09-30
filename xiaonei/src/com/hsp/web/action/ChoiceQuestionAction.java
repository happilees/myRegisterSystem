package com.hsp.web.action;

import com.hsp.domain.*;
import com.hsp.service.Inter.ExamOnlineServiceInter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhanhengkitt on 2015/12/22.
 */
public class ChoiceQuestionAction {

    private Exam exam;

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    private Choice choice;

    public Choice getChoice() {
        return choice;
    }
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    private List<Choice> choiceList;
    @JSON(serialize = false)
    public List<Choice> getChoiceList() {
        return choiceList;
    }
    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();


    @Resource
    private ExamOnlineServiceInter examOnlineServiceInter;

    @JSON(serialize = false)
    public ExamOnlineServiceInter getExamOnlineServiceInter() {
        return examOnlineServiceInter;
    }

    public void setExamOnlineServiceInter(
            ExamOnlineServiceInter examOnlineServiceInter) {
        this.examOnlineServiceInter = examOnlineServiceInter;
    }

    //增加选择题
   /*public String addChooses() {
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        choiceList = (List)exam.getAnswers();
        int choiceNo = choiceList.size() + 1;//choiceNO加一
        System.out.println(choiceNo);
        choice.setExam(exam);
        choice.setChoiceNo(choiceNo);
        examOnlineServiceInter.save(choice);
        Object[] obj = {exam};
        choiceList = examOnlineServiceInter.getResult("from Choice choice where choice.exam = ?",obj);
        choiceList.add(choice);
        return "addChooses";
    }*/
    public String addChooses() {
        Object[] examId = {exam.getId()};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?", examId);
        Object[] examobj = {exam};
        List choiceNo = examOnlineServiceInter.getResult("select count(*) from Choice c where c.exam = ?", examobj);//choiceNO加一
        choice.setExam(exam);
        Integer count = Integer.parseInt(choiceNo.get(0).toString())+1;
        //System.out.println(count);
        choice.setChoiceNo(count);
        examOnlineServiceInter.save(choice);
        /*Object[] objects = {choice.getId()};
        choice = (Choice)examOnlineServiceInter.uniqueQuery("from Choice choice where choice.id = ?",objects);
        //System.out.println("success");*/
        choice.setExam(null);//去除多余数据，否则会附带很多信息
        choice.setAnswers(null);
        return "addChooses";
    }

    public String updateChoice(){
        exam = (Exam)examOnlineServiceInter.findById(Exam.class,exam.getId());
        choice.setExam(exam);
        examOnlineServiceInter.update(choice);
        choice.setExam(null);
        choice.setAnswers(null);
        return "addChooses";
    }

    //删除选择题
/*
    public String deleteChoice(){
        String examIdStr = request.getParameter("examId");
        Object[] examId = {Integer.parseInt(examIdStr)};
        exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id=?",examId);

        String choicesId = request.getParameter("choiceNo");
        Object[] choices = {exam,Integer.parseInt(choicesId)};
        choice = (Choice)examOnlineServiceInter.uniqueQuery("from Choice choice where choice.exam=? and choice.id = ?",choices);
        examOnlineServiceInter.delete(choice);
       *//* Object[] obj = {exam};
        choiceList = examOnlineServiceInter.getResult("from Choice choice where choice.exam = ?",obj);
*//*
        return "deleteChoice";
    }*/

}


