package com.example.learn.testme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learn.testme.Common.common;
import com.example.learn.testme.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {


    Button btn_sign_up;
    Button btn_sign_in;
    EditText Etxt_idstudent,Etxt_password;

    FirebaseDatabase database;
    DatabaseReference users;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);


        //firebase
       database = FirebaseDatabase.getInstance();
       users = database.getReference("Users");

      //button
      btn_sign_up = (Button)findViewById(R.id.btn_sign_up);
      btn_sign_in = (Button)findViewById(R.id.btn_sign_in);

      Etxt_idstudent =(EditText)findViewById(R.id.Etxt_idStudent);
      Etxt_password = (EditText)findViewById(R.id.Etxt_password);

      //for test application
//      Etxt_idstudent.setText("123456789");
//      Etxt_password.setText("12345");


      //action button
      btn_sign_up.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent signUpactivity = new Intent(SignInActivity.this, SignUpStudent.class);
              startActivity(signUpactivity);
              finish();
          }
      });

      btn_sign_in.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              SignIn(Etxt_idstudent.getText().toString(),Etxt_password.getText().toString());
          }
      });
    }
    //Sign in to firebase
    private void SignIn(final String IdStudent , final String password){

        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(IdStudent).exists()){
                    if(!IdStudent.isEmpty())
                    {
                        User login = dataSnapshot.child(IdStudent).getValue(User.class);
                        if(login.getPassword().equals(password))
                        {
                            Intent homeActivity = new Intent(SignInActivity.this,Home.class);
                            common.currentUser = login;
                            startActivity(homeActivity);
                            finish();
                        }
                        else Toast.makeText(SignInActivity.this,"Wrong password", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(SignInActivity.this,"Please enter your ID Student or password",Toast.LENGTH_SHORT).show();
                    }
                }
                else Toast.makeText(SignInActivity.this,"ID Student is not exists !!",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
