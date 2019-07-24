package com.example.administrator.groot_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-11-17.
 */

public class CreditActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        TextView back = (TextView) findViewById(R.id.textView);
        back.setOnClickListener(new View.OnClickListener() {//뒤로가기버튼
            @Override
            public void onClick(View view) {
                Intent m = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(m);
            }
        });

    }
}
