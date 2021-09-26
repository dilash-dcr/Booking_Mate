package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Payments_display extends AppCompatActivity {

    EditText dpaymentid,dname,duid,dbid,damount,dcardno,drefno;
    Button cardSearch,onlineSearch;
    String paymentID;
    Payments paydis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_display);

        dname=findViewById(R.id.display_name);
        duid=findViewById(R.id.display_uid);
        dbid=findViewById(R.id.display_bid);
        damount=findViewById(R.id.diplay_amount);
        dcardno=findViewById(R.id.diplay_cardnum);
        drefno=findViewById(R.id.display_refnum);

        cardSearch=findViewById(R.id.search_card);
        onlineSearch=findViewById(R.id.search_online);

        paydis=new Payments();

        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dpaymentid=findViewById(R.id.paymentid);
                paydis.setPaymentid(dpaymentid.getText().toString().trim());
                paymentID=paydis.getPaymentid();

                DatabaseReference dbref3= FirebaseDatabase.getInstance().getReference().child("CardPayments").child(paymentID);
                dbref3.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                                dname.setText(snapshot.child("name").getValue().toString());
                                duid.setText(snapshot.child("uid").getValue().toString());
                                dbid.setText(snapshot.child("bid").getValue().toString());
                                damount.setText(snapshot.child("amount").getValue().toString());
                                dcardno.setText(snapshot.child("cnumber").getValue().toString());
                        }
                        else
                            {
                                Toast.makeText(getApplicationContext(),"No data found regarding this payment ID",Toast.LENGTH_SHORT).show();
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        onlineSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dpaymentid=findViewById(R.id.paymentid);
                paydis.setPaymentid(dpaymentid.getText().toString().trim());
                paymentID=paydis.getPaymentid();

                DatabaseReference dbref3= FirebaseDatabase.getInstance().getReference().child("OnlinePayments").child(paymentID);
                dbref3.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren()){
                            dname.setText(snapshot.child("name").getValue().toString());
                            duid.setText(snapshot.child("uid").getValue().toString());
                            dbid.setText(snapshot.child("bid").getValue().toString());
                            damount.setText(snapshot.child("amount").getValue().toString());
                            drefno.setText(snapshot.child("referenceNumber").getValue().toString());
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"No data found regarding this payment ID",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}