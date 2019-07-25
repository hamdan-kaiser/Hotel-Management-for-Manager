package com.example.virus.hotelmanagementsystem.RoomStatus;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.virus.hotelmanagementsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.managerDetail;
import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.roomDetails;

public class RoomStatus extends AppCompatActivity {

    TextView floorView,roomView;
    Button checkBtn;
    Spinner floorSpinner,roomSpinner;

    TextView floorText, roomText, statusText, typeText;

    DatabaseReference reference;

    ArrayAdapter<String> adapter;
    ArrayList<RoomStatusDetailModel> detailModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_status);

        reference = FirebaseDatabase.getInstance().getReference();

        //Spinner Calls....
        floorSpinner = findViewById(R.id.statusSpin);
        roomSpinner = findViewById(R.id.roomNoStatusSpin);
        floorView = findViewById(R.id.floorTextView);
        roomView = findViewById(R.id.room_No_TextView);

        floorText = findViewById(R.id.floorText);
        roomText = findViewById(R.id.roomText);
        statusText = findViewById(R.id.statusText);
        typeText = findViewById(R.id.typeText);

        //add FloorSpinner Value from array String....
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter
                .createFromResource(this, R.array.floor_number,
                        android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorSpinner.setAdapter(arrayAdapter);

        floorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        ArrayAdapter<CharSequence> arrayAdapter1 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_1, android.R.layout.simple_spinner_item);
                        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter1);
                        String text = parent.getItemAtPosition(position).toString();
                        floorView.setText(text);
                        break;

                    case 1:
                        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_2, android.R.layout.simple_spinner_item);
                        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter2);
                        String text1 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text1);
                        break;

                    case 2:
                        ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_3, android.R.layout.simple_spinner_item);
                        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter3);
                        String text2 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text2);
                        break;

                    case 3:
                        ArrayAdapter<CharSequence> arrayAdapter4 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_4, android.R.layout.simple_spinner_item);
                        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter4);
                        String text3 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text3);
                        break;

                    case 4:
                        ArrayAdapter<CharSequence> arrayAdapter5 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_5, android.R.layout.simple_spinner_item);
                        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter5);
                        String text4 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text4);
                        break;

                    /*case 5:
                        ArrayAdapter<CharSequence> arrayAdapter6 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_6, android.R.layout.simple_spinner_item);
                        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter6);
                        String text5 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text5);
                        break;

                    case 6:
                        ArrayAdapter<CharSequence> arrayAdapter7 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_7, android.R.layout.simple_spinner_item);
                        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter7);
                        String text6 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text6);
                        break;

                    case 7:
                        ArrayAdapter<CharSequence> arrayAdapter8 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_8, android.R.layout.simple_spinner_item);
                        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter8);
                        String text7 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text7);
                        break;

                    case 8:
                        ArrayAdapter<CharSequence> arrayAdapter9 = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_9, android.R.layout.simple_spinner_item);
                        arrayAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter9);
                        String text8 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text8);
                        break;

                    case 9:
                        ArrayAdapter<CharSequence> arrayAdapterTen = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_ten, android.R.layout.simple_spinner_item);
                        arrayAdapterTen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapterTen);
                        String text9 = parent.getItemAtPosition(position).toString();
                        floorView.setText(text9);
                        break;

                    case 10:
                        ArrayAdapter<CharSequence> arrayAdapterEleven = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_eleven, android.R.layout.simple_spinner_item);
                        arrayAdapterEleven.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapterEleven);
                        String textTen = parent.getItemAtPosition(position).toString();
                        floorView.setText(textTen);
                        break;

                    case 11:
                        ArrayAdapter<CharSequence> arrayAdapterTwelve = ArrayAdapter
                                .createFromResource(RoomStatus.this, R.array.floor_number_twelve, android.R.layout.simple_spinner_item);
                        arrayAdapterTwelve.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapterTwelve);
                        String textEleven = parent.getItemAtPosition(position).toString();
                        Log.e("flor::::::::", "" + textEleven);
                        floorView.setText(textEleven);
                        break;

                    default:*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        roomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String textForRoom = parent.getItemAtPosition(position).toString();
                Log.e("111111111: ", "" + textForRoom);
                roomView.setText(textForRoom);

                reference.child(managerDetail)
                        .child(roomDetails)
                        .child(textForRoom.trim())
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                RoomStatusDetailModel detailModel = dataSnapshot.getValue(RoomStatusDetailModel.class);

                                assert detailModel != null;
                                floorText.setText("Floor No: " + detailModel.getFlNo());
                                roomText.setText("Room No: " +  detailModel.getRoomno());
                                statusText.setText("Room Status: " +  detailModel.getStatus());
                                typeText.setText("Room Description: " +  detailModel.getType());
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                // TODO: Stop Loading
                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
