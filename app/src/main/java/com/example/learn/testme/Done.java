package com.example.learn.testme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learn.testme.Common.common;
import com.example.learn.testme.Model.QuestionHistory;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Done extends AppCompatActivity {

    Button btn_back_home;
    TextView txt_playerName,txt_playertime,txt_PlayerPassed , txt_playerSubjecte;

    //Firebase
    FirebaseDatabase database;
    DatabaseReference question_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        //Firebase
        database = FirebaseDatabase.getInstance();
        question_history = database.getReference("QuestionHistory");


        //Tesxt View
        txt_playerName = (TextView)findViewById(R.id.player_name);
        txt_playertime = (TextView)findViewById(R.id.player_time);
        txt_PlayerPassed = (TextView)findViewById(R.id.player_passed);
        txt_playerSubjecte = (TextView)findViewById(R.id.player_subjecte);

        btn_back_home = (Button)findViewById(R.id.btn_back_home);

        btn_back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Done.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String time  = extra.getString("TIME");
            int totalQuestion = extra.getInt("TOTAL");
            int correctAnswer = extra.getInt("CORRECT");

            Log.e("time test >>>",time);

            // Show data to page
            txt_playerName.setText(String.format("คุณ : %s", common.currentUser.getUsername()));
            txt_playertime.setText(String.format("เวลาที่ใช้ไป : %s" , time.toString()));
            txt_PlayerPassed.setText(String.format("คะแนน : %d / %d" , correctAnswer,totalQuestion));
            txt_playerSubjecte.setText(String.format("%s", common.Subjecte_Id));

            //set data to firebase
            question_history.child(String.format("%s_%s",common.currentUser.getUsername(),common.Subjecte_Id))
                    .setValue(new QuestionHistory(
                            common.currentUser.getUsername(),
                            common.Subjecte_Id,
                            common.Subjecte_Name,
                            String.valueOf(correctAnswer),
                            String.format("%s_%s",common.currentUser.getUsername(),common.Subjecte_Id),
                            String.valueOf(time),
                            common.currentUser.getIdStudent()
                    ));

        }

    }
}
