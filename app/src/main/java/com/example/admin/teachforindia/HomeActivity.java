package com.example.admin.teachforindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Thread mythread = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(3000);
                    Intent newIntent = new Intent(getApplicationContext(),homePage.class);
                    startActivity(newIntent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        mythread.start();
    }
}
