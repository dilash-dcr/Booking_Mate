package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.net.Inet4Address;

public class Payment_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__home);
    }

    public void cardPayment(View view)
    {
        Intent intent=new Intent(this,Payment_card.class);
        startActivity(intent);
    }

    public void onlinePayment(View view)
    {
        Intent intent=new Intent(this,payment_online.class);
        startActivity(intent);
    }

}