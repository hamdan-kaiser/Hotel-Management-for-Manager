package com.example.virus.hotelmanagementsystem.AddRoom;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.virus.hotelmanagementsystem.DatabaseModel.AddClassModel;
import com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames;
import com.example.virus.hotelmanagementsystem.DatabaseModel.SetEventSerialToFb;
import com.example.virus.hotelmanagementsystem.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.managerDetail;
import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.roomDetails;
import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.roomNoDetails;
import static com.example.virus.hotelmanagementsystem.DatabaseModel.AllStaticNames.table;

public class AddRoomActivity extends AppCompatActivity {

    TextView floor, roomNo, status;
    EditText type;
    String floorno, roomno, staTus, tyPe;
    String managerName;
    Button SetOk;
    int eventSerial;
    Spinner floorSpinner, roomSpinner, available_spinner;
    private ProgressDialog dialog;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        //Spinner
        floorSpinner = findViewById(R.id.floorSpin);
        roomSpinner = findViewById(R.id.roomSpin);
        available_spinner = findViewById(R.id.availableSpin);

        //Floor No. Selection Spinner
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter
                .createFromResource(this, R.array.floor_number,
                        android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floorSpinner.setAdapter(arrayAdapter);

        //Status Selection Spinner

        ArrayAdapter<CharSequence> selectionSpinnerAdapter = ArrayAdapter
                .createFromResource(this, R.array.status,
                        android.R.layout.simple_spinner_item);
        selectionSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        available_spinner.setAdapter(selectionSpinnerAdapter);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        sharedPreferences = AddRoomActivity.this.getSharedPreferences(table, MODE_PRIVATE);
        managerName = sharedPreferences.getString(managerDetail, "");
        floor = findViewById(R.id.floor);
        roomNo = findViewById(R.id.room);
        status = findViewById(R.id.status);
        type = findViewById(R.id.type);
        SetOk = findViewById(R.id.okay);

        SetOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });

        floorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        ArrayAdapter<CharSequence> arrayAdapter1 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_1, android.R.layout.simple_spinner_item);
                        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter1);
                        String text = parent.getItemAtPosition(position).toString();
                        floor.setText(text);
                        break;
                    case 1:
                        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_2, android.R.layout.simple_spinner_item);
                        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter2);
                        String text1 = parent.getItemAtPosition(position).toString();
                        floor.setText(text1);
                        break;
                    case 2:
                        ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_3, android.R.layout.simple_spinner_item);
                        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter3);
                        String text2 = parent.getItemAtPosition(position).toString();
                        floor.setText(text2);
                        break;
                    case 3:
                        ArrayAdapter<CharSequence> arrayAdapter4 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_4, android.R.layout.simple_spinner_item);
                        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter4);
                        String text3 = parent.getItemAtPosition(position).toString();
                        floor.setText(text3);
                        break;
                    case 4:
                        ArrayAdapter<CharSequence> arrayAdapter5 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_5, android.R.layout.simple_spinner_item);
                        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter5);
                        String text4 = parent.getItemAtPosition(position).toString();
                        floor.setText(text4);
                        break;
                    /*case 5:
                        ArrayAdapter<CharSequence> arrayAdapter6 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_6, android.R.layout.simple_spinner_item);
                        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter6);
                        String text5 = parent.getItemAtPosition(position).toString();
                        floor.setText(text5);
                        break;
                    case 6:
                        ArrayAdapter<CharSequence> arrayAdapter7 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_7, android.R.layout.simple_spinner_item);
                        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter7);
                        String text6 = parent.getItemAtPosition(position).toString();
                        floor.setText(text6);
                        break;
                    case 7:
                        ArrayAdapter<CharSequence> arrayAdapter8 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_8, android.R.layout.simple_spinner_item);
                        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter8);
                        String text7 = parent.getItemAtPosition(position).toString();
                        floor.setText(text7);
                        break;
                    case 8:
                        ArrayAdapter<CharSequence> arrayAdapter9 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_9, android.R.layout.simple_spinner_item);
                        arrayAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapter9);
                        String text8 = parent.getItemAtPosition(position).toString();
                        floor.setText(text8);
                        break;
                    case 9:
                        ArrayAdapter<CharSequence> arrayAdapterTen = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_ten, android.R.layout.simple_spinner_item);
                        arrayAdapterTen.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapterTen);
                        String text9 = parent.getItemAtPosition(position).toString();
                        floor.setText(text9);
                        break;
                    case 10:
                        ArrayAdapter<CharSequence> arrayAdapterEleven = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_eleven, android.R.layout.simple_spinner_item);
                        arrayAdapterEleven.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapterEleven);
                        String textTen = parent.getItemAtPosition(position).toString();
                        floor.setText(textTen);
                        break;
                    case 11:
                        ArrayAdapter<CharSequence> arrayAdapterTwelve = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.floor_number_twelve, android.R.layout.simple_spinner_item);
                        arrayAdapterTwelve.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        roomSpinner.setAdapter(arrayAdapterTwelve);
                        String textEleven = parent.getItemAtPosition(position).toString();
                        Log.e("flor::::::::", "" + textEleven);
                        floor.setText(textEleven);
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

                String textForRoomNo2 = parent.getItemAtPosition(position).toString();
                Log.e("111111111: ", "" + textForRoomNo2);
                roomNo.setText(textForRoomNo2);

               /* switch (position) {

                    case 0:

                        String textForRoomNo = parent.getItemAtPosition(position).toString();
                        Log.e("111111111: ", "" + textForRoomNo);
                        roomNo.setText(textForRoomNo);
                        break;
                    case 1:
                        String textForRoomNo1 = parent.getItemAtPosition(position).toString();
                        Log.e("111111111: ", "" + textForRoomNo1);
                        roomNo.setText(textForRoomNo1);
                        break;
                    case 2:
                        String textForRoomNo2 = parent.getItemAtPosition(position).toString();
                        Log.e("111111111: ", "" + textForRoomNo2);
                        roomNo.setText(textForRoomNo2);
                        break;
                        default:
                }*/
                // bujhtesina kemne ki kormu
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        available_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String availableText = "" + parent.getItemAtPosition(position).toString().trim();
                Log.e("11111111111:", "" + availableText);
                status.setText(availableText);
               /* switch (position)

                {
                    case 0:
                        ArrayAdapter<CharSequence> statusAdapter = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.status,android.R.layout.simple_spinner_item);
                        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        available_spinner.setAdapter(statusAdapter);
                        String availableText = ""+parent.getItemAtPosition(position).toString().trim();
                        Log.e("11111111111:",""+availableText);
                        status.setText(availableText);
                        break;

                    case 1:
                        ArrayAdapter<CharSequence> statusAdapter2 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.status,android.R.layout.simple_spinner_item);
                        statusAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        available_spinner.setAdapter(statusAdapter2);
                        String availableText1 = ""+parent.getItemAtPosition(position).toString().trim();
                        Log.e("22222222222222:",""+availableText1);
                        status.setText(availableText1);
                        break;

                    case 2:
                        ArrayAdapter<CharSequence> statusAdapter3 = ArrayAdapter
                                .createFromResource(AddRoomActivity.this, R.array.status,android.R.layout.simple_spinner_item);
                        statusAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        available_spinner.setAdapter(statusAdapter3);
                        String availableText2 = ""+parent.getItemAtPosition(position).toString().trim();
                        Log.e("333333333333333333:",""+availableText2);
                        status.setText(availableText2);
                        break;


                    default:

                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void SaveData() {

        floorno = floor.getText().toString().trim();
        roomno = roomNo.getText().toString().trim();
        staTus = status.getText().toString().trim();
        tyPe = type.getText().toString().trim();
        dialog = new ProgressDialog(AddRoomActivity.this);
        dialog.setMessage("Updating data to server, Please Wait");
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.show();

        final AddClassModel addClassModel = new AddClassModel(managerName, floorno, roomno, staTus, tyPe);
        Log.e("MESSAGE::::: ", "KAJ HOISE");

        databaseReference.child(AllStaticNames.managerDetail).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                AddClassModel addClassModel1 = dataSnapshot.getValue(AddClassModel.class);
                SetEventSerialToFb eventSerialToFb = dataSnapshot.getValue(SetEventSerialToFb.class);

              /*  if (eventSerialToFb != null)
                    eventSerial = eventSerialToFb.getEventSerial() + 1;*/

                //Save Things to Firebase
                databaseReference.child(managerDetail).child(roomDetails)
                        .child(roomno)
                        .setValue(addClassModel);

                //Update Event Serial Number....

               /* databaseReference.child(managerDetail)
                        .child(AllStaticNames.eventSerial)
                        .setValue(eventSerial);*/

               /* if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                */
                Toast.makeText(getApplicationContext(), "Updated Successfully!!", Toast.LENGTH_SHORT).show();
                Log.e("MESSAGE::::: ", "DATABASE  e DHUKSE");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Data Saving Cancelled!", Toast.LENGTH_SHORT).show();
            }
        });


        finish();
    }
}
