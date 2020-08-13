package com.dev.newsapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dev.newsapp.R;
import com.google.android.material.appbar.MaterialToolbar;

public class DisplayNewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_news);

        MaterialToolbar toolbar = findViewById(R.id.displayToolbar);
        setSupportActionBar(toolbar);

        WebView webView = findViewById(R.id.web_View);
        webView.setWebViewClient(new WebViewClient());
        String url = getIntent().getStringExtra("news_url");
        Log.d("url", "onCreate: "+url);
        webView.loadUrl(url);


    }
}