package com.example.virus.hotelmanagementsystem.BookingAndRatingDetails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.virus.hotelmanagementsystem.DatabaseModel.AddGuestDetailModel;
import com.example.virus.hotelmanagementsystem.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.fbTouristDetails;

public class ViewBookingActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<AddGuestDetailModel> touristDetails = new ArrayList<>();

    ArrayList<String> username = new ArrayList<>();
    private ProgressDialog dialog;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_and_rating);

        listView = findViewById(R.id.usernameView);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        dialog = new ProgressDialog(ViewBookingActivity.this);
        dialog.setMessage("Downloading data from server, Please Wait");
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showListofUsers();
    }

    private void showListofUsers() {


        databaseReference.child(fbTouristDetails)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        username.clear();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            //Log.e("Testing>>>", snapshot.getKey());
                            username.add(snapshot.getKey());
                        }

                        for (int i = 0; i < username.size(); i++) {
                            Log.e("Testing>>>", "1");
                            databaseReference.child(fbTouristDetails)
                                    .child(username.get(i))
                                    .addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            if (dialog.isShowing()) {
                                                dialog.dismiss();
                                            }

                                            //Log.e("Testing>>>", "2    " + dataSnapshot);

                                            AddGuestDetailModel guestDetailModel = dataSnapshot.getValue(AddGuestDetailModel.class);
                                            //Log.e("Testing>>>", "4 = " + guestDetailModel);
                                            touristDetails.add(guestDetailModel);
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                        }

               /* for (int i = 0; i < touristDetails.size(); i++) {
                    Log.e("Testing Tourist--", touristDetails.get(i).getAmountTopay());
                }*/

                        adapter = new ArrayAdapter<>(ViewBookingActivity.this, android.R.layout.simple_list_item_1, username);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(ViewBookingActivity.this, VIewGuestDetails.class);
                                intent.putExtra("amount", touristDetails.get(position).getAmountTopay());
                                intent.putExtra("checkIn", touristDetails.get(position).getCheckIn());
                                intent.putExtra("checkOut", touristDetails.get(position).getCheckOut());
                                intent.putExtra("contact", touristDetails.get(position).getContact());
                                intent.putExtra("discount", touristDetails.get(position).getDiscount());
                                intent.putExtra("guestName", touristDetails.get(position).getGuestName());
                                intent.putExtra("paymentStatus", touristDetails.get(position).getPaymentStatus());
                                intent.putExtra("rating", touristDetails.get(position).getRating());
                                intent.putExtra("review", touristDetails.get(position).getReview());
                                intent.putExtra("roomNo", touristDetails.get(position).getRoomNo());
                                intent.putExtra("roomType", touristDetails.get(position).getRoomType());
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}
