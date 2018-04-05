package com.jakesadventures.simply.simply;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TextActivity extends AppCompatActivity {
    private WebView googleWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_text);

        googleWebView = findViewById(R.id.googleWebView);
        WebSettings webSettings = googleWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        googleWebView.setWebViewClient(new WebViewClient());
        googleWebView.loadUrl("http://www.google.co.nz");
    }

    public void goToHome(View view) {
        finish();
    }
}
