package com.example.learn.testme.Model;

public class Question {

    private String Question;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private String AnswerD;
    private String AnswerE;
    private String CorrectAnswer;
    private String IsImageQuestion;

    public String getIsImageQuestion() {
        return IsImageQuestion;
    }

    public void setIsImageQuestion(String isImageQuestion) {
        IsImageQuestion = isImageQuestion;
    }

    public Question(String isImageQuestion) {
        IsImageQuestion = isImageQuestion;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        Question = Question;
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

    public String getAnswerE() {
        return AnswerE;
    }

    public void setAnswerE(String AnswerE) {
        AnswerE = AnswerE;
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

    public String getIsQuestion() {
        return IsQuestion;
    }

    public void setIsQuestion(String isQuestion) {
        IsQuestion = isQuestion;
    }

    private String CategoryId;
    private String IsQuestion;

    public Question(String Question, String answerA, String answerB, String answerC, String answerD, String AnswerE, String correctAnswer, String categoryId, String isQuestion) {
        Question = Question;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        AnswerE = AnswerE;
        CorrectAnswer = correctAnswer;
        CategoryId = categoryId;
        IsQuestion = isQuestion;
    }

    public Question(){

    }

}
