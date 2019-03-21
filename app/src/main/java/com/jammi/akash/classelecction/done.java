package com.jammi.akash.classelecction;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jammi.akash.classelection.HomeActivity;
import com.jammi.akash.classelection.MainActivity;
import com.jammi.akash.classelection.R;

public class done extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent = new Intent(done.this, HomeActivity.class);
                startActivity(homeintent);

            }
        },SPLASH_TIME_OUT);
    }
//    @override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
