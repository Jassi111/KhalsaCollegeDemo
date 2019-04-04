package com.jassi.demotraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {


    WebView wv_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        wv_main = (WebView) findViewById(R.id.wv_main);
        wv_main.loadUrl("http://aprosoftech.com/");

    }
}
