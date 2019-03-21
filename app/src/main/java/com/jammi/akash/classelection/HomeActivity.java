package com.jammi.akash.classelection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jammi.akash.classelecction.done;
import com.jammi.akash.classelecction.temp;

public class HomeActivity extends AppCompatActivity {
//    private static int SPLASH_TIME_OUT =25000;
    Button Login;
    Button nomi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.jammi.akash.classelection.R.layout.activity_home);
        Login=findViewById(R.id.LO);
        nomi = findViewById(R.id.nomi);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent homeintent = new Intent(HomeActivity.this,MainActivity.class);
//                startActivity(homeintent);
//
//            }
//        },SPLASH_TIME_OUT);
    }

    public void lo(View view){
        Intent goToNextActivity = new Intent(getApplicationContext(),Login.class);
        startActivity(goToNextActivity);
    }

    public void nomi(View view){
        Intent goToNextActivity = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(goToNextActivity);
    }


    public void nominate(View view)
    {
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle("Are You sure?")
                .setMessage("In case you have backlogs ,Your result will not be counted")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent goToNextActivity = new Intent(getApplicationContext(), Login.class);
                        goToNextActivity.putExtra("nominate",true);
                        startActivity(goToNextActivity);
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_lock_lock)
                .show();
    }
//    @override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
    }

