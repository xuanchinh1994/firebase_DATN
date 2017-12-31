package com.example.chinh.firebase_datn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btn_led;
    private ToggleButton toggle_led;
    private ToggleButton toggle_door;
    private ToggleButton toggle_guest;
    private ToggleButton toggle_warning;
    private FirebaseDatabase db;
    private DatabaseReference mDatabase_led;
    private DatabaseReference mDatabase_door;
    private DatabaseReference mDatabase_guest;
    private DatabaseReference mDatabase_warning;
    private DatabaseReference mDatabase_temp;
    private TextView textView;
    private TextView temp;
    private TextView date;
    private Calendar calendar;
    private SimpleDateFormat simpleDateFormat;
    private String Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView) findViewById(R.id.textView);
        temp = (TextView) findViewById(R.id.temp);
        mDatabase_led = FirebaseDatabase.getInstance().getReference("led");
        mDatabase_temp = FirebaseDatabase.getInstance().getReference("temp");
        mDatabase_door = FirebaseDatabase.getInstance().getReference("door");
        mDatabase_guest = FirebaseDatabase.getInstance().getReference("theft");
        mDatabase_warning = FirebaseDatabase.getInstance().getReference("warning");
        toggle_led = (ToggleButton) findViewById(R.id.toggle_led);
        toggle_door = (ToggleButton) findViewById(R.id.toggle_door);
        toggle_guest = (ToggleButton) findViewById(R.id.toggle_guest);
        toggle_warning = (ToggleButton) findViewById(R.id.toggle_waring);
        date = (TextView) findViewById(R.id.date);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date = simpleDateFormat.format(calendar.getTime());

        mDatabase_temp.child("temp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                temp.setText((dataSnapshot.getValue().toString())+ " \u2103");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        date.setText(Date);

        mDatabase_led.child("led_1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                textView.setText(dataSnapshot.getValue().toString());
                if (dataSnapshot.getValue().toString() == "0"){
                    toggle_led.setChecked(true);
                }else {
                    toggle_led.setChecked(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        toggle_led.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    mDatabase_led.child("led_1").setValue(0);
                }
                else
                {
                    mDatabase_led.child("led_1").setValue(1);
                }
            }
        });

        mDatabase_door.child("door_1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                textView.setText(dataSnapshot.getValue().toString());
                if (dataSnapshot.getValue().toString() == "0"){
                    toggle_door.setChecked(true);
                }else {
                    toggle_door.setChecked(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        toggle_door.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    mDatabase_door.child("door_1").setValue(0);
                }
                else
                {
                    mDatabase_door.child("door_1").setValue(1);
                }
            }
        });

        mDatabase_guest.child("theft_1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                textView.setText(dataSnapshot.getValue().toString());
                if (dataSnapshot.getValue().toString() == "0"){
                    toggle_guest.setChecked(true);
                }else {
                    toggle_guest.setChecked(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        toggle_guest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    mDatabase_guest.child("theft_1").setValue(0);
                }
                else
                {
                    mDatabase_guest.child("theft_1").setValue(1);
                }
            }
        });

        mDatabase_warning.child("warning_1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                textView.setText(dataSnapshot.getValue().toString());
                if (dataSnapshot.getValue().toString() == "0"){
                    toggle_warning.setChecked(true);
                }else {
                    toggle_warning.setChecked(false);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        toggle_warning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    mDatabase_warning.child("warning_1").setValue(0);
                }
                else
                {
                    mDatabase_warning.child("warning_1").setValue(1);
                }
            }
        });
    }
}
