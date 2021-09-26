package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Rent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        BottomNavigationView btmnavi=findViewById(R.id.bottom_navigation);

        btmnavi.setSelectedItemId(R.id.rent);

        btmnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.booking:
                        startActivity(new Intent(getApplicationContext(), Booking_Home .class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.rent:
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


    public void addrent(View view)
    {
        Intent intent=new Intent(this,Rent_add.class);
        startActivity(intent);
    }

    public void SearchARent (View view){
        Intent intent=new Intent( this,Post_Rent.class);
        startActivity(intent);
    }

    public void show (View view){
        Intent intent=new Intent( this,rentlist.class);
        startActivity(intent);
    }
}