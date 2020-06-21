package com.example.learn.testme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvVersion.text = "Version:: ${BuildConfig.VERSION_NAME}"
        Handler().postDelayed({
            val homeactivity = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(homeactivity)
            finish()
        }, splash_time_out.toLong())
    }

    companion object {
        private const val splash_time_out = 1000
    }
}