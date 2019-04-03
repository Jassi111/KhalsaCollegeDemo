package com.jassi.demotraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        String nameFromPreviousClass = getIntent().getExtras().getString("name");

        Toast.makeText(Main2Activity.this,nameFromPreviousClass,Toast.LENGTH_LONG).show();



    }
}
