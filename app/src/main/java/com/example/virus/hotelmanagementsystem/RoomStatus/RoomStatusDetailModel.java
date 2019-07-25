package com.example.virus.hotelmanagementsystem.RoomStatus;

public class RoomStatusDetailModel {

    String flNo;
    String roomno;
    String status;
    String type;

    public RoomStatusDetailModel(String floorNo, String roomNo, String status, String type)
    {
        this.flNo = floorNo;
        this.roomno = roomNo;
        this.status = status;
        this.type = type;
    }

    public RoomStatusDetailModel()
    {
        // blank constructor...
    }

    public void setFlNo(String flNo) {
        this.flNo = flNo;
    }

    public String getFlNo() {
        return flNo;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
