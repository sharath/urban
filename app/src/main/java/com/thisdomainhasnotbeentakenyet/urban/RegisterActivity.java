package com.thisdomainhasnotbeentakenyet.urban;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends Activity {

    String url = "http://thisdomainhasnotbeentakenyet.com/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText user =  findViewById(R.id.username);
        EditText pass =  findViewById(R.id.password);
        EditText fname = findViewById(R.id.first_name);
        EditText lname = findViewById(R.id.last_name);
        EditText email = findViewById(R.id.email_address);

        final EditText list [] = {user, pass, fname, lname, email};

        Button sign_up = findViewById(R.id.signup);
        final JSONObject data = new JSONObject();
        final RequestQueue queue = Volley.newRequestQueue(this);
        final int correct = 0;
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.isPressed()){
                    int correct = 0;
                    for (EditText x : list){
                        String input = x.getText().toString();
                        if (input.equals("")){

                            Toast toast = Toast.makeText(getApplicationContext(), "Please Fill All Fields", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else{
                            correct++;
                            try{
                                data.put(getResources().getResourceEntryName(x.getId()) , input);
                            } catch (JSONException e){
                                e.printStackTrace();
                            }

                        }
                    }

                    //final JSONObject json_data = new JSONObject(data);
                    if (correct == 5) {
                        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast success = Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT);
                                success.show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast t_error = Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT);
                                t_error.show();
                            }
                        });

                        queue.add(request);
                        Log.d("Data", data.toString());
                    }

                }
            }
        });
        // End of setOnClickListener


    }
}
