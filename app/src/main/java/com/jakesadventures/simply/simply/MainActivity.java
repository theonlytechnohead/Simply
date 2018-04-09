package com.jakesadventures.simply.simply;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int points = 0;
    public String customApp1 = "";
    public String customApp2 = "";
    public String customApp3 = "";
    public String customApp4 = "";
    public String customApp5 = "";
    public String customApp6 = "";
    public String customApp7 = "";
    public String customApp8 = "";
    public String customApp9 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //variables to push and pull from files



        //Hide the nav bar
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        super.onCreate(savedInstanceState);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void goToGoogle(View view) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        Intent intent = new Intent(this, GoogleActivity.class);
        startActivity(intent);
    }

    public void goToText(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(intent);
    }

    public void goToCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    public void SaveInformation () {
        // Create object of SharedPreferences.
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        //now get Editor
        SharedPreferences.Editor editor= sharedPref.edit();

        //put your value
        editor.putString("points", String.valueOf(points));

        //commits your edits
        editor.commit();
    }

    public void LoadInformation (){
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        points = Integer.valueOf(sharedPref.getString("points", "0"));

    }

    public void OpenApps (View view) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        Intent appIntent = new Intent(this, AllAppsActivity.class);
        startActivity(appIntent);
    }
}
