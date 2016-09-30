package com.hsp.web.action;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsp.domain.*;
import com.hsp.util.ChangeType;
import com.hsp.util.PullOutUtils;
import com.hsp.util.datetime;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import com.hsp.service.Inter.ExamOnlineServiceInter;
import org.apache.struts2.json.annotations.JSON;


import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.server.ObjID;
import java.util.*;

public class ExamOnlineAction extends ActionSupport{

	private Score score;
	private List<Score> scoreList;
	private Student student;
	private List<Student> studentList;
	private Exam exam;
	private List<Exam> exams;
	private Fillblank fillblank;
	private List<Fillblank> fillblanksList;
	private Essay essay;
	private List<Essay> essayList;
	private Choice choice;
	private Torfquestions torfquestions;
	private List<Torfquestions> torfquestionsList;

	//各种getset方法

	public List<Student> getStudentList() {return studentList;}
	public void setStudentList(List<Student> studentList) {this.studentList = studentList;}

	public Student getStudent() {return student;}
	public void setStudent(Student student) {this.student = student;}

	public List<Score> getScoreList() {return scoreList;}
	public void setScoreList(List<Score> scoreList) {this.scoreList = scoreList;}

	public Score getScore() {return score;}
	public void setScore(Score score) {this.score = score;}

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
	public Fillblank getFillblank() {
		return fillblank;
	}
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
	public void setExamOnlineServiceInter(ExamOnlineServiceInter examOnlineServiceInter) {
		this.examOnlineServiceInter = examOnlineServiceInter;
	}


	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();


