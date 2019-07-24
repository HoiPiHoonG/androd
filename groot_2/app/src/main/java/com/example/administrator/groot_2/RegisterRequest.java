package com.example.administrator.groot_2;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-10-30.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://192.168.0.208/Register.php";
    private Map<String, String> parameters;

    //생성자
    public RegisterRequest(String userID, String userPassword, String userName, int userAge, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userAge", userAge+"");
    }
    //추후 사용을 위한 부분
    @Override
        protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
