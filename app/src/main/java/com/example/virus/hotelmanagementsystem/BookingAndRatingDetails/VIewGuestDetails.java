package com.example.virus.hotelmanagementsystem.BookingAndRatingDetails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.virus.hotelmanagementsystem.R;

import java.util.Objects;

public class VIewGuestDetails extends AppCompatActivity {

    TextView amountPay, checkIn, checkOut, contact, discount, guest_name, payStatus, rating, review, roomNo, roomType;
    String amount, checkin, checkout, contactDetail, discounts, guestName, paymentStatus,
            ratingView, reviewDetail, roomno, roomtype;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_guest_details);
        dialog = new ProgressDialog(VIewGuestDetails.this);
        dialog.setMessage("Downloading data from server, Please Wait");
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.show();

        amountPay = findViewById(R.id.amountToPay);
        checkIn = findViewById(R.id.checkIn);
        checkOut = findViewById(R.id.checkOut);
        contact = findViewById(R.id.contact);
        discount = findViewById(R.id.discount);
        guest_name = findViewById(R.id.guest_name);
        payStatus = findViewById(R.id.paidyn);
        rating = findViewById(R.id.rating);
        review = findViewById(R.id.review);
        roomNo = findViewById(R.id.room_No);
        roomType = findViewById(R.id.room_Type);

        Intent intent = getIntent();

        amount = Objects.requireNonNull(intent).getStringExtra("amount");
        checkin = Objects.requireNonNull(intent).getStringExtra("checkIn");
        checkout = Objects.requireNonNull(intent).getStringExtra("checkOut");
        contactDetail = Objects.requireNonNull(intent).getStringExtra("contact");
        discounts = Objects.requireNonNull(intent).getStringExtra("discount");
        guestName = Objects.requireNonNull(intent).getStringExtra("guestName");
        paymentStatus = Objects.requireNonNull(intent).getStringExtra("paymentStatus");
        ratingView = Objects.requireNonNull(intent).getStringExtra("rating");
        reviewDetail = Objects.requireNonNull(intent).getStringExtra("review");
        roomno = Objects.requireNonNull(intent).getStringExtra("roomNo");
        roomtype = Objects.requireNonNull(intent).getStringExtra("roomType");

        if (dialog.isShowing()) {
            dialog.dismiss();
        }

        amountPay.setText("Payment Details: " + amount);
        checkIn.setText("Check In: " + checkin);
        checkOut.setText("Check Out: " + checkout);
        contact.setText("Mobile: " + contactDetail);
        discount.setText("Discount(s) Offered: " + discounts);
        guest_name.setText("Guest Name: " + guestName);
        payStatus.setText("Paid? " + paymentStatus);
        rating.setText(guestName + " has rated " + ratingView);
        review.setText(guestName + " said- "+ reviewDetail);
        roomNo.setText("Room No: " + roomno);
        roomType.setText("Room Type: " + roomtype);

    }
}
