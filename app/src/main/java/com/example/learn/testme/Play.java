package com.example.learn.testme;

import android.content.Intent;
import android.os.Bundle;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.learn.testme.Common.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Play extends AppCompatActivity implements View.OnClickListener{


    Button btnA,btnB,btnC,btnD,btnE;
    TextView txt_time,txt_count,Question_text;
    Chronometer simpleChronometer;

    int index=0,score=0,thisQuestion=0,totalQuestion,correctAnswer;


    //for test



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // View
        txt_count = (TextView)findViewById(R.id.set_count);

        Question_text = (TextView)findViewById(R.id.text_Question);

        simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);

        btnA = (Button)findViewById(R.id.btn_answerA);
        btnB = (Button)findViewById(R.id.btn_answerB);
        btnC = (Button)findViewById(R.id.btn_answerC);
        btnD = (Button)findViewById(R.id.btn_answerD);
        btnE = (Button)findViewById(R.id.btn_answerE);


        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);


        simpleChronometer.start();







    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(" Test tag error  >>","on Resume");

        //TEst out subjecte

        Log.e("TEst show index>>",Integer.toString(index));

        totalQuestion = common.QuestiongsList.size();


             Log.e("TEst show index>>",Integer.toString(index));
             showQuestion(index);


    }

    private void showQuestion(int index) {

        Log.e("function Show Question >>","show Question");

        if(index < totalQuestion){
            thisQuestion++;

            Log.e("on method question >>>>","show Question ");

            txt_count.setText(String.format("%d / %d",thisQuestion,totalQuestion));
            Question_text.setText(common.QuestiongsList.get(index).getQuestion());
            btnA.setText(common.QuestiongsList.get(index).getAnswerA());
            btnB.setText(common.QuestiongsList.get(index).getAnswerB());
            btnC.setText(common.QuestiongsList.get(index).getAnswerC());
            btnD.setText(common.QuestiongsList.get(index).getAnswerD());
            btnE.setText(common.QuestiongsList.get(index).getAnswerE());


        }
        else{
            Log.e("else show question >>>>","show Question ");
            // if is final question

            simpleChronometer.stop();
            long time = SystemClock.elapsedRealtime()-simpleChronometer.getBase();

            DateFormat formatter = new SimpleDateFormat("mm:ss");
           // formatter.format(time);

            Log.e("time>>> " , formatter.format(time) );
            Log.e("final >>>>",Integer.toString(totalQuestion));
            Log.e("final >>>>",Integer.toString(correctAnswer));


            Intent intent =new Intent(this,Done.class);
            Bundle dataSend = new Bundle();
            dataSend.putString("TIME" , formatter.format(time));
            dataSend.putInt("TOTAL",totalQuestion);
            dataSend.putInt("CORRECT",correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }




    }



    @Override
    public void onClick(View view) {

        Log.e(" Test tag error  >>","on click ");
        if(index < totalQuestion) //still have question in list
        {

            Button clickedButton = (Button)view;
            Log.e("TEst Click >>  >> ",clickedButton.getText().toString());
            Log.e("Answer Correct >>",common.QuestiongsList.get(index).getCorrectAnswer());
            if(clickedButton.getText().equals(common.QuestiongsList.get(index).getCorrectAnswer()))
            {
      //Score

                correctAnswer++;
                showQuestion(++index);

            }
            else{

                score -=1 ;
                showQuestion(++index);

            }

        }



    }
}
