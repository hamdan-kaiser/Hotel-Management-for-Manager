package com.example.virus.hotelmanagementsystem.BookingAndRatingDetails;

public class AddUserDetailsModel {

    String username;

    public AddUserDetailsModel(String username) {
        this.username = username;
    }

    public AddUserDetailsModel() {
        //khailla constructor
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
