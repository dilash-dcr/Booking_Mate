package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Share extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        BottomNavigationView btmnavi=findViewById(R.id.bottom_navigation);

        btmnavi.setSelectedItemId(R.id.share);

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
                        startActivity(new Intent(getApplicationContext(),Rent.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.share:
                        return  true;
                }

                return false;
            }
        });
    }

    public void reqestform(View view)
    {
        Intent in=new Intent(this,Share_request.class);
        startActivity(in);
    }

    public void postAride(View view)
    {
        Intent intent=new Intent(this,share_add.class);
        startActivity(intent);
    }

    public void display(View view)
    {
        Intent intent2=new Intent(this,share_display.class);
        startActivity(intent2);
    }

    public void ViewARide(View view){
        Intent intent =new Intent(this,RecycleViewFirebase.class);
        startActivity(intent);

    }
}