package com.example.travelpartner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rentlist extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference dbRef;
    MyAdepter myAdepter;
    ArrayList<RentVehicle> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentlist);

        recyclerView =findViewById(R.id.rentList);
        dbRef = FirebaseDatabase.getInstance().getReference("RentVehicle");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdepter = new MyAdepter(this,list);
        recyclerView.setAdapter(myAdepter);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    RentVehicle rentVehicle = dataSnapshot.getValue(RentVehicle.class);
                    list.add(rentVehicle);
                }
                myAdepter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}