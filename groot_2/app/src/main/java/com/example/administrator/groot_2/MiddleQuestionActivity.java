package com.example.administrator.groot_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018-11-21.
 */

public class MiddleQuestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_question);
        ImageView ex3 = (ImageView)findViewById(R.id.exit5);
        ImageView pr3 = (ImageView)findViewById(R.id.prev5);
        ImageView ne3 = (ImageView)findViewById(R.id.next5);

        ex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        pr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),PhotoQuestionActivity.class);
                startActivity(intent);
            }
        });

        ne3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),ChatQuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}

