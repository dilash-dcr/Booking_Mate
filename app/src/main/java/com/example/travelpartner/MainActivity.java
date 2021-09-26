package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView btmnavi=findViewById(R.id.bottom_navigation);

        btmnavi.setSelectedItemId(R.id.home);

        btmnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
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

    public void account(View view)
    {
        Intent intent=new Intent(this,Account.class);
        startActivity(intent);
    }

    public void booking(View view)
    {
        Intent intent=new Intent(this,Booking_Home.class);
        startActivity(intent);
    }

    public void rent(View view)
    {
        Intent intent=new Intent(this,Rent.class);
        startActivity(intent);
    }

    public void share(View view)
    {
        Intent intent=new Intent(this,Share.class);
        startActivity(intent);
    }

    public void logout(View view)
    {
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
    }
}