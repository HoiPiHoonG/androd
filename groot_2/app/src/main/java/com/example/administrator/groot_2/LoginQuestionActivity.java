package com.example.administrator.groot_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018-11-20.
 */

public class LoginQuestionActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_question);

        ImageView ex1 = (ImageView)findViewById(R.id.exit1);
        ImageView ne1 = (ImageView)findViewById(R.id.next1);

        ex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        ne1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),RegisterQuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
