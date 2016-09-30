package com.hsp.domain;



/**
 * Fillblank entity. @author MyEclipse Persistence Tools
 */

public class Fillblank  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Exam exam;
     private String question;
     private String answer;
     private Integer fillBlankNo;


    // Constructors

    /** default constructor */
    public Fillblank() {
    }

	/** minimal constructor */
    public Fillblank(Exam exam, String question, Integer fillBlankNo) {
        this.exam = exam;
        this.question = question;
        this.fillBlankNo = fillBlankNo;
    }
    
    /** full constructor */
    public Fillblank(Exam exam, String question, String answer, Integer fillBlankNo) {
        this.exam = exam;
        this.question = question;
        this.answer = answer;
        this.fillBlankNo = fillBlankNo;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Exam getExam() {
        return this.exam;
    }
    
    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getFillBlankNo() {
        return this.fillBlankNo;
    }
    
    public void setFillBlankNo(Integer fillBlankNo) {
        this.fillBlankNo = fillBlankNo;
    }
   








}