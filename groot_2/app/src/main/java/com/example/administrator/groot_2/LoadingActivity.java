package com.example.administrator.groot_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018-11-13.
 */

public class LoadingActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Handler delayHandler = new Handler();//딜레이 함수
        delayHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent m = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(m);
            }
        }, 2000);
    }
}
