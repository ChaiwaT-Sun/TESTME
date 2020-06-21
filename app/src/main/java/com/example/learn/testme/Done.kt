package com.example.learn.testme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.learn.testme.common.common
import com.example.learn.testme.Model.QuestionHistory
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Done : AppCompatActivity() {
    var btn_back_home: Button? = null
    var txt_playerName: TextView? = null
    var txt_playertime: TextView? = null
    var txt_PlayerPassed: TextView? = null
    var txt_playerSubjecte: TextView? = null

    //Firebase
    var database: FirebaseDatabase? = null
    var question_history: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_done)

        //Firebase
        database = FirebaseDatabase.getInstance()
        question_history = database!!.getReference("QuestionHistory")


        //Tesxt View
        txt_playerName = findViewById<View>(R.id.player_name) as TextView
        txt_playertime = findViewById<View>(R.id.player_time) as TextView
        txt_PlayerPassed = findViewById<View>(R.id.player_passed) as TextView
        txt_playerSubjecte = findViewById<View>(R.id.player_subjecte) as TextView
        btn_back_home = findViewById<View>(R.id.btn_back_home) as Button
        btn_back_home!!.setOnClickListener {
            val intent = Intent(this@Done, Home::class.java)
            startActivity(intent)
            finish()
        }
        val extra = intent.extras
        if (extra != null) {
            val time = extra.getString("TIME")
            val totalQuestion = extra.getInt("TOTAL")
            val correctAnswer = extra.getInt("CORRECT")
            Log.e("time test >>>", time)

            // Show data to page
            txt_playerName!!.text = String.format("คุณ : %s", common.currentUser!!.username)
            txt_playertime!!.text = String.format("เวลาที่ใช้ไป : %s", time.toString())
            txt_PlayerPassed!!.text = String.format("คะแนน : %d / %d", correctAnswer, totalQuestion)
            txt_playerSubjecte!!.text = String.format("%s", common.Subjecte_Id)

            //set data to firebase
            question_history!!.child(String.format("%s_%s", common.currentUser!!.username, common.Subjecte_Id))
                    .setValue(QuestionHistory(
                            common.currentUser!!.username,
                            common.Subjecte_Id!!,
                            common.Subjecte_Name!!, correctAnswer.toString(), String.format("%s_%s", common.currentUser!!.username!!, common.Subjecte_Id!!), time.toString(),
                            common.currentUser!!.idStudent!!
                    ))
        }
    }
}