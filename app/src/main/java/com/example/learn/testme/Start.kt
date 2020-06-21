package com.example.learn.testme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.learn.testme.common.common
import com.example.learn.testme.Model.Question
import com.google.firebase.database.*
import java.util.*

class Start : AppCompatActivity() {
    var btnStart: Button? = null
    var database: FirebaseDatabase? = null
    var Question: DatabaseReference? = null
    var show_subject_at: TextView? = null
    var getShow_subject_detail: TextView? = null
    var txt_many: TextView? = null
    var totalQuestion = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        btnStart = findViewById<View>(R.id.btn_start) as Button
        show_subject_at = findViewById<View>(R.id.show_subjecte_at) as TextView
        getShow_subject_detail = findViewById<View>(R.id.show_subjecte_deteil) as TextView
        txt_many = findViewById<View>(R.id.txt_many) as TextView
        txt_many!!.text = "มี $totalQuestion ข้อ"
        database = FirebaseDatabase.getInstance()
        Question = database!!.getReference("Questions")
        show_subject_at!!.text = common.Subjecte_Name
        getShow_subject_detail!!.text = common.Subjecte_Deteil
        loadQuestion(common.Subjecte_Id)
        btnStart!!.setOnClickListener {
            val intent = Intent(this@Start, Play::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Load Questions
    private fun loadQuestion(SubjecteId: String?) {


        // First , clear List if
        if (common.QuestiongsList.size > 0) common.QuestiongsList.clear()
        Question!!.orderByChild("Subjecte_Id").equalTo(SubjecteId)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (postSnapshot in dataSnapshot.children) {
                            val ques: Question? = postSnapshot.getValue<Question>(Question!!) as Question?
                            common.QuestiongsList.add(ques)
                            totalQuestion = common.QuestiongsList.size
                            txt_many!!.text = "มี $totalQuestion ข้อ"
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })

        //Random list
        Collections.shuffle(common.QuestiongsList)
    }
}

private fun <T> DataSnapshot.getValue(question: DatabaseReference): T? {
    return null
}
