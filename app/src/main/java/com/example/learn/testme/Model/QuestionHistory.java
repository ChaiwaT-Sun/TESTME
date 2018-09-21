package com.example.learn.testme.Model;

public class QuestionHistory {


    private String User;
    private String Subjecte_Id;
    private String Subjecte_Name;
    private String Score;
    private String Question_Scoer;
    private String UserId;
    private String player_time;


    public String getPlayer_time() {
        return player_time;
    }

    public void setPlayer_time(String player_time) {
        this.player_time = player_time;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getSubjecte_Id() {
        return Subjecte_Id;
    }

    public void setSubjecte_Id(String subjecte_Id) {
        Subjecte_Id = subjecte_Id;
    }

    public String getSubjecte_Name() {
        return Subjecte_Name;
    }

    public void setSubjecte_Name(String subjecte_Name) {
        Subjecte_Name = subjecte_Name;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getQuestion_Scoer() {
        return Question_Scoer;
    }

    public void setQuestion_Scoer(String question_Scoer) {
        Question_Scoer = question_Scoer;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public QuestionHistory( String user, String subjecte_Id, String subjecte_Name, String score, String question_Scoer, String player_time ,String userId) {

        this.player_time = player_time;
        UserId = userId;
        User = user;
        Subjecte_Id = subjecte_Id;
        Subjecte_Name = subjecte_Name;
        Score = score;
        Question_Scoer = question_Scoer;




    }

    public QuestionHistory(){

  }
}
