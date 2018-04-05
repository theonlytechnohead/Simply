package com.jakesadventures.simply.simply;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class GoogleActivity extends AppCompatActivity {
    private WebView googleWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        googleWebView = findViewById(R.id.googleWebView);
        WebSettings webSettings = googleWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        googleWebView.setWebViewClient(new WebViewClient());
        googleWebView.loadUrl("http://www.google.co.nz");
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
