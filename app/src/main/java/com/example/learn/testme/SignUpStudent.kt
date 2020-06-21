package com.example.learn.testme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.learn.testme.Model.User
import com.google.firebase.database.*

class SignUpStudent : AppCompatActivity() {
    var btn_back: Button? = null
    var btn_register: Button? = null
    var Etxt_new_idstudent: EditText? = null
    var Etxt_new_username: EditText? = null
    var Etxt_new_password: EditText? = null

    //for confirm password
    var txt_confirm_password: EditText? = null
    var btn_confirm_password: Button? = null
    var database: FirebaseDatabase? = null
    var users: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_student)

        //firebase
        database = FirebaseDatabase.getInstance()
        users = database!!.getReference("Users")

        //Buttom
        btn_back = findViewById<View>(R.id.btn_back_home) as Button
        btn_register = findViewById<View>(R.id.btn_new_sign_up) as Button
        //EditText
        Etxt_new_idstudent = findViewById<View>(R.id.Etxt_new_idstudent) as EditText
        Etxt_new_username = findViewById<View>(R.id.Etxt_new_username) as EditText
        Etxt_new_password = findViewById<View>(R.id.Etxt_new_password) as EditText

        //Action Button
        btn_back!!.setOnClickListener {
            val homeactivity = Intent(this@SignUpStudent, SignInActivity::class.java)
            startActivity(homeactivity)
            finish()
        }
        btn_register!!.setOnClickListener {
            if (Etxt_new_idstudent!!.text.toString() != "" && Etxt_new_username!!.text.toString() != "" && Etxt_new_password!!.text.toString() != "") {
                Toast.makeText(this@SignUpStudent, "Please Enter !!", Toast.LENGTH_SHORT).show()
                register(Etxt_new_idstudent!!.text.toString(), Etxt_new_username!!.text.toString(), Etxt_new_password!!.text.toString())
            } else Toast.makeText(this@SignUpStudent, "Please Enter !!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun register(Idstudent: String, username: String, password: String) {
        val alertDialog = AlertDialog.Builder(this@SignUpStudent)
        val inflater = this.layoutInflater
        val confirm_password = inflater.inflate(R.layout.dialog_confirm_password, null)
        alertDialog.setView(confirm_password)
        txt_confirm_password = confirm_password.findViewById<View>(R.id.Etxt_confiem_password) as EditText
        btn_confirm_password = confirm_password.findViewById<View>(R.id.btn_confirm_password) as Button
        alertDialog.show()


        // Button Confirm Password
        btn_confirm_password!!.setOnClickListener {
            if (password == txt_confirm_password!!.text.toString()) {
                val user = User(Idstudent, username, password)
                users!!.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.child(user.idStudent!!).exists()) Toast.makeText(this@SignUpStudent, "User already exists", Toast.LENGTH_SHORT).show() else {
                            users!!.child(user.idStudent!!).setValue(user)
                            Etxt_new_idstudent!!.setText("")
                            Etxt_new_password!!.setText("")
                            Etxt_new_username!!.setText("")
                            Toast.makeText(this@SignUpStudent, "User register Success !!", Toast.LENGTH_SHORT).show()
                            val homeactivity = Intent(this@SignUpStudent, SignInActivity::class.java)
                            startActivity(homeactivity)
                            finish()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })
                alertDialog.hashCode()
            } else {
                txt_confirm_password!!.setText("")
                Toast.makeText(this@SignUpStudent, "password not match!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}