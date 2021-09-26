package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Rent_add extends AppCompatActivity {

    EditText RentId, VehicleType, VehicleModel, AvailableSeats, VehiclePrice, Contact, Description;
    Button btnpost;
    DatabaseReference addrentdb;
    RentVehicle rv;

    long Rentid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_add);

        VehicleType = findViewById(R.id.type);
        VehicleModel = findViewById(R.id.model);
        AvailableSeats = findViewById(R.id.seats);
        VehiclePrice = findViewById(R.id.price);
        Contact = findViewById(R.id.contact);
        Description = findViewById(R.id.description);
        RentId = findViewById(R.id.Rentid);

        btnpost = findViewById(R.id.post);

        rv = new RentVehicle();

        addrentdb = FirebaseDatabase.getInstance().getReference().child("RentVehicles");
        addrentdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    Rentid =(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addrentdb = FirebaseDatabase.getInstance().getReference().child("RentVehicles");

                try{

                    if(TextUtils.isEmpty(VehicleType.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Type",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(VehicleModel.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Model",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(AvailableSeats.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Seats",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(VehiclePrice.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Price",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Contact.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Contact Number",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(Description.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Description",Toast.LENGTH_SHORT).show();
                    else{

                        rv.setVehicleType(VehicleType.getText().toString().trim());
                        rv.setVehicleModel(VehicleModel.getText().toString().trim());
                        rv.setAvailableSeats(AvailableSeats.getText().toString().trim());
                        rv.setVehiclePrice(VehiclePrice.getText().toString().trim());
                        rv.setContact(Contact.getText().toString().trim());
                        rv.setDescription(Description.getText().toString().trim());

                        addrentdb.child(String.valueOf(Rentid)).setValue(rv);
                        Toast.makeText(getApplicationContext(),"Succeessfuly Inserted",Toast.LENGTH_SHORT).show();

                        clearControls();
                    }
                }catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(), "Please Enter valid Data",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private void clearControls(){

        VehicleType.setText("");
        VehicleModel.setText("");
        AvailableSeats.setText("");
        VehiclePrice.setText("");
        Contact.setText("");
        Description.setText("");
        RentId.setText(String.valueOf(Rentid));
    }


}