package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Account extends AppCompatActivity {

    EditText name,uname,email,password,cnumber;
    String UN;
    DatabaseReference dbacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        name=findViewById(R.id.name);
        uname=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cnumber=findViewById(R.id.contactnumber);



        UN=getIntent().getStringExtra("Username");



                dbacc= FirebaseDatabase.getInstance().getReference().child("Users").child(UN);
                dbacc.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if(snapshot.hasChildren())
                        {
                            name.setText(snapshot.child("fname").getValue().toString());
                            uname.setText(snapshot.child("fname").getValue().toString()+snapshot.child("lname").getValue().toString());
                            email.setText(snapshot.child("email").getValue().toString()+".com");
                            password.setText(snapshot.child("password").getValue().toString());
                            cnumber.setText(snapshot.child("phone").getValue().toString());
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

         BottomNavigationView btmnavi=findViewById(R.id.bottom_navigation);

        btmnavi.setSelectedItemId(R.id.account);

        btmnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.account:
                        return  true;

                    case R.id.booking:
                        startActivity(new Intent(getApplicationContext(),Booking_Home.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.rent:
                        startActivity(new Intent(getApplicationContext(),Rent.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.share:
                        startActivity(new Intent(getApplicationContext(),Share.class));
                        overridePendingTransition(0,0);
                        return  true;
                }

                return false;
            }
        });

    }

    public void reqests(View view)
    {
        Intent intent=new Intent(this,share_request_display.class);
        startActivity(intent);
    }

}









