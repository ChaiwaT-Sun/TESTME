package com.example.learn.testme.Model;

public class Qusetion {

    private String Qusetion;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private String AnswerD;
    private String AnswerF;
    private String CorrectAnswer;

    public String getQusetion() {
        return Qusetion;
    }

    public void setQusetion(String qusetion) {
        Qusetion = qusetion;
    }

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public String getAnswerF() {
        return AnswerF;
    }

    public void setAnswerF(String answerF) {
        AnswerF = answerF;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public String getIsQusetion() {
        return IsQusetion;
    }

    public void setIsQusetion(String isQusetion) {
        IsQusetion = isQusetion;
    }

    private String CategoryId;
    private String IsQusetion;

    public Qusetion(String qusetion, String answerA, String answerB, String answerC, String answerD, String answerF, String correctAnswer, String categoryId, String isQusetion) {
        Qusetion = qusetion;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        AnswerF = answerF;
        CorrectAnswer = correctAnswer;
        CategoryId = categoryId;
        IsQusetion = isQusetion;
    }

    public Qusetion(){

    }

}
