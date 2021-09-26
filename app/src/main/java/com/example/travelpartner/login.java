package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    EditText username,pass;
    Button loging;
    TextView btn;
    String userid;
    String UN;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextTextPersonName);
        pass = findViewById(R.id.editTextTextPassword);
        loging = findViewById(R.id.viewRide);
        btn = findViewById(R.id.textView11);

        loging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userid=username.getText().toString()+pass.getText().toString();
                UN=userid;
                DatabaseReference dblogin= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);
                dblogin.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren())
                        {
                            Intent in=new Intent(getApplicationContext(),Account.class);
                            in.putExtra("Username",UN);
                            startActivity(in);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Invalid User name or Passwords",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });

    }

    public void Register(View view)
    {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }

}