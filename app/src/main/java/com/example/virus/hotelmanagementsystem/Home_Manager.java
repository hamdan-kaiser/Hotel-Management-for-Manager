package com.example.virus.hotelmanagementsystem;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.virus.hotelmanagementsystem.AddRoom.AddRoomActivity;
import com.example.virus.hotelmanagementsystem.BookingAndRatingDetails.ViewBookingActivity;
import com.example.virus.hotelmanagementsystem.RoomStatus.RoomStatus;
import com.google.firebase.auth.FirebaseAuth;


/**
 * This class does the following
 * 1. Can add rooms with its facilities
 * 2. Can check booking list
 * 3. The booking list automatically downloads from the firebase if the manager is signed in
 * 4. Stores data to firebase as requirements
 *
 * */

public class Home_Manager extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button addRoom, bookingList, roomStatus;

    FirebaseAuth firebaseAuth;
    ProgressDialog dialog;
    SharedPreferences preferences;
    String uname;
    private FirebaseAuth.AuthStateListener authStateListener;
    private long backpressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_manager);
        addRoom = findViewById(R.id.room_add);
        bookingList = findViewById(R.id.book_list);
        roomStatus = findViewById(R.id.room_avail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();


        //Animated Button
        handleAnimation(addRoom);
        handleAnimation(bookingList);
        handleAnimation(roomStatus);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //check login data

        preferences = Home_Manager.this.getSharedPreferences("LoginData", MODE_PRIVATE);

        uname = preferences.getString("name", null);


        //Add room
        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddRoomActivity.class);
                startActivity(intent);
            }
        });


        //check booking lists
        bookingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ViewBookingActivity.class);
                startActivity(intent);
            }
        });


        //checking room status
        roomStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RoomStatus.class);
                startActivity(intent);
            }
        });
    }

    public void handleAnimation(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(addRoom, "x", 165f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(bookingList, "x", 120f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(roomStatus, "x", 170f);
        animator.setDuration(2000);
        animator2.setDuration(2000);
        animator3.setDuration(2000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.playTogether(animator2);
        animatorSet.playTogether(animator3);
        animatorSet.start();


    }

    @Override
    public void onBackPressed() {

        //to exit from this application...

        if (backpressed + 2000 > System.currentTimeMillis()) {

            //user need to tap twice under 2 seconds to exit
            super.onBackPressed();
            //moveTaskToBack(true);
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        }

        backpressed = System.currentTimeMillis();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logOut) {

            firebaseAuth.signOut();

            SharedPreferences.Editor editor = preferences.edit();
            /*editor.putBoolean(isUserLoggedIn,false);
            editor.putString(userEmail,"");
            editor.putString(userPass,"");*/
            editor.clear();
            editor.apply();

           /* editor = preferences.edit();
            editor.putBoolean(isUserLoggedIn,false);
            editor.putString(userEmail," ");
            editor.apply();*/

            Intent intent = new Intent(Home_Manager.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
