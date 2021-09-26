package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText Fname, Lname, Email, phone, Pass;
    Button Register;
    Users newuser;
    String userid;
    DatabaseReference dbregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Fname = findViewById(R.id.txt_fname);
        Lname = findViewById(R.id.txt_lname);
        Email = findViewById(R.id.txt_email);
        phone = findViewById(R.id.txt_phonenum);
        Pass = findViewById(R.id.txt_password);

        Register=findViewById(R.id.btn_register);

        newuser=new Users();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbregister= FirebaseDatabase.getInstance().getReference().child("Users");

                try {

                    if (TextUtils.isEmpty(Fname.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "First Name is Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(Lname.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Last Name is Empty", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(Email.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Email is Blank", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(phone.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Phone Number is Blank", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(Pass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Password is Empty",Toast.LENGTH_SHORT).show();
                    }
                    else {

                        newuser.setFname(Fname.getText().toString().trim());
                        newuser.setLname(Lname.getText().toString().trim());
                        newuser.setEmail(Email.getText().toString().trim());
                        newuser.setPhone(phone.getText().toString().trim());
                        newuser.setPassword(Pass.getText().toString().trim());

                        userid=newuser.getFname()+newuser.getLname()+newuser.getPassword();
                        dbregister.child(userid).setValue(newuser);
                        Toast.makeText(getApplicationContext(),"Registration was Successful.Your username is First Name + Last Name",Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}