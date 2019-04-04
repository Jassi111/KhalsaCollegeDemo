package com.jassi.demotraining;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        callGetService();
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
//        alertPractice();
        callPostService();
    }




    public void alertPractice() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Warning");
        builder.setMessage("This is a sample warning created here for some purpose.");
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Perform Here", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Toast from Negative Button",Toast.LENGTH_LONG).show();
            }
        });
        builder.show();

    }




    public void callGetService() {
        String url = "https://api.backendless.com/7FB1698B-6A87-B2A1-FF77-DF723E437400/D4A77C95-C7E0-E309-FF48-9ECBA9FC5000/data/UserTable";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();


                try {
                    JSONArray jsonArray = new JSONArray(response);

                    if (jsonArray.length() > 0) {


                        for (int i=0;i<jsonArray.length();i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Toast.makeText(MainActivity.this, jsonObject.getString("Phone_Number"),Toast.LENGTH_LONG).show();


                            String name = jsonObject.getString("Name");
                            String phone_number = jsonObject.getString("Phone_Number");

                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }




    public void callPostService() {

        String url = "https://api.backendless.com/7FB1698B-6A87-B2A1-FF77-DF723E437400/D4A77C95-C7E0-E309-FF48-9ECBA9FC5000/data/UserTable";



        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Name","test man");
            jsonObject.put("Gender","test gender");
            jsonObject.put("Phone_Number","test man");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Success");
                alert.setMessage("Your record has been successfully inserted");
                alert.setPositiveButton("OK",null);
                alert.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonObjectRequest);










    }






















    public void callIntent() {
        Intent intent= new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("name","abc");
        intent.putExtra("name1","xyz");
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next) {
            callIntent();
        }
    }

}
