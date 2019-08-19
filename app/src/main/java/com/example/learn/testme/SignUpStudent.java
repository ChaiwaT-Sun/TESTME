
package com.example.learn.testme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learn.testme.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpStudent extends AppCompatActivity {

    Button btn_back;
    Button btn_register;
    EditText Etxt_new_idstudent , Etxt_new_username, Etxt_new_password;

    //for confirm password
    EditText txt_confirm_password;
    Button btn_confirm_password;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_student);

        //firebase
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        //Buttom
        btn_back = (Button)findViewById(R.id.btn_back_home);
        btn_register =(Button)findViewById(R.id.btn_new_sign_up);
        //EditText
        Etxt_new_idstudent = (EditText)findViewById(R.id.Etxt_new_idstudent);
        Etxt_new_username = (EditText)findViewById(R.id.Etxt_new_username);
        Etxt_new_password = (EditText)findViewById(R.id.Etxt_new_password);

        //Action Button
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeactivity = new Intent(SignUpStudent.this, SignInActivity.class);
                startActivity(homeactivity);
                finish();
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!Etxt_new_idstudent.getText().toString().equals("") && !Etxt_new_username.getText().toString().equals("") && !Etxt_new_password.getText().toString().equals("") ){

                    Toast.makeText(SignUpStudent.this,"Please Enter !!", Toast.LENGTH_SHORT).show();
                    register(Etxt_new_idstudent.getText().toString(),Etxt_new_username.getText().toString(),Etxt_new_password.getText().toString());

                }else

                    Toast.makeText(SignUpStudent.this,"Please Enter !!", Toast.LENGTH_SHORT).show();


            }
        });



    }

    private void register(final String Idstudent , final String username, final String password){

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUpStudent.this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View confirm_password = inflater.inflate(R.layout.confirm_password,null);
        alertDialog.setView(confirm_password);
        txt_confirm_password = (EditText)confirm_password.findViewById(R.id.Etxt_confiem_password);
        btn_confirm_password = (Button)confirm_password.findViewById(R.id.btn_confirm_password);
        alertDialog.show();



        // Button Confirm Password
        btn_confirm_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.equals(txt_confirm_password.getText().toString())){
                    final User user = new User(Idstudent,username,password);
                    users.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.child(user.getIdStudent()).exists())
                                Toast.makeText(SignUpStudent.this,"User already exists", Toast.LENGTH_SHORT).show();

                            else {
                                users.child(user.getIdStudent()).setValue(user);
                                Etxt_new_idstudent.setText("");
                                Etxt_new_password.setText("");
                                Etxt_new_username.setText("");

                                Toast.makeText(SignUpStudent.this,"User register Success !!",Toast.LENGTH_SHORT).show();
                                Intent homeactivity = new Intent(SignUpStudent.this, SignInActivity.class);
                                startActivity(homeactivity);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    alertDialog.hashCode();

                }else {
                    txt_confirm_password.setText("");
                    Toast.makeText(SignUpStudent.this,"password not match!",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

}
