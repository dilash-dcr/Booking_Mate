package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Booking extends AppCompatActivity {

    EditText name,uid,adid,address,tripstart,tripend,noofpassenger,nodays,contactno,bookingID;
    Button maketheBooking;

    long bookingid=0;

    Bookings makeAbooking;

    DatabaseReference bookingref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        name=findViewById(R.id.booking_name);
        uid=findViewById(R.id.booking_uid);
        adid=findViewById(R.id.booking_adid);
        address=findViewById(R.id.booking_address);
        tripstart=findViewById(R.id.booking_tripstart);
        tripend=findViewById(R.id.booking_tripend);
        noofpassenger=findViewById(R.id.booking_nopassengers);
        nodays=findViewById(R.id.booking_nodays);
        contactno=findViewById(R.id.booking_contactno);
        bookingID=findViewById(R.id.bookingid);

        maketheBooking=findViewById(R.id.btn_makethebooking);

        makeAbooking=new Bookings();

        bookingref= FirebaseDatabase.getInstance().getReference().child("Bookings");
        bookingref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    bookingid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        maketheBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
                    else if(TextUtils.isEmpty(tripstart.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(tripend.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(noofpassenger.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(nodays.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        makeAbooking.setName(name.getText().toString().trim());
                        makeAbooking.setUid(uid.getText().toString());
                        makeAbooking.setAdvertistmentID(adid.getText().toString());
                        makeAbooking.setAddress(address.getText().toString());
                        makeAbooking.setStarstingPoint(tripstart.getText().toString());
                        makeAbooking.setEndPoint(tripend.getText().toString());
                        makeAbooking.setNoOfPassengers(Integer.parseInt(noofpassenger.getText().toString()));
                        makeAbooking.setNoofDays(Integer.parseInt(nodays.getText().toString()));
                        makeAbooking.setContactNo(Integer.parseInt(contactno.getText().toString().trim()));

                        boolean sucess=validation(Integer.parseInt(noofpassenger.getText().toString()),contactno.getText().toString(),Integer.parseInt(nodays.getText().toString()));

                        if(sucess==true)
                        {
                            bookingref.child(String.valueOf(bookingid)).setValue(makeAbooking);
                            Toast.makeText(getApplicationContext(),"Booking Successfully Added",Toast.LENGTH_SHORT).show();
                            clearFeilds3();
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

    }

    public void clearFeilds3()
    {
        name.setText("");
        uid.setText("");
        adid.setText("");
        address.setText("");
        tripstart.setText("");
        tripend.setText("");
        noofpassenger.setText("");
        nodays.setText("");
        contactno.setText("");
        bookingID.setText(String.valueOf(bookingid));
    }

    public boolean validation(int noPassenger,String Contactnumber,int Nodays)
    {
        if(noPassenger<=0)
        {
            noofpassenger.requestFocus();
            noofpassenger.setError("No of passengers cannot be 0 or (-) value");
            return false;
        }
        else if(Contactnumber.length()==0)
        {
            contactno.requestFocus();
            contactno.setError("Contact No cannot be Empty");
            return false;
        }
        else if(!Contactnumber.matches("^[0-9]{10}$"))
        {
            contactno.requestFocus();
            contactno.setError("Number should be +94077xxxxxxxx");
            return false;
        }
        else if(Nodays<=0 || Nodays>10)
        {
            nodays.requestFocus();
            nodays.setError("No of days should be between 0 - 10");
            return false;
        }
        else
        {
            return true;
        }
    }


}