package com.example.virus.hotelmanagementsystem.DatabaseModel;

public class AddGuestDetailModel {

    private String amountTopay;
    private String checkIn;
    private String checkOut;
    private String contact;
    private String discount;
    private String guestName;
    private String paymentStatus;
    private String rating;
    private String review;
    private String roomNo;
    private String roomType;


    public AddGuestDetailModel(String amountTopay, String rating, String roomNo,
                               String contact, String roomType, String review,
                               String discount, String guestName, String checkIn,
                               String paymentStatus, String checkOut) {
        this.amountTopay = amountTopay;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.contact = contact;
        this.discount = discount;
        this.guestName = guestName;
        this.paymentStatus = paymentStatus;
        this.rating = rating;
        this.review = review;
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public AddGuestDetailModel() {
        //blank constructor
    }

    //Alt+insert
    public String getAmountTopay() {
        return amountTopay;
    }

    public void setAmountTopay(String amountTopay) {
        this.amountTopay = amountTopay;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
