package com.example.virus.hotelmanagementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.isUserLoggedIn;


/**
 * A Hotel Management System Application
 * This application is made for Managers only
 *
 * What a manager can do using our Application?
 * 1. Can check booking list
 * 2. Check Room Status
 * 3. Can add/skip room numbers(with units) is wants
 * 4. Can check room availability status
 * 5. Can check whoever has checked in or out
 * 6. Notice whether any guests have due or not
 *
 *
 * Bugs to fix:
 * - staffs information should also be included
 * - boost performance
 *
 * This is our Testing Project
 *
 * Our Team Members are:
 *
 * Hamdan Kaiser - FrontEnd and BackEnd coder;
 * Monim Kaiser - FrontEnd and BackEnd coder;
 * Mumin Az Zahira - Firebase manager
 *
 * Special Thanks to
 * A.K.M Bahalul Haque*/

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button signin;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ProgressDialog dialog;
    private long backpressed;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);

        // Firebase Authentication
        firebaseAuth = FirebaseAuth.getInstance();
        preferences = MainActivity.this.getSharedPreferences("LoginData", MODE_PRIVATE);

        checkLogin();

        dialog = new ProgressDialog(this);

        /*authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    //it means that user has already signed in...
                    //if yes, it directly goes to onStart() here I called it
                    // implement a class here....
                    Log.e("TAG>>>", "" + firebaseAuth.getCurrentUser());
                    Intent intent = new Intent(MainActivity.this, Home_Manager.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        firebaseAuth.addAuthStateListener(authStateListener);*/

     /* Intent intent = new Intent(getApplicationContext(),FullscreenActivity.class);
      startActivity(intent);
*/
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSignedIn();
            }
        });

    }

    private void checkLogin() {

        //check if the user has logged in or not....

        Boolean checking = preferences.getBoolean(isUserLoggedIn, false);
        Log.e("Tag>>>", "------------------------ " + checking);

        if (checking) {

            Intent intent = new Intent(MainActivity.this, Home_Manager.class);
            startActivity(intent);
            finish();
        }

    }

    public void getSignedIn() {
        String email1 = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        dialog.setMessage("Signing in");
        dialog.show();

        if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(pass)) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "Fill each field!", Toast.LENGTH_SHORT).show();
        } else {
            firebaseAuth.signInWithEmailAndPassword(email1, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //add a class here....

                    if (task.isSuccessful()) {
                        Log.e("Message::::: ", "Logged In---------->!!!!!!!!");
                        dialog.dismiss();

                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean(isUserLoggedIn, true);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), Home_Manager.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email or password!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        //works if user is signed in
    }

    @Override
    public void onBackPressed() {

        if (backpressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            //moveTaskToBack(true);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(), "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        }

        backpressed = System.currentTimeMillis();
    }



}
