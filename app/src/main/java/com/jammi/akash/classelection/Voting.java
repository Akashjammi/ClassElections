package com.jammi.akash.classelection;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.jammi.akash.classelecction.done;
import com.jammi.akash.classelecction.temp;

public class Voting extends AppCompatActivity implements View.OnClickListener {
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    FirebaseDatabase database;
    DatabaseReference myRef;
    DatabaseReference upvotesRef;
    Integer curr;
    String count;
    Integer stud;
    private FirebaseAuth mAuth;
    String newmail;
    Boolean j= true;
    String classD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);
        one = findViewById(R.id.button2);
        two = findViewById(R.id.button3);
        three = findViewById(R.id.button4);
        four = findViewById(R.id.button5);
        five = findViewById(R.id.button6);
        six = findViewById(R.id.new1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");
        DatabaseReference upvotesRef = database.getReference("votes").child("ITA");

        mAuth = FirebaseAuth.getInstance();
        String email = mAuth.getCurrentUser().getEmail();
        for(int i=0;i<email.length()&& j;i++) {
            if(email.charAt(i)!='@'){
                newmail += email.charAt(i);
            }else {
                j = false;
            }}
//           Integer roll=Integer.parseInt(newmail);

        myRef.runTransaction(new Transaction.Handler() {
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

//            one.setText("Aba");

            @Override
            public void onComplete(DatabaseError databaseError, boolean committed, DataSnapshot dataSnapshot) {
                System.out.println("Transaction completed");
            }
        });
//        upvotesRef.child("ITA").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//             six.setVisibility(View.VISIBLE);
//              six.setText(snapshot.getValue().toString());
//        }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//
//        });
    }
    public String  checkroll(int roll)
    {
        if(roll>=170801001 && roll<=170801056) {
            one.setText("Ram");
            two.setText("Kam");
            three.setText("Mam");
            four.setText("Nam");
            five.setText("RTam");
            return "IT-A";
        }
        if(roll>=170801057 && roll<=170801105) {
            one.setText("sham");
            two.setText("sjam");
            three.setText("kamam");
            four.setText("akamam");
            five.setText("asdTam");


            return "IT-B";

        }else
        return null;
    }

    public void one(View view) {
//        increase(1);
        Intent goToNextActivity = new Intent(getApplicationContext(), temp.class);
        classD=checkroll(Integer.parseInt(newmail));
        goToNextActivity.putExtra("user","1");
        goToNextActivity.putExtra("deptsec","ITA");
        startActivity(goToNextActivity);
    }

    public void two(View view) {
//        increase(2);
        Intent goToNextActivity = new Intent(getApplicationContext(), temp.class);
//        startActivity(goToNextActivity);
        goToNextActivity.putExtra("user","2");
        goToNextActivity.putExtra("deptsec","ITA");
        startActivity(goToNextActivity);
    }

    public void three(View view) {
//        increase(3);
//        Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
        Intent goToNextActivity = new Intent(getApplicationContext(), temp.class);
        goToNextActivity.putExtra("deptsec","ITA");
        goToNextActivity.putExtra("user","3");
        startActivity(goToNextActivity);
    }

    public void four(View view) {
//        increase(4);
        Intent goToNextActivity = new Intent(getApplicationContext(), temp.class);
        goToNextActivity.putExtra("deptsec","ITA");
        goToNextActivity.putExtra("user","4");
        startActivity(goToNextActivity);
    }

    public void five(View view) {
//        increase(5);
        Intent goToNextActivity = new Intent(getApplicationContext(), temp.class);
        goToNextActivity.putExtra("deptsec","ITA");
        goToNextActivity.putExtra("user","5");
        startActivity(goToNextActivity);
    }

    private void increase(Integer stud) {
        upvotesRef.runTransaction(new Transaction.Handler() {
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
                Intent goToNextActivity = new Intent(getApplicationContext(), done.class);
                startActivity(goToNextActivity);
                System.out.println("Transaction completed");
                if (databaseError != null) {
                    Log.i("EEEE", "" + databaseError);

                }
            }
        });
//return 0;
    }

    @Override
    public void onClick(View v) {
        upvotesRef.runTransaction(new Transaction.Handler() {
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
                Intent goToNextActivity = new Intent(getApplicationContext(), done.class);
                startActivity(goToNextActivity);
                System.out.println("Transaction completed");
                if (databaseError != null) {
                    Log.i("EEEE", "" + databaseError);

                }
            }
        });
    }
//    @override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

}

