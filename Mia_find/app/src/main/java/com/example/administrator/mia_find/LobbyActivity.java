package com.example.administrator.mia_find;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class LobbyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        ImageView iv1=(ImageView) findViewById(R.id.Register);
        ImageView iv2=(ImageView) findViewById(R.id.beacon);
        TextView tv=(TextView) findViewById(R.id.mainT);
        TextView tv1=(TextView) findViewById(R.id.RegisterT);
        TextView tv2=(TextView) findViewById(R.id.beaconT);
        Animation alphaAnim = AnimationUtils.loadAnimation(this,R.anim.alpha);
        iv1.startAnimation(alphaAnim);
        iv2.startAnimation(alphaAnim);
        tv.startAnimation(alphaAnim);
        tv1.startAnimation(alphaAnim);
        tv2.startAnimation(alphaAnim);

       iv1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(LobbyActivity.this, RegisterActivity.class);
               startActivity(intent);
               finish();
           }
       });

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//도움말
                Intent intent = new Intent(LobbyActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}