	//展示试卷
	public String showExam(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		exams = examOnlineServiceInter.getResult("from Exam", null);
		exams.remove(0);
		return "showExam";
		}
		else{
			return "userloginfail";
		}
	}
	//2016118add
	//删除所有学生在线考试成绩
	public String deleteStudentOnlineScore(){
		List<Answer1> answer1 = examOnlineServiceInter.getResult("from Answer1",null);

		for(Answer1 a:answer1){
			examOnlineServiceInter.delete(a);
		}
		return "showOnlineTestStudent";
	}

	//2016118add
	//删除所有学生成绩
	public String deleteAllStudent(){
		Exam deleteExam = (Exam)examOnlineServiceInter.findById(Exam.class,exam.getId());
		System.out.println(deleteExam.getExamName());

		Iterator i = deleteExam.getAnswers().iterator();
		while(i.hasNext()){
			examOnlineServiceInter.delete(i.next());
		}
		Iterator k = deleteExam.getScores().iterator();
		while(k.hasNext()){
			examOnlineServiceInter.delete(k.next());
		}
		return "deleteAllStudent";
	}
	//跳转到提交列表
	public String submitList(){
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null)
		{
		exams = examOnlineServiceInter.getResult("from Exam", null);
		return "submitList";
		}
		else{
			return "userloginfail";
		}
	}

	//写文件
	public StringBuffer writeText(Exam exam,List<Student> studentList){
		StringBuffer stringBuffer = new StringBuffer();
		try {

			List<Integer> eachScore = new ArrayList();
			List<List<Integer>> allScore = new ArrayList();
			List<Integer> eachMax = new ArrayList();

			for (Student s : studentList) {
                Object[] obj = {s, exam};
                System.out.println("学生" + s.getStudentName());
                eachScore = examOnlineServiceInter.getResult("select score.score from Score score where score.student = ? and score.exam = ?", obj);
                allScore.add(eachScore);

            }
			int max = 0;
			//寻找最高分
			for (int i = 0; i < allScore.size(); i++) {
                max = findmax(allScore.get(i));
                eachMax.add(max);
            }


			for (int i = 0; i < studentList.size(); i++) {
                float sum = 0;
                float avg = 0;
                System.out.println("学生姓名" + studentList.get(i).getStudentName());
                stringBuffer.append("学号：" + studentList.get(i).getStudentNo() + "\t" + "班级：" + studentList.get(i).getClassName() +
                        "姓名：" + studentList.get(i).getStudentName() + "\r\n");
                for (int k = 0; k < allScore.get(i).size(); k++) {
                    stringBuffer.append("第" + (k + 1) + "次成绩：" + allScore.get(i).get(k) + "\t");
                    sum += allScore.get(i).get(k);

                }
                avg = sum / allScore.get(i).size();

                System.out.println(stringBuffer);
                stringBuffer.append("\r\n");
                stringBuffer.append("最高分：" + eachMax.get(i) + "\t");
                stringBuffer.append("平均分：" + String.format("%.2f", avg));
                stringBuffer.append("\r\n\r\n");


            }
			System.out.println(stringBuffer);
			return stringBuffer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public String pulloutTest() throws IOException,ServletException{
		String examidStr = request.getParameter("examId");
		exam = examOnlineServiceInter.findExamByExamIdStr(examidStr);
		String className = request.getParameter("className");
		if(className.equals("allStudent")){
			Object[] examObj = {exam};
			List<Student> studentList = examOnlineServiceInter.getResult("select distinct score.student from Score score where score.exam = ?  order by score.student.className asc , score.student asc group by score.student.className",examObj);
			String realpath = ServletActionContext.getServletContext().getRealPath("/");//获取项目根目录
			PullOutUtils.pullOut(writeText(exam, studentList), realpath + "/studentScore/" + className + ".txt");
			request.setAttribute("className", className);
			request.getRequestDispatcher("/examOnline/FileDownLoad.action?number=1").forward(request, response);
			return null;
		}
		else {
			Object[] classNameObj = {exam, className};
			List<Student> studentList = examOnlineServiceInter.getResult("select distinct score.student from Score score where score.exam = ? and score.student.className = ? order by score.student asc ", classNameObj);
			String realpath = ServletActionContext.getServletContext().getRealPath("/");//获取项目根目录
			PullOutUtils.pullOut(writeText(exam, studentList), realpath + "/studentScore/" + className + ".txt");
			request.setAttribute("className", className);
			request.getRequestDispatcher("/examOnline/FileDownLoad.action?number=1").forward(request, response);
			return null;
		}

	}
	//根据学生班级查找成绩
	public String findClassName() throws IOException{
			String examidStr = request.getParameter("examId");
			exam = examOnlineServiceInter.findExamByExamIdStr(examidStr);
			String className = request.getParameter("className");
			Object[] classNameObj = {exam, className};
			Object[] examObj = {exam};
			List<String> classNameList = examOnlineServiceInter.getResult("select distinct s.student.className from Score s where s.exam = ? order by score.student.className asc", examObj);
			List<Student> studentList = examOnlineServiceInter.getResult("select distinct score.student from Score score where score.exam = ? and score.student.className = ? order by score.student asc ", classNameObj);
			getEachScore(studentList);
			request.setAttribute("classList", classNameList);
			request.setAttribute("className",className);
			return "studentsScore";
	}


	public void getEachScore(List<Student> studentList){
		List<Integer> eachScore = new ArrayList();
		List<List<Integer>> eachAllScore = new ArrayList();
		List<Integer> eachMax = new ArrayList();
		if(studentList.size()!=0) {
			for (Student s : studentList) {
				Object[] obj = {s, exam};
				eachScore = examOnlineServiceInter.getResult("select score.score from Score score where score.student = ? and score.exam = ?", obj);
				eachAllScore.add(eachScore);
			}
			Integer max = 0;
			//寻找最高分
			for (int i = 0; i < eachAllScore.size(); i++) {
				max = findmax(eachAllScore.get(i));
				eachMax.add(max);
			}

			request.setAttribute("eachMax", eachMax);
			request.setAttribute("eachAllScore", eachAllScore);
			request.setAttribute("studentList", studentList);
		}
	}
	//跳转到学生成绩
	public String studentsScore(){
		String examidStr = request.getParameter("examId");
		exam = examOnlineServiceInter.findExamByExamIdStr(examidStr);
		Object[] examObj = {exam};
		//groud by class and order by className and studentId
		List<Student> studentList = examOnlineServiceInter.getResult("select distinct score.student from Score score where score.exam = ?  order by score.student.className asc , score.student asc group by score.student.className",examObj);
		List<String> classNameList = examOnlineServiceInter.getResult("select distinct s.student.className from Score s where s.exam = ? ",examObj);
		getEachScore(studentList);
		request.setAttribute("classList", classNameList);
		String className = "allStudent";
		request.setAttribute("className",className);

		return "studentsScore";
	}

	public int findmax(List scores){
		int max = (Integer)scores.get(0);
		for (int i= 0;i<scores.size();i++){
			if(max<(Integer)scores.get(i)){
				max = (Integer)scores.get(i);
			}

		}
		return max;
	}



	//用set集合得到随机试卷
	public void getAllQuestion(Exam exam){
		Set<Choice> choiceSet = exam.getChoices();
		//将SET转化为List
		List<Choice> choiceList = new ArrayList<Choice>(choiceSet);
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

		//填空题排序
		Set<Fillblank> fillblankSet = exam.getFillblanks();
		fillblanksList = new ArrayList<Fillblank>(fillblankSet);
		Collections.sort(fillblanksList, new Comparator<Fillblank>() {
			public int compare(Fillblank arg0, Fillblank arg1) {
				return arg0.getFillBlankNo().compareTo(arg1.getFillBlankNo());
			}
		});

		//简答题排序
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

	public String pulloutScore(){
		String str = request.getParameter("pulloutScore");
		System.out.println("parameter"+str);
		List<Student> ss = (List<Student>)request.getAttribute("pulloutScore");
		if(ss.size()!=0) {
			for (Student s : ss) {
				System.out.println("student:" + s.getStudentName());
			}
		}
		return "addTrueOrFalse";

	}


	//跳转到增加问题的页面
	public String forwardAddQuestion(){
		String examId = request.getParameter("examId");
		Integer[] id = {Integer.parseInt(examId)};
		exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam where id = ?",id);
		getAllQuestion(exam);
		return "forwardAddQuestion";
	}

	//增加试卷
	public String addExam(){
		//Date date = new Date();
		//String dateFormage =datetime.formateDateTime(date);
		examOnlineServiceInter.save(exam);
		Object[] obj = {exam.getId()};
		/*exams = examOnlineServiceInter.getResult("from Exam exam where exam.id = ?",null);*/
		exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ? order by id",obj);
		return "addExam";
	}

	//删除试卷
	public String deleteExam(){
		String examIdStr = request.getParameter("examId");
		Object[] examId = {Integer.parseInt(examIdStr)};
		exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam where id = ?",examId);
		examOnlineServiceInter.delete(exam);
		return "deleteExam";
	}

	//跳转到编辑试卷页面
	public String updateExam(){
		List<Exam> exams = examOnlineServiceInter.getResult("from Exam",null);
		System.out.println(exams);
		return "findExam";
	}

	//修改是否开考
	public String updateIsStartExam(){
		String examIdStr = request.getParameter("examId");
		String isStartStr = request.getParameter("isStart");
		/*System.out.println(examIdStr);
		System.out.println(examIdStr);*/
		Object[] a = {ChangeType.changeStrToInt(examIdStr)};
		exam = (Exam)examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id = ?",a);
		//System.out.println(exam);
		exam.setIsStart(Integer.parseInt(isStartStr));
		if(exam.getIsStart()==1){
			exam.setIsStart(0);
		}else if(exam.getIsStart()==0){
			exam.setIsStart(1);
		}
		examOnlineServiceInter.update(exam);
		exams = examOnlineServiceInter.getResult("from Exam",null);
		exams.remove(0);
		return "showExam";
	}


	//删除填空题
	public String deleteFillBlank(){
		String examIdStr = request.getParameter("examId");
		Object[] examId = {Integer.parseInt(examIdStr)};
		exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id=?",examId);
		String questionNo = request.getParameter("questionNo");
		Object[] questions = {exam,Integer.parseInt(questionNo)};
		fillblank = (Fillblank)examOnlineServiceInter.uniqueQuery("from Fillblank t where t.exam=? and t.fillBlankNo = ?",questions);
		if(fillblank != null){
			examOnlineServiceInter.delete(fillblank);
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}else {
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}
	}
	//删除简答题
	public String deleteEssay(){
		String examIdStr = request.getParameter("examId");
		Object[] examId = {Integer.parseInt(examIdStr)};
		exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id=?",examId);
		String questionNo = request.getParameter("questionNo");
		Object[] questions = {exam,Integer.parseInt(questionNo)};
		essay = (Essay)examOnlineServiceInter.uniqueQuery("from Essay t where t.exam=? and t.essayNo = ?",questions);
		if(essay != null){
			examOnlineServiceInter.delete(essay);
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}else {
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}

	}

	//删除判断题
	public String deleteTrueOrFalse(){
		String examIdStr = request.getParameter("examId");
		Object[] examId = {Integer.parseInt(examIdStr)};
		exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id=?",examId);
		String questionNo = request.getParameter("questionNo");
		Object[] questions = {exam,Integer.parseInt(questionNo)};
		torfquestions = (Torfquestions)examOnlineServiceInter.uniqueQuery("from Torfquestions t where t.exam=? and t.questionNo = ?",questions);
		if(torfquestions != null){
			examOnlineServiceInter.delete(torfquestions);
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}else {
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}

	}
	//删除选择题
	public String deleteChoice() throws IOException{
		String examIdStr = request.getParameter("examId");
		Object[] examId = {Integer.parseInt(examIdStr)};
		exam = (Exam) examOnlineServiceInter.uniqueQuery("from Exam exam where exam.id=?",examId);
		String choicesId = request.getParameter("choiceNo");
		Object[] choices = {exam,Integer.parseInt(choicesId)};
		choice = (Choice)examOnlineServiceInter.uniqueQuery("from Choice choice where choice.exam=? and choice.id = ?",choices);
		if(choice != null){
			Iterator i = choice.getAnswers().iterator();
			while(i.hasNext()){
				examOnlineServiceInter.delete(i.next());
			}
			examOnlineServiceInter.delete(choice);
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}else {
			getAllQuestion(exam);
			return "forwardAddQuestion";
		}
	}
	//add
	//找出参加在线考试的学生
	public String  findOnlineTestStudent(){
		//不重复查找
		studentList = examOnlineServiceInter.getResult("select distinct answer1.student from Answer1 answer1",null);
		return "showOnlineTestStudent";

	}

	//找出对应学生的在线测试的试卷
	public String findOnlineTestFlag() {
		String studentId = request.getParameter("studentId");
		Object[] id = {Integer.parseInt(studentId)};
		student = (Student) examOnlineServiceInter.uniqueQuery("from Student student where student.id = ?", id);
		Object[] obj = {student};
		List<Integer> flags = examOnlineServiceInter.getResult(" select distinct answer1.flag from Answer1 answer1 where answer1.student = ? ", obj);
		request.setAttribute("flagList", flags);
		return "findOnlineTestFlag";
	}

	//跳转到学生做过的试卷
	public String findOnlineTest(){
		String studentId = request.getParameter("studentId");
		Object[] id = {Integer.parseInt(studentId)};
		String flag = request.getParameter("flag");
		student = (Student) examOnlineServiceInter.uniqueQuery("from Student student where student.id = ?", id);
		Object[] obj = {student,Integer.parseInt(flag)};
		List<Answer1> answer1 = examOnlineServiceInter.getResult("from Answer1 answer1 where student = ? and flag = ?", obj);
		List<Choice> choiceList = new ArrayList();
		List<Torfquestions> torfquestionsList = new ArrayList();
		List<Fillblank> fillblanksList = new ArrayList();
		List<Essay> essayList = new ArrayList();
  		List<String> studentChoice = new ArrayList();
		List<String> studentTorf = new ArrayList();
		List<String> studentFillBlank = new ArrayList();
		List<String> studentEssay = new ArrayList();
		int sum = 0;
		for(Answer1 a : answer1){
			if(a.getTypeName().equals("choice")){
				Object[] questionId = {a.getQuestionId()};
				choice = (Choice) examOnlineServiceInter.uniqueQuery("from Choice choice where choice.id=?",questionId);
				choiceList.add(choice);
				studentChoice.add(a.getStudentResult());
				if(choice.getResult().equals(a.getStudentResult())){
					sum = sum + 5;//选择题分值
				}
			}else if(a.getTypeName().equals("trueOrFalses")){
				Object[] questionId = {a.getQuestionId()};
				torfquestions = (Torfquestions) examOnlineServiceInter.uniqueQuery("from Torfquestions t where t.id=?",questionId);
				torfquestionsList.add(torfquestions);
				studentTorf.add(a.getStudentResult());
				if(torfquestions.getResult().toString().equals(a.getStudentResult())){
					sum = sum + 2;//判断题题分值
				}
			}else if(a.getTypeName().equals("fillBlanks")){
				Object[] questionId = {a.getQuestionId()};
				fillblank = (Fillblank) examOnlineServiceInter.uniqueQuery("from Fillblank t where t.id=?",questionId);
				fillblanksList.add(fillblank);
				studentFillBlank.add(a.getStudentResult());
			}else if(a.getTypeName().equals("essays")){
				Object[] questionId = {a.getQuestionId()};
				essay = (Essay) examOnlineServiceInter.uniqueQuery("from Essay t where t.id=?",questionId);
				essayList.add(essay);
				studentEssay.add(a.getStudentResult());
			}
		}
		request.setAttribute("choiceList",choiceList);
		request.setAttribute("torfList",torfquestionsList);
		request.setAttribute("fillBlankList",fillblanksList);
		request.setAttribute("essayList",essayList);
		request.setAttribute("sum",sum);
		request.setAttribute("studentChoice",studentChoice);
		request.setAttribute("studentTorf",studentTorf);
		request.setAttribute("studentFillBlank",studentFillBlank);
		request.setAttribute("studentEssay",studentEssay);
		return "showOnlineTest";

	}


}