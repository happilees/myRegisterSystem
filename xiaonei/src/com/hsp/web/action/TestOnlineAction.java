package com.hsp.web.action;

import com.hsp.domain.*;
import com.hsp.service.Inter.ExamOnlineServiceInter;
import com.hsp.util.datetime;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by zhanhengkitt on 2015/12/26.
 */
public class TestOnlineAction {

    private Student student;
    private List<Choice> choiceList;
    private Exam exam;
    private List<Exam> exams;
    private Fillblank fillblank;
    private List<Fillblank> fillblanksList;
    private Essay essay;
    private List<Essay> essayList;
    private Choice choice;
    private Torfquestions torfquestions;
    private List<Torfquestions> torfquestionsList;
    private Answer answer;
    private Score score;

    public Answer getAnswer() {return answer;}
    public void setAnswer(Answer answer) {this.answer = answer;}

    public Score getScore() {return score;}
    public void setScore(Score score) {this.score = score;}

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }
    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }


    //@JSON(serialize = false)
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }


    @JSON(serialize = false)
    public List<Exam> getExams() {
        return exams;
    }
    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


    @JSON(serialize = false)
    public Fillblank getFillblank() {return fillblank;}
    public void setFillblank(Fillblank fillblank) {
        this.fillblank = fillblank;
    }

    //填空题
    @JSON(serialize = false)
    public List<Fillblank> getFillblanksList() {
        return fillblanksList;
    }
    public void setFillblanksList(List<Fillblank> fillblanksList) {
        this.fillblanksList = fillblanksList;
    }

    //简答题
    @JSON(serialize = false)
    public List<Essay> getEssayList() {
        return essayList;
    }
    public void setEssayList(List<Essay> essayList) {
        this.essayList = essayList;
    }

    @JSON(serialize = false)
    public Essay getEssay() {
        return essay;
    }
    public void setEssay(Essay essay) {
        this.essay = essay;
    }

    //选择题
    @JSON(serialize = false)
    public Choice getChoice() {
        return choice;
    }
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    //判断题
    @JSON(serialize = false)
    public Torfquestions getTorfquestions() {return torfquestions;}
    public void setTorfquestions(Torfquestions torfquestions) {this.torfquestions = torfquestions;}


    @JSON(serialize = false)
    public List<Torfquestions> getTorfquestionsList() {
        return torfquestionsList;
    }
    public void setTorfquestionsList(List<Torfquestions> torfquestionsList) {
        this.torfquestionsList = torfquestionsList;
    }


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


    private HttpServletRequest request = ServletActionContext.getRequest();
    private HttpServletResponse response = ServletActionContext.getResponse();

    //在线考试展示问题
    public String showOnlineTestQuestion(){
        //getRandomQuestion(10,5,5,5);
        getRandomChoice("from Choice",null,10);
        getRandomEssay("from Essay",5);
        getRandomTureOrFalse("from Torfquestions",5);
        getRandomFillblank("from Fillblank",5);
        return "showOnlineTestQuestion";
    }



    public String getAnswers(){

        List<String> answer = new ArrayList();
        List<String> choiceIdStr = new ArrayList();
        String str = null;
        String[] fenkai = null;
        for(int i=1;i<=20;i++){
            str = request.getParameter("answer"+i);
            if(str!=null) {
                fenkai = str.split("#");
                System.out.println(str);
                System.out.println(fenkai[0]);
                System.out.println(fenkai[1]);
                answer.add(fenkai[0]);
                choiceIdStr.add(fenkai[1]);
            }else{
                answer.add(str);
                choiceIdStr.add(str);
            }
        }
            return "getAnswer";
    }
  //课程测试  改
    public String courseTest(){
        student = (Student)request.getSession().getAttribute("student");
        //Object[] examId = {1};
        exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam e where e.id = 1 ", null);
        System.out.println(exam.getExamName());
        Object[] obj = {student, exam};
        List<Score>  courseTest= examOnlineServiceInter.getResult("from Score s where s.student = ? and s.exam = ?", obj);
        int havedTest = courseTest.size();//已经测试的次数
        if(havedTest>=5){
        	request.setAttribute("message","课程测试已超过五次！");
            return "chenggong";
        }else {
            int restCount = 5 - courseTest.size();
            getRandomChoice("from Choice", null, 20);
            request.setAttribute("restCount",restCount);
            return "courseTest";
        }
    }

  //展示章节试卷名称 改
    public String showCapterList(){
        student = (Student)request.getSession().getAttribute("student");
        List<Integer> maxList = new ArrayList();
        int max = 0;
        exams = examOnlineServiceInter.getResult("from Exam", null);
        //课程测试结果
        Object[] obj = {student, exams.get(0)};//找到课程测试
        List<Score>  courseTest= examOnlineServiceInter.getResult("from Score s where s.student = ? and s.exam = ?", obj);
        exams.remove(0);
        List<Score> scoreList = new ArrayList();
        
        for (Exam e : exams) {
            Object[] studentObj = {student, e};
            scoreList = examOnlineServiceInter.getResult("from Score s where s.student = ? and s.exam = ?", studentObj);
            if (scoreList.size() != 0) {
                max = scoreList.get(0).getScore();
                    //System.out.println("max"+max);
                for (int i = 0; i < scoreList.size(); i++) {
                    if (max < scoreList.get(i).getScore()) {
                        max = scoreList.get(i).getScore();
                    }
                }
                maxList.add(max);
            } else
                maxList.add(null);
        }


            for(Integer i : maxList){
                System.out.println(i+"最高分："+max);
            }

            System.out.println("coutseTest" + courseTest.size());

            request.setAttribute("courseTestScore",courseTest);

            request.setAttribute("max", maxList);
        if(courseTest.size()==0){
            return "showCapterList";
        }else {
            int havedTest = courseTest.size();//已经测试的次数
            int sum = 0;
            int maxCourse = 0;//add
            for (Score s : courseTest) {
                sum = sum + s.getScore();
            }

            //取最大值
            //add
            for (int i= 0;i<courseTest.size();i++){
                if(maxCourse<courseTest.get(i).getScore()){
                    maxCourse = courseTest.get(i).getScore();
                }

            }

            //findmax(courseTest);

            float avg = sum / courseTest.size();
            System.out.println("MaxCourse:"+maxCourse);
            System.out.println("haveTest:"+havedTest);
            System.out.println("average"+avg);
            request.setAttribute("havedTest", havedTest);
            request.setAttribute("average", avg);
            request.setAttribute("maxCourse",maxCourse);

        }
        return "showCapterList";
    }





  //展示试卷
    public String showExamList(){
        exams = examOnlineServiceInter.getResult("from Exam", null);
        exams.remove(0);
        return "showExamList";
    }

    
    //登录
    public String login(){
    	student=(Student)request.getSession().getAttribute("student");
    	if(student!=null)
    	{ 
    		return "login";
    		}
    	else
    	{
    		String flag=request.getParameter("flag");
			request.setAttribute("flag",flag);
        return "nologin";
        }
    }

    public void getRandomTureOrFalse(String hql,int trueOrFalseCount){
        torfquestionsList = examOnlineServiceInter.getResult(hql,null);
        Set<Torfquestions> torfquestionses = new HashSet(torfquestionsList);
        List showTrueOrFalse = new ArrayList();
        Iterator it = torfquestionses.iterator();
        for(int i = 0;i<trueOrFalseCount;i++){
            if(it.hasNext()) {
                torfquestions = (Torfquestions) it.next();
                showTrueOrFalse.add(torfquestions);
            }
        }
        request.setAttribute("showTrueOrFalse", showTrueOrFalse);

    }
    public void getRandomEssay(String hql,int essayCount){
        essayList = examOnlineServiceInter.getResult(hql,null);
        Set<Essay> essaySet = new HashSet(essayList);
        List showEssay = new ArrayList();
        Iterator it = essaySet.iterator();
        for(int i = 0;i<essayCount;i++){
            if(it.hasNext()){
                essay = (Essay)it.next();
                showEssay.add(essay);

            }

        }
        request.setAttribute("showEssay",showEssay);

    }
    public void getRandomFillblank(String hql,int fillBlankCount){
        fillblanksList = examOnlineServiceInter.getResult(hql,null);
        Set<Fillblank> fillblankSet = new HashSet(fillblanksList);
        List showFillBlank = new ArrayList();
        Iterator it = fillblankSet.iterator();
        for(int i = 0;i<fillBlankCount;i++){
            if(it.hasNext()) {
                fillblank = (Fillblank) it.next();
                showFillBlank.add(fillblank);
            }
        }
        request.setAttribute("showFillBlank",showFillBlank);
    }
    public void getRandomChoice(String hql,Object[] obj,int choiceCount){
        choiceList = examOnlineServiceInter.getResult(hql,obj);
        Set<Choice> choiceSet = new HashSet(choiceList);
        List showChoice = new ArrayList();
        Iterator it = choiceSet.iterator();
        for(int i = 0;i<choiceCount;i++){
            if(it.hasNext()) {
                choice = (Choice) it.next();
                showChoice.add(choice);
                //System.out.println("choiceId:" + choice.getId());
            }
        }
        request.setAttribute("showChoice", showChoice);

    }

    //得到所有的问题
    public void getAllQuestion(Exam exam){
        Set<Choice> choiceSet = exam.getChoices();
        //将SET转化为List
        choiceList = new ArrayList<Choice>(choiceSet);
		/*将list有序排列*/
        Collections.sort(choiceList, new Comparator<Choice>() {
            public int compare(Choice arg0, Choice arg1) {
                return arg0.getChoiceNo().compareTo(arg1.getChoiceNo()); // 按照题号排列
            }
        });


        //将判断题排序
        Set<Torfquestions> torfquestionses = exam.getTorfquestionses();
        torfquestionsList = new ArrayList<Torfquestions>(torfquestionses);
        Collections.sort(torfquestionsList, new Comparator<Torfquestions>() {
            public int compare(Torfquestions arg0, Torfquestions arg1) {
                return arg0.getQuestionNo().compareTo(arg1.getQuestionNo());
            }
        });

        Set<Fillblank> fillblankSet = exam.getFillblanks();
        fillblanksList = new ArrayList<Fillblank>(fillblankSet);
        Collections.sort(fillblanksList, new Comparator<Fillblank>() {
            public int compare(Fillblank arg0, Fillblank arg1) {
                return arg0.getFillBlankNo().compareTo(arg1.getFillBlankNo());
            }
        });

        Set<Essay> essaySet = exam.getEssaies();
        essayList = new ArrayList<Essay>(essaySet);
        Collections.sort(essayList, new Comparator<Essay>() {
            public int compare(Essay arg0, Essay arg1) {
                return arg0.getEssayNo().compareTo(arg1.getEssayNo());
            }
        });

        request.setAttribute("fillBlanksList", fillblanksList);
        request.setAttribute("essayList",essayList);
        request.setAttribute("torfquestionList", torfquestionsList);
        request.setAttribute("choiceList", choiceList);
    }
    //展示问题
    public String showQuestions(){
        String examId = request.getParameter("examId");
        Integer[] id = {Integer.parseInt(examId)};
        exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam where id = ?",id);
        getAllQuestion(exam);
        return "showQuestions";
    }




    //展示章节问题
    public String showCapterQuestion(){
        String examId = request.getParameter("examId");
        Integer[] id = {Integer.parseInt(examId)};
        exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam where id = ?",id);
        Object[] obj = {exam};
        getRandomChoice("from Choice choice where choice.exam = ?", obj, 10);
        return "showCapterQuestion";
    }

 
  //add

    public String showOnlineTestResult() throws IOException{
        onlineTestResult(5,2);
        return "onlineTest";
    }

  //在线考试  改1
    public void onlineTestResult(int choiceFenzhi,int torfFenzhi) throws IOException{
        int sum = 0;
        student = (Student)request.getSession().getAttribute("student");
        /*if(student == null){
            response.sendRedirect("/success.jsp");//tiaozhuan
        }else {*/
            List<Choice> choiceList = new ArrayList();
            List<Torfquestions> torfquestionsList = new ArrayList();
            List<Fillblank> fillblankList = new ArrayList();
            List<Essay> essayList = new ArrayList();
            List<String> studentChoice = new ArrayList();//学生选择题答案
            List<String> studentTorf = new ArrayList();//学生判断题答案
            List<String> studentFillBlank = new ArrayList();//学生填空题答案
            List<String> studentEssay = new ArrayList();//学生简答题答案
            Integer flag = 0;
            Object[] studentobj = {student};
            List<Integer> answerFlagList = examOnlineServiceInter.getResult("select answer.flag from Answer1 answer where answer.student = ?", studentobj);
            for(Integer answerFlag: answerFlagList){
                flag = answerFlag;
            }

            for (int i = 1; i <= 10; i++) {
                String choiceStr = request.getParameter("choice"+i);
                    studentChoice.add(choiceStr);
                    String choiceIdStr = request.getParameter("choiceId" + i);
                    Object[] obj = {Integer.parseInt(choiceIdStr)};
                    choice = (Choice) examOnlineServiceInter.uniqueQuery("from Choice choice where choice.id=?", obj);
                    choiceList.add(choice);
                    Answer1 answer1 = new Answer1();
                    answer1.setQuestionId(Integer.parseInt(choiceIdStr));
                    answer1.setStudent(student);
                    answer1.setStudentResult(choiceStr);
                    answer1.setTypeName("choice");
                    answer1.setFlag((flag + 1));
                    if (choiceStr.equals(choice.getResult())) {
                        sum = sum + choiceFenzhi;
                    }
                    examOnlineServiceInter.save(answer1);
               // }
            }
            for (int i = 1; i <= 5; i++) {
                Answer1 answer1 = new Answer1();
                String trueOrFalses = request.getParameter("trueOrFalses"+i);
                /*if(trueOrFalses == null){
                    response.sendRedirect("/success.jsp");
                    return;
                }else {*/
                    studentTorf.add(trueOrFalses);
                    String trueOrFalsesIdStr = request.getParameter("trueOrFalsesId" + i);
                    Object[] obj = {Integer.parseInt(trueOrFalsesIdStr)};
                    torfquestions = (Torfquestions) examOnlineServiceInter.uniqueQuery("From Torfquestions t where t.id = ?", obj);
                    //System.out.println("trueOrFalses"+i+":"+torfquestions.getId());

                    torfquestionsList.add(torfquestions);
                    answer1.setQuestionId(Integer.parseInt(trueOrFalsesIdStr));
                    answer1.setStudent(student);
                    answer1.setStudentResult(trueOrFalses);
                    answer1.setTypeName("trueOrFalses");
                    answer1.setFlag((flag + 1));
                    if (trueOrFalses.equals(torfquestions.getResult().toString())) {
                        sum = sum + torfFenzhi;
                    }
                    examOnlineServiceInter.save(answer1);
                //}
            }
            for (int i = 1; i <= 5; i++) {
                Answer1 answer1 = new Answer1();
                String fillBlanks = request.getParameter("fillBlanks" + i);
                /*if (fillBlanks == "") {
                    response.sendRedirect("/success.jsp");
                    return;
                } else {*/
                    String fillBlanksId = request.getParameter("fillBlanksId" + i);
                    studentFillBlank.add(fillBlanks);
                    Object[] obj = {Integer.parseInt(fillBlanksId)};
                    fillblank = (Fillblank) examOnlineServiceInter.uniqueQuery("from Fillblank f where f.id = ?", obj);
                    //System.out.println("fillblank"+i+":"+fillblank.getId());

                    fillblankList.add(fillblank);
                    answer1.setQuestionId(Integer.parseInt(fillBlanksId));
                    answer1.setStudent(student);
                    answer1.setStudentResult(fillBlanks);
                    answer1.setTypeName("fillBlanks");
                    answer1.setFlag((flag + 1));
                    examOnlineServiceInter.save(answer1);
              //  }
            }
            for (int i = 1; i <= 5; i++) {
                Answer1 answer1 = new Answer1();
                String essays = request.getParameter("essays"+i);
                /*if(essays == ""){
                    response.sendRedirect("/success.jsp");
                    return;
                }else {*/
                    String essaysId = request.getParameter("essaysId" + i);
                    studentEssay.add(essays);
                    Object[] obj = {Integer.parseInt(essaysId)};
                    essay = (Essay) examOnlineServiceInter.uniqueQuery("from Essay f where f.id = ?", obj);
                    //System.out.println("essay"+i+":"+essay.getId());

                    essayList.add(essay);
                    answer1.setQuestionId(Integer.parseInt(essaysId));
                    answer1.setStudent(student);
                    answer1.setStudentResult(essays);
                    answer1.setTypeName("essays");
                    answer1.setFlag((flag + 1));
                    examOnlineServiceInter.save(answer1);
               // }
            //}
            //sum = choicefen+torffen;
            request.setAttribute("choiceList",choiceList);
            request.setAttribute("studentChoice",studentChoice);
            request.setAttribute("torfList",torfquestionsList);
            request.setAttribute("studentTorf",studentTorf);
            request.setAttribute("fillBlankList",fillblankList);
            request.setAttribute("studentFillBlank",studentFillBlank);
            request.setAttribute("essayList",essayList);
            request.setAttribute("studentEssay",studentEssay);
            request.setAttribute("sum",sum);
        }
    }

    
    
  //改1
    public void calculateZongfen(int tiMuCount,int fenzhi) throws IOException{
        student = (Student)request.getSession().getAttribute("student");
        /*if(student == null){
            response.sendRedirect("/success.jsp");
        }else {*/
            Object[] obj = {exam.getId()};
            exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam where id = ?", obj);
            List<String> answerList = new ArrayList();
            List<String> choiceIdStr = new ArrayList();
            List<Choice> choiceList = new ArrayList();
            String str = null;
            String[] fenkai = null;
            Integer flag = 0;
            Object[] studentobj = {student};
            List<Integer> answerFlagList = examOnlineServiceInter.getResult("select answer.flag from Answer answer where answer.student = ?", studentobj);
            for(Integer answerFlag: answerFlagList){
                flag = answerFlag;
            }
            int sum = 0;
            for (int i = 1; i <= tiMuCount; i++) {
                str = request.getParameter("answer" + i);
                System.out.println("answer"+i+":"+str);
                /*if(str == null){
                    response.sendRedirect("/success.jsp");
                    return;
                }*/
                if (str != null) {
                    fenkai = str.split("#");
                    Object[] id = {Integer.parseInt(fenkai[1])};
                    choice = (Choice) examOnlineServiceInter.uniqueQuery("from Choice choice where choice.id = ?", id);
                    Answer answer1 = new Answer();
                    answer1.setChoice(choice);
                    answer1.setStudent(student);
                    answer1.setExam(exam);
                    answer1.setStudentResult(fenkai[0]);
                    answer1.setTypeName("choice");
                    answer1.setFlag(flag+1);
                    if (fenkai[0].equals(choice.getResult())) {
                        sum += fenzhi;
                    }
                    examOnlineServiceInter.save(answer1);
                    answerList.add(fenkai[0]);
                    choiceList.add(choice);
              //  }

            }
            }
            Score score1 = new Score();
            score1.setStudent(student);
            score1.setScore(sum);
            score1.setAddTime(Timestamp.valueOf(datetime.formateDateTime(new Date())));
                    score1.setExam(exam);
            examOnlineServiceInter.save(score1);
            request.setAttribute("answer", answerList);
            request.setAttribute("choiceList", choiceList);
            request.setAttribute("score", sum);
            System.out.println("zongfen" + sum);
        }
    

  //计算课程测试成绩
    public String calculateCourseScore() throws IOException{
        calculateZongfen(20,5);
        return "calculatScore";
    }

    //计算章节测试的成绩
    public String calculatScore() throws IOException{
        calculateZongfen(10,10);
        return "calculatScore";
    }


}