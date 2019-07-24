package com.example.administrator.groot_2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.administrator.groot_2.R.id.finish;

/**
 * Created by Administrator on 2018-10-30.
 */

public class LoginActivity extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInsatanceState) {
        super.onCreate(savedInsatanceState);
        setContentView(R.layout.activity_login);

        //강의에서 final을 추가시켜줌
        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final Button loginbtn = (Button) findViewById(R.id.loginbtn);
        final ImageView registerbtn = (ImageView) findViewById(R.id.registerbtn);
        ImageView credit = (ImageView) findViewById(R.id.credit);
        ImageView question = (ImageView)findViewById(R.id.question);

        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent m = new Intent(getApplicationContext(), LoginQuestionActivity.class);
                startActivity(m);
            }
        });

        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//도움말
                Intent m = new Intent(getApplicationContext(), CreditActivity.class);
                startActivity(m);
            }
        });

        checkBox = (CheckBox) findViewById(R.id.checkbox);

        ImageView finish = (ImageView) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//어플 완전 종료
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });


        idText.requestFocus();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);//ID 저장
        String id = pref.getString("id_save", "");
        boolean chk1 = pref.getBoolean("chk1", false);

        if (chk1 == true) {
            idText.setText(id);
            checkBox.setChecked(chk1);
        }

        registerbtn.setOnClickListener(new View.OnClickListener() {//회원가입 화면전환
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {//로그인 화면
            @Override
            public void onClick(View view) {
                final String userID = idText.getText().toString();
                final String userPassword = passwordText.getText().toString();

                //4. 콜백 처리부분(volley 사용을 위한 ResponseListener 구현 부분)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            //서버에서 보내준 값이 true이면?
                            if (success) {
                                Toast.makeText(getApplicationContext(), "환영합니다 " + userID + "님", Toast.LENGTH_SHORT).show();
                                String userID = jsonResponse.getString("userID");
                                String userPassword = jsonResponse.getString("userPassword");
                                //로그인에 성공했으므로 LobbyActivity로 넘어감
                                Intent intent = new Intent(LoginActivity.this, LobbyActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPassword", userPassword);
                                LoginActivity.this.startActivity(intent);
                            } else {
                                //로그인 실패시
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("로그인 실패")
                                        .setNegativeButton("retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };//Volley 라이브러리
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }

    public void onStop() {
        super.onStop();
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        EditText idText = (EditText) findViewById(R.id.idText);
        checkBox = (CheckBox) findViewById(R.id.checkbox);

        editor.putString("id_save", idText.getText().toString());
        editor.putBoolean("chk1", checkBox.isChecked());
        editor.commit();
    }
}
