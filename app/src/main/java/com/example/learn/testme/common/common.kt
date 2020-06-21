package com.example.learn.testme.common

import com.example.learn.testme.Model.Question
import com.example.learn.testme.Model.User
import java.util.*

object common {
    var categoryId: String? = null
    var categoryName: String? = null
    var Subjecte_Id: String? = null
    var Subjecte_Deteil: String? = null
    var Subjecte_Name: String? = null
    var currentUser: User? = null
    var QuestiongsList: MutableList<Question?> = ArrayList()
    const val STR_PUSH = "pushNotification"
}