package com.example.administrator.groot_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018-11-20.
 */

public class PhotoQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_question);

        ImageView ex3 = (ImageView)findViewById(R.id.exit3);
        ImageView pr3 = (ImageView)findViewById(R.id.prev3);
        ImageView ne3 = (ImageView)findViewById(R.id.next3);

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
                Intent intent = new Intent(getApplicationContext(),RegisterQuestionActivity.class);
                startActivity(intent);
            }
        });

        ne3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent intent = new Intent(getApplicationContext(),MiddleQuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}
