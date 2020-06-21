package com.example.learn.testme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.learn.testme.common.common
import com.example.learn.testme.Model.User
import com.google.firebase.database.*

class SignInActivity : AppCompatActivity() {
    var btn_sign_up: Button? = null
    var btn_sign_in: Button? = null
    var Etxt_idstudent: EditText? = null
    var Etxt_password: EditText? = null
    var database: FirebaseDatabase? = null
    var users: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singin)


        //firebase
        database = FirebaseDatabase.getInstance()
        users = database!!.getReference("Users")

        //button
        btn_sign_up = findViewById<View>(R.id.btn_sign_up) as Button
        btn_sign_in = findViewById<View>(R.id.btn_sign_in) as Button
        Etxt_idstudent = findViewById<View>(R.id.Etxt_idStudent) as EditText
        Etxt_password = findViewById<View>(R.id.Etxt_password) as EditText

        //for test application
//      Etxt_idstudent.setText("123456789");
//      Etxt_password.setText("12345");


        //action button
        btn_sign_up!!.setOnClickListener {
            val signUpactivity = Intent(this@SignInActivity, SignUpStudent::class.java)
            startActivity(signUpactivity)
            finish()
        }
        btn_sign_in!!.setOnClickListener { SignIn(Etxt_idstudent!!.text.toString(), Etxt_password!!.text.toString()) }
    }

    //Sign in to firebase
    private fun SignIn(IdStudent: String, password: String) {
        users!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) =
                    if (dataSnapshot.child(IdStudent).exists()) {
                        if (!IdStudent.isEmpty()) {
                            var user = mutableListOf<User>()
                            var testidSuten = false
                            val login = dataSnapshot.child(IdStudent).getValue(testidSuten)
                            if (login == password) {
                                val homeActivity = Intent(this@SignInActivity, Home::class.java)
                                common.currentUser = User()
                                startActivity(homeActivity)
                                finish()
                            } else Toast.makeText(this@SignInActivity, "Wrong password", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@SignInActivity, "Please enter your ID Student or password", Toast.LENGTH_SHORT).show()
                        }
                    } else Toast.makeText(this@SignInActivity, "ID Student is not exists !!", Toast.LENGTH_SHORT).show()

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}