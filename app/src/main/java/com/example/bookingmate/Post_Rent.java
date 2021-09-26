package com.example.bookingmate;

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

public class Post_Rent extends AppCompatActivity {

    EditText Id,Type,Model,Seats,Price,Contact,Description;
    Button search,update,delete;


    String RID;
    RentVehicle rentdisplay;
    RentVehicle rupdate;
    RentVehicle bdelete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__rent);


        Type= findViewById(R.id.r_Type);
        Model = findViewById(R.id.r_Model);
        Seats= findViewById(R.id.r_Seats);
        Price = findViewById(R.id.r_Price);
        Contact = findViewById(R.id.r_Contact);
        Description = findViewById(R.id.r_Description);

        search = findViewById(R.id.btn_search);
        update=findViewById(R.id.btn_update);
        delete=findViewById(R.id.btn_delete);

        rentdisplay = new RentVehicle();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Id = findViewById(R.id.r_rid);
                rentdisplay.setId(Id.getText().toString());
                RID = rentdisplay.getId();

                DatabaseReference rentdisplay = FirebaseDatabase.getInstance().getReference().child("RentVehicles").child(RID);
                rentdisplay.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChildren())
                        {
                            Type.setText(snapshot.child("VehicleType").getValue().toString());
                            Model.setText(snapshot.child("VehicleModel").getValue().toString());
                            Seats.setText(snapshot.child("AvailableSeats").getValue().toString());
                            Price.setText(snapshot.child("VehiclePrice").getValue().toString());
                            Contact.setText(snapshot.child("Contact").getValue().toString());
                            Description.setText(snapshot.child("description").getValue().toString());
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"There is No Rent Id regarding this ID",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Id = findViewById(R.id.r_rid);
                rentdisplay.setId(Id.getText().toString());
                RID = rentdisplay.getId();
                DatabaseReference rupdate = FirebaseDatabase.getInstance().getReference().child("RentVehicles");
                try{

                    if(TextUtils.isEmpty(Type.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(Model.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(Seats.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(Price.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(Contact.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(Description.getText().toString()))
                    {

                    }

                    else
                    {
                        rentdisplay.setVehicleType(Type.getText().toString().trim());
                        rentdisplay.setVehicleType(Model.getText().toString().trim());
                        rentdisplay.setVehicleType(Seats.getText().toString().trim());
                        rentdisplay.setVehicleType(Price.getText().toString().trim());
                        rentdisplay.setVehicleType(Contact.getText().toString().trim());
                        rentdisplay.setVehicleType(Description.getText().toString().trim());

                        rupdate.child(RID).setValue(rentdisplay);
                        Toast.makeText(getApplicationContext(),"Rent Update Was Successful",Toast.LENGTH_SHORT).show();


                    }

                } catch (NumberFormatException ee) {
                    Toast.makeText(getApplicationContext(),"Enter valid Data",Toast.LENGTH_SHORT).show();;
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Id=findViewById(R.id.r_rid);
                rentdisplay.setId(Id.getText().toString());
                RID=rentdisplay.getId();
                DatabaseReference bdelete=FirebaseDatabase.getInstance().getReference().child("RentVehicles").child(RID);
                bdelete.removeValue();
                Toast.makeText(getApplicationContext(),"Rent Deleted Successfully",Toast.LENGTH_SHORT).show();
                clearFeilds4();
            }
        });

    }
    public void clearFeilds4()
    {

        Type.setText("");
        Model.setText("");
        Seats.setText("");
        Price.setText("");
        Contact.setText("");
        Description.setText("");


    }
}