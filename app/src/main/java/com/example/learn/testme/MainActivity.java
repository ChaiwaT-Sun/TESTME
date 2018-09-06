package com.example.learn.testme;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int splash_time_out = 600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeactivity = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(homeactivity);
                finish();
            }
        },splash_time_out);




    }
}
