package com.example.learn.testme.Model

class QuestionHistory {
    var user: String? = null
    var subjecte_Id: String? = null
    var subjecte_Name: String? = null
    var score: String? = null
    var question_Scoer: String? = null
    var userId: String? = null
    var player_time: String? = null

    constructor(user: String?, subjecte_Id: String?, subjecte_Name: String?, score: String?, question_Scoer: String?, player_time: String?, userId: String?) {
        this.player_time = player_time
        this.userId = userId
        this.user = user
        this.subjecte_Id = subjecte_Id
        this.subjecte_Name = subjecte_Name
        this.score = score
        this.question_Scoer = question_Scoer
    }

    constructor()
}