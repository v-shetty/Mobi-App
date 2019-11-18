package com.example.my_application;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashBoardActivity extends AppCompatActivity {

  Button btn1,btn2,btn3,btn4,btn5,btn6;
  TextView txt1, txt2, txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
  ToggleButton tb1,tb2;



    DatabaseReference Emission;
    DatabaseReference Temp;
    DatabaseReference Pressure;
    DatabaseReference Battery;
    DatabaseReference Door;
    DatabaseReference Engine;
    DatabaseReference Service;
    DatabaseReference Status;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dashboard);


        Emission = FirebaseDatabase.getInstance().getReference().child("Emission");
        Temp = FirebaseDatabase.getInstance().getReference().child("Temperature");
        Pressure = FirebaseDatabase.getInstance().getReference().child("Pressure");
        Battery = FirebaseDatabase.getInstance().getReference().child("Battery");
        Door = FirebaseDatabase.getInstance().getReference().child("Door");
        Engine = FirebaseDatabase.getInstance().getReference().child("Engine");
        Service = FirebaseDatabase.getInstance().getReference().child("Service");
        Status = FirebaseDatabase.getInstance().getReference().child("Status");



        btn1= (Button)findViewById(R.id.btn1);
        btn2= (Button)findViewById(R.id.btn2);
        btn3= (Button)findViewById(R.id.btn3);
        btn4= (Button)findViewById(R.id.btn4);


        tb1 = (ToggleButton)findViewById(R.id.tb1);
        tb2 = (ToggleButton)findViewById(R.id.tb2);




        txt1 = (TextView)findViewById(R.id.txt1) ;
        txt2 = (TextView)findViewById(R.id.txt2) ;
        txt3 = (TextView)findViewById(R.id.txt3) ;
        txt4 = (TextView)findViewById(R.id.txt4) ;
        txt5 = (TextView)findViewById(R.id.txt5) ;
        txt6 = (TextView)findViewById(R.id.txt6) ;
        txt7 = (TextView)findViewById(R.id.txt7) ;
        txt8 = (TextView)findViewById(R.id.txt8) ;











        //---------- Firebase Reference ---------------------
        Emission.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                String emission = "Emission : " + value;
                txt1.setText(emission);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Temp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                String temp = "Temperature : " + value;
                txt2.setText(temp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Pressure.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                String pressure = "Pressure : " + value;
                txt3.setText(pressure);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Battery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                String battery = "Battery Level : " + value;
                txt4.setText(battery);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        Status.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                String status = "Car Status : " + value;
                txt8.setText(status);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Service.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                String service = "Next Service Date : " + value;
                txt7.setText(service);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //////////////// Toggle Button


        tb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Door.setValue("1");
                } else {
                    Door.setValue("0");
                }
            }
        });


        tb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Engine.setValue("1");
                } else {
                    Engine.setValue("0");
                }
            }
        });





    }
}
