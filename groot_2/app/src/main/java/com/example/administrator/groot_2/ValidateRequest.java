package com.example.administrator.groot_2;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-11-13.
 */
public class ValidateRequest extends StringRequest {
    final static private String URL = "http://192.168.0.208/UserValidate.php";
    private Map<String, String> parameters;
    public ValidateRequest(String userID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);//해당 URL에 POST방식으로 파마미터들을 전송함
        parameters = new HashMap<>();
        parameters.put("userID", userID);
    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }}
