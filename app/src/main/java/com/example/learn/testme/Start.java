package com.example.learn.testme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learn.testme.Common.common;
import com.example.learn.testme.Model.Question;
import com.example.learn.testme.Model.Subjecte;
import com.example.learn.testme.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

import static com.example.learn.testme.Common.common.categoryId;

public class Start extends AppCompatActivity {

    Button btnStart;
    FirebaseDatabase database;
    DatabaseReference Question;

    TextView show_subject_at,getShow_subject_detail,txt_many;

    int totalQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart = (Button)findViewById(R.id.btn_start);
        show_subject_at = (TextView)findViewById(R.id.show_subjecte_at);
        getShow_subject_detail = (TextView)findViewById(R.id.show_subjecte_deteil);
        txt_many = (TextView)findViewById(R.id.txt_many);



        txt_many.setText("มี " + totalQuestion + " ข้อ");

        database = FirebaseDatabase.getInstance();
        Question = database.getReference("Questions");


        show_subject_at.setText(common.Subjecte_Name);
        getShow_subject_detail.setText(common.Subjecte_Deteil);

        loadQuestion(common.Subjecte_Id);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this,Play.class);
                startActivity(intent);
                finish();

            }
        });
    }

    // Load Questions
    private void loadQuestion(String SubjecteId) {


        // First , clear List if
        if(common.QuestiongsList.size() > 0)
            common.QuestiongsList.clear();


        Question.orderByChild("Subjecte_Id").equalTo(SubjecteId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot postSnapshot : dataSnapshot.getChildren())
                        {
                            Question ques = postSnapshot.getValue(Question.class);

                            common.QuestiongsList.add(ques);


                            totalQuestion = common.QuestiongsList.size();
                            txt_many.setText("มี " + totalQuestion + " ข้อ");


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        //Random list
        Collections.shuffle(common.QuestiongsList);


    }

}
