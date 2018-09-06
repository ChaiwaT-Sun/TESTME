package com.example.learn.testme.Model;

import android.renderscript.ScriptIntrinsicYuvToRGB;

public class User {
    private String IdStudent;
    private String password;
    private String username;


    public String getIdStudent() {
        return IdStudent;
    }

    public void setIdStudent(String idStudent) {
        IdStudent = idStudent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String idStudent, String username, String password) {
        IdStudent = idStudent;
        this.username = username;
        this.password = password;
    }



    public User(){

    }






}
