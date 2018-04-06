package com.jakesadventures.simply.simply;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GoogleActivity extends AppCompatActivity {
    private WebView googleWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_google);
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        googleWebView = findViewById(R.id.googleWebView);
        WebSettings webSettings = googleWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        googleWebView.setWebViewClient(new WebViewClient());
        googleWebView.loadUrl("http://www.google.co.nz");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goToHome(View view) {
        finish();
    }
}
