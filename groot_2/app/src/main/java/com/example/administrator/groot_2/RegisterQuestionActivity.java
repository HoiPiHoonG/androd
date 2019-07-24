package com.example.administrator.groot_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018-11-20.
 */

public class RegisterQuestionActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_question);

        ImageView ex2 = (ImageView)findViewById(R.id.exit2);
        ImageView pr2 = (ImageView)findViewById(R.id.prev2);
        ImageView ne2 = (ImageView)findViewById(R.id.next2);

        ex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        pr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),LoginQuestionActivity.class);
                startActivity(intent);
            }
        });

        ne2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),PhotoQuestionActivity.class);
                startActivity(intent);
            }
        });

    }
}