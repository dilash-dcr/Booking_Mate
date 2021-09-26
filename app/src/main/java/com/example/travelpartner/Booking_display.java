package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Booking_display extends AppCompatActivity {

    EditText bid,bookingid,name,uid,adid,address,tspoint,tepoint,npassengers,ndays,cnumber;
    Button search,update,delete;
    String BID;

    Bookings bdisplay;
    Bookings bupdate;
    Bookings bdelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_display);


        name=findViewById(R.id.v_name);
        uid=findViewById(R.id.v_uid);
        adid=findViewById(R.id.v_adid);
        address=findViewById(R.id.v_address);
        tspoint=findViewById(R.id.v_spoint);
        tepoint=findViewById(R.id.v_epoint);
        npassengers=findViewById(R.id.v_npassengers);
        ndays=findViewById(R.id.v_ndays);
        cnumber=findViewById(R.id.v_cnumber);

        search=findViewById(R.id.btn_search);
        update=findViewById(R.id.btn_update);
        delete=findViewById(R.id.btn_delete);

        bdisplay=new Bookings();


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bid=findViewById(R.id.v_bid);
                bdisplay.setBid(bid.getText().toString());
                BID=bdisplay.getBid();

                DatabaseReference bdisplay= FirebaseDatabase.getInstance().getReference().child("Bookings").child(BID);
                bdisplay.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren())
                        {
                        name.setText(snapshot.child("name").getValue().toString());
                        uid.setText(snapshot.child("uid").getValue().toString());
                        adid.setText(snapshot.child("advertistmentID").getValue().toString());
                        address.setText(snapshot.child("address").getValue().toString());
                        tspoint.setText(snapshot.child("starstingPoint").getValue().toString());
                        tepoint.setText(snapshot.child("endPoint").getValue().toString());
                        npassengers.setText(snapshot.child("noOfPassengers").getValue().toString());
                        ndays.setText(snapshot.child("noofDays").getValue().toString());
                        cnumber.setText(snapshot.child("contactNo").getValue().toString());
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"There is No booking regarding this ID",Toast.LENGTH_SHORT).show();
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

                bid=findViewById(R.id.v_bid);
                bdisplay.setBid(bid.getText().toString());
                BID=bdisplay.getBid();

                DatabaseReference bupdate= FirebaseDatabase.getInstance().getReference().child("Bookings");

                try{

                    if(TextUtils.isEmpty(name.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(uid.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(adid.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(address.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(tspoint.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(tepoint.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(npassengers.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(ndays.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        bdisplay.setName(name.getText().toString().trim());
                        bdisplay.setUid(uid.getText().toString());
                        bdisplay.setAdvertistmentID(adid.getText().toString());
                        bdisplay.setAddress(address.getText().toString());
                        bdisplay.setStarstingPoint(tspoint.getText().toString());
                        bdisplay.setEndPoint(tepoint.getText().toString());
                        bdisplay.setNoOfPassengers(Integer.parseInt(npassengers.getText().toString()));
                        bdisplay.setNoofDays(Integer.parseInt(ndays.getText().toString()));
                        bdisplay.setContactNo(Integer.parseInt(cnumber.getText().toString().trim()));

                        boolean sucess=validation(Integer.parseInt(npassengers.getText().toString()),cnumber.getText().toString(),Integer.parseInt(ndays.getText().toString()));

                        if(sucess==true) {
                            bupdate.child(BID).setValue(bdisplay);
                            Toast.makeText(getApplicationContext(), "Booking Update Was Successful", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
                        }

                    }

                }catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Enter a valid Contact No",Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bid=findViewById(R.id.v_bid);
                bdisplay.setBid(bid.getText().toString());
                BID=bdisplay.getBid();
                DatabaseReference bdelete=FirebaseDatabase.getInstance().getReference().child("Bookings").child(BID);
                bdelete.removeValue();
                Toast.makeText(getApplicationContext(),"Booking Deleted Successfully",Toast.LENGTH_SHORT).show();
                clearFeilds4();
            }
        });

    }

    public void clearFeilds4()
    {

        name.setText("");
        uid.setText("");
        adid.setText("");
        address.setText("");
        tspoint.setText("");
        tepoint.setText("");
        npassengers.setText("");
        ndays.setText("");
        cnumber.setText("");


    }

    public boolean validation(int noPassenger,String Contactnumber,int Nodays)
    {
        if(noPassenger<=0)
        {
            npassengers.requestFocus();
            npassengers.setError("No of passengers cannot be 0 or (-) value");
            return false;
        }
        else if(Contactnumber.length()==0)
        {
            cnumber.requestFocus();
            cnumber.setError("Contact No cannot be Empty");
            return false;
        }
        else if(!Contactnumber.matches("^[0-9]{10}$"))
        {
            cnumber.requestFocus();
            cnumber.setError("Number should be +94077xxxxxxxx");
            return false;
        }
        else if(Nodays<=0 || Nodays>10)
        {
            ndays.requestFocus();
            ndays.setError("No of days should be between 0 - 10");
            return false;
        }
        else
        {
            return true;
        }
    }




}