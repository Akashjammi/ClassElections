package com.jammi.akash.classelection;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    // TODO: Add member variables here:
    private FirebaseAuth mAuth;
    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    Button login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (EditText) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);
        login = findViewById(R.id.loginButton);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });



        // TODO: Grab an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

    }
    public void login(View view){
        attemptLogin();
    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v) {
        // TODO: Call attemptLogin() here
        attemptLogin();

    }

//        // Executed when Register button pressed
//        public void registerNewUser(View v) {
//            Intent intent = new Intent(this, com.jenniferlopez.CE_SVCEnewfirebase.RegisterActivity.class);
//            finish();
//            startActivity(intent);
//        }

        // TODO: Complete the attemptLogin() method
        private void attemptLogin() {

            String email = mEmailView.getText().toString();
            String password = mPasswordView.getText().toString();

            if (email.isEmpty())
                if (email.equals("") || password.equals("")) return;
            Toast.makeText(this, "Login in progress...", Toast.LENGTH_SHORT).show();

            // TODO: Use FirebaseAuth to sign in with email & password
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    Log.d("CE_SVCE", "signInWithEmail() onComplete: " + task.isSuccessful());

                    if (!task.isSuccessful()) {
                        Log.d("CE_SVCE", "Problem signing in: " + task.getException());
//                        showErrorDialog("There was a problem signing in");
                    } else {
                        Intent intent = new Intent(Login.this,Voting.class);
                        finish();
                        startActivity(intent);
                    }

                }
            });


        }

//        // TODO: Show error on screen with an alert dialog
        private void showErrorDialog(String message) {

            new AlertDialog.Builder(this)
                    .setTitle("Oops")
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
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