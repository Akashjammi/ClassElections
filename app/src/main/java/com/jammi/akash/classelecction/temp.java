package com.jammi.akash.classelecction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.jammi.akash.classelection.HomeActivity;
import com.jammi.akash.classelection.Login;
import com.jammi.akash.classelection.MainActivity;
import com.jammi.akash.classelection.R;

import java.util.Iterator;

public class temp extends AppCompatActivity {
//String user;
    ImageView  mImageView;
    String ap;
    Boolean j=true;
    String newmail = "";
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        String email = mAuth.getCurrentUser().getEmail();
        for(int i=0;i<email.length()&& j;i++) {
        if(email.charAt(i)!='@'){
            newmail += email.charAt(i);
        }else {
        j=false;
        }
        }
        String deptsec= getIntent().getStringExtra("deptsec");
        final DatabaseReference myRef = database.getReference("votes").child(deptsec);
        final DatabaseReference urRef = database.getReference("Users");
        DatabaseReference upvotesRef = myRef.child("count");
         ap = getIntent().getStringExtra("user");


        urRef.child("DoneUsers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.hasChild(newmail)) {
                    // run some code
                    new AlertDialog.Builder(temp.this)
                            .setTitle("You already Voted")
                            .setMessage("Sorry you can vote only once")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent goToNextActivity = new Intent(getApplicationContext(), Login.class);
                                    startActivity(goToNextActivity);
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else{
                    urRef.child("DoneUsers").child(newmail).setValue(Integer.parseInt(newmail));
                    myRef.child(ap).runTransaction(new Transaction.Handler() {
                        @Override
                        public Transaction.Result doTransaction(MutableData mutableData) {
                            Integer currentValue = mutableData.getValue(Integer.class);
                            if (currentValue == null) {
                                mutableData.setValue(1);
                            } else {
                                mutableData.setValue(currentValue + 1);
                            }

                            return Transaction.success(mutableData);
                        }

                        @Override
                        public void onComplete(DatabaseError databaseError, boolean committed, DataSnapshot dataSnapshot) {
                            System.out.println("Transaction completed");
                            Intent homeintent = new Intent(temp.this, done.class);
                            startActivity(homeintent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });











//
//         urRef.child("DoneUsers").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot data: dataSnapshot.getChildren()){
//                    if (data.child(newmail).exists()) {
//
//                    } else {
//                        //do something if not exists
//
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
////            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });


    }
//    @override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
    }

