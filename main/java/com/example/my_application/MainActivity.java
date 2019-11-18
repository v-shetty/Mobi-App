package com.example.my_application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    EditText mtxt;
    Button mbtn;
    TextView mtxt2;

    DatabaseReference myRef;
    DatabaseReference myRef2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxt = (EditText)findViewById(R.id.mtxt);
        mbtn = (Button)findViewById(R.id.mbtn);
        mtxt2 = (TextView)findViewById(R.id.mtxt2);
        Toast.makeText(MainActivity.this, "This is my Toast message!before ",
                Toast.LENGTH_LONG).show();

        myRef = FirebaseDatabase.getInstance().getReference().child("msg1");
        myRef2 = FirebaseDatabase.getInstance().getReference().child("Vikas");

        // Read from the database
        /*myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                txt2.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });*/




        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                mtxt2.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference connectedRef = FirebaseDatabase.getInstance().getReference(".info/connected");
        connectedRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean connected = snapshot.getValue(Boolean.class);
                if (connected) {
                    Toast.makeText(MainActivity.this, "Database connected",
                            Toast.LENGTH_LONG).show();;
                } else {
                    Toast.makeText(MainActivity.this, "Database not connected",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "database cancelled",
                        Toast.LENGTH_LONG).show();
            }
        });


        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String tosend;

                tosend = mtxt.getText().toString();
                Toast.makeText(MainActivity.this, "entered",
                        Toast.LENGTH_LONG).show();
                myRef.setValue(tosend, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {





                        Toast.makeText(MainActivity.this, "this is on complete",
                                Toast.LENGTH_LONG).show();
                    }
                });



            }
        });




    }
}
