package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class share_request_display extends AppCompatActivity {

    EditText usename,name,adID,yusernmae,rusername,contactNumber,meetingpoint;
    Button search;
    DatabaseReference dbsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_request_display);


        usename=findViewById(R.id.find_username);
        name=findViewById(R.id.etNameSV2);
        adID=findViewById(R.id.etshareIADID2);
        yusernmae=findViewById(R.id.etshareID2);
        rusername=findViewById(R.id.etUserIDSV2);
        contactNumber=findViewById(R.id.etContactNoSV2);
        meetingpoint=findViewById(R.id.etaddress2);

        search=findViewById(R.id.button3);

        dbsearch= FirebaseDatabase.getInstance().getReference().child("RideRequests").child(usename.getText().toString());
        dbsearch.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren())
                {
                    name.setText(snapshot.child("name").getValue().toString());
                    adID.setText(snapshot.child("adID").getValue().toString());
                    yusernmae.setText(snapshot.child("requesterUserName").getValue().toString());
                    rusername.setText(snapshot.child("yourUserName").getValue().toString());
                    contactNumber.setText(snapshot.child("contactNumber").getValue().toString());
                    meetingpoint.setText(snapshot.child("meetingPoint").getValue().toString());
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No data found",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}