package com.example.learn.testme

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import com.example.learn.testme.common.common
import java.text.DateFormat
import java.text.SimpleDateFormat

class Play : AppCompatActivity(), View.OnClickListener {
    var btnA: Button? = null
    var btnB: Button? = null
    var btnC: Button? = null
    var btnD: Button? = null
    var btnE: Button? = null
    var txt_time: TextView? = null
    var txt_count: TextView? = null
    var Question_text: TextView? = null
    var simpleChronometer: Chronometer? = null
    var index = 0
    var score = 0
    var thisQuestion = 0
    var totalQuestion = 0
    var correctAnswer = 0

    //for test
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        // View
        txt_count = findViewById<View>(R.id.set_count) as TextView
        Question_text = findViewById<View>(R.id.text_Question) as TextView
        simpleChronometer = findViewById<View>(R.id.simpleChronometer) as Chronometer
        btnA = findViewById<View>(R.id.btn_answerA) as Button
        btnB = findViewById<View>(R.id.btn_answerB) as Button
        btnC = findViewById<View>(R.id.btn_answerC) as Button
        btnD = findViewById<View>(R.id.btn_answerD) as Button
        btnE = findViewById<View>(R.id.btn_answerE) as Button
        btnA!!.setOnClickListener(this)
        btnB!!.setOnClickListener(this)
        btnC!!.setOnClickListener(this)
        btnD!!.setOnClickListener(this)
        btnE!!.setOnClickListener(this)
        simpleChronometer!!.start()
    }

    override fun onResume() {
        super.onResume()
        Log.e(" Test tag error  >>", "on Resume")

        //TEst out subjecte
        Log.e("TEst show index>>", Integer.toString(index))
        totalQuestion = common.QuestiongsList.size
        Log.e("TEst show index>>", Integer.toString(index))
        showQuestion(index)
    }

    private fun showQuestion(index: Int) {
        Log.e("function Show Question >>", "show Question")
        if (index < totalQuestion) {
            thisQuestion++
            Log.e("on method question >>>>", "show Question ")
            txt_count!!.text = String.format("%d / %d", thisQuestion, totalQuestion)
            Question_text!!.text = common.QuestiongsList[index]!!.Question
            btnA!!.text = common.QuestiongsList[index]!!.answerA
            btnB!!.text = common.QuestiongsList[index]!!.answerB
            btnC!!.text = common.QuestiongsList[index]!!.answerC
            btnD!!.text = common.QuestiongsList[index]!!.answerD
            btnE!!.text = common.QuestiongsList[index]!!.answerE
        } else {
            Log.e("else show question >>>>", "show Question ")
            // if is final question
            simpleChronometer!!.stop()
            val time = SystemClock.elapsedRealtime() - simpleChronometer!!.base
            val formatter: DateFormat = SimpleDateFormat("mm:ss")
            // formatter.format(time);
            val intent = Intent(this, Done::class.java)
            val dataSend = Bundle()
            dataSend.putString("TIME", formatter.format(time))
            dataSend.putInt("TOTAL", totalQuestion)
            dataSend.putInt("CORRECT", correctAnswer)
            intent.putExtras(dataSend)
            startActivity(intent)
            finish()
        }
    }

    override fun onClick(view: View) {
        Log.e(" Test tag error  >>", "on click ")
        if (index < totalQuestion) //still have question in list
        {
            val clickedButton = view as Button
            Log.e("TEst Click >>  >> ", clickedButton.text.toString())
            Log.e("Answer Correct >>", common.QuestiongsList[index]!!.correctAnswer)
            if (clickedButton.text == common.QuestiongsList[index]!!.correctAnswer) {
                //Score
                correctAnswer++
                showQuestion(++index)
            } else {
                score -= 1
                showQuestion(++index)
            }
        }
    }
}