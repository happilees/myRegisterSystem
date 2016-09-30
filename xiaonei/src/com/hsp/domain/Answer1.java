package com.hsp.domain;

/**
 * Created by zhanhengkitt on 2016/1/4.
 */
public class Answer1 {
    private Integer id;
    private Student student;
    private String studentResult;
    private String typeName;
    private Integer flag;
    private Integer questionId;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Answer1() {
    }



    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(String studentResult) {
        this.studentResult = studentResult;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
