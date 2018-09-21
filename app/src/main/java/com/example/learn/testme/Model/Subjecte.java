package com.example.learn.testme.Model;

public class Subjecte {

    private  String Category_id;
    private  String Subjecte_Deteil;
    private  String Subjecte_Id;
    private  String Subjecte_Name;

    public Subjecte(){

    }

    public Subjecte(String category_id, String subjecte_Deteil, String subjecte_Id, String subjecte_Name) {
        Category_id = category_id;
        Subjecte_Deteil = subjecte_Deteil;
        Subjecte_Id = subjecte_Id;
        Subjecte_Name = subjecte_Name;
    }

    public String getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(String category_id) {
        Category_id = category_id;
    }

    public String getSubjecte_Deteil() {
        return Subjecte_Deteil;
    }

    public void setSubjecte_Deteil(String subjecte_Deteil) {
        Subjecte_Deteil = subjecte_Deteil;
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
}
