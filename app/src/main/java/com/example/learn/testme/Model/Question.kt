package com.example.learn.testme.Model

class Question {
    var Question: String? = null
        set(Question) {
            var Question = Question
            Question = Question
        }
    var answerA: String? = null
    var answerB: String? = null
    var answerC: String? = null
    var answerD: String? = null
    var answerE: String? = null
        set(AnswerE) {
            var AnswerE = AnswerE
            AnswerE = AnswerE
        }
    var correctAnswer: String? = null
    var isImageQuestion: String? = null

    constructor(isImageQuestion: String?) {
        this.isImageQuestion = isImageQuestion
    }

    fun getIsQuestion(): String? {
        return IsQuestion
    }

    fun setIsQuestion(isQuestion: String?) {
        IsQuestion = isQuestion
    }

    var categoryId: String? = null
    private var IsQuestion: String? = null

    constructor(Question: String?, answerA: String?, answerB: String?, answerC: String?, answerD: String?, AnswerE: String?, correctAnswer: String?, categoryId: String?, isQuestion: String?) {
        var Question = Question
        var AnswerE = AnswerE
        Question = Question
        this.answerA = answerA
        this.answerB = answerB
        this.answerC = answerC
        this.answerD = answerD
        AnswerE = AnswerE
        this.correctAnswer = correctAnswer
        this.categoryId = categoryId
        IsQuestion = isQuestion
    }

    constructor()
}