package com.example.virus.hotelmanagementsystem.DatabaseModel;

public class AddClassModel {
    private String managername;
    private String floorNo;
    private String roomno;
    private String status;
    private String type;

    public AddClassModel(String mname, String fno, String roomno, String state, String typ) {
        this.managername = mname;
        this.floorNo = fno;
        this.roomno = roomno;
        this.status = state;
        this.type = typ;
    }

    public AddClassModel() {

    }

    public String getFlNo() {
        return floorNo;
    }

    public void setFlNo(String flNo) {
        this.floorNo = flNo;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
