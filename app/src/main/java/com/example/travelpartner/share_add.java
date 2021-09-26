package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class share_add extends AppCompatActivity {

    EditText txtFrom, txtTo, txtAdId, txtName, txtSeat, txtRide, txtDate, txtDTime, txtATime, txtVm;
    Button butPost;
    DatabaseReference shareadd;
    Rider rid;
    long shareid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_add);

        txtFrom = findViewById(R.id.TpFrom);
        txtTo = findViewById(R.id.TpTo);
        txtName = findViewById(R.id.TpName);
        txtSeat = findViewById(R.id.TpSeat);
        txtRide = findViewById(R.id.TpRide);
        txtDate = findViewById(R.id.TpDate);
        txtDTime = findViewById(R.id.TpDepTime);
        txtATime = findViewById(R.id.TpATime);
        txtVm = findViewById(R.id.TpVModel);
        txtAdId = findViewById(R.id.TpAdId);

        butPost = findViewById(R.id.button2);

        rid=new Rider();

        shareadd= FirebaseDatabase.getInstance().getReference().child("ShareRide");
        shareadd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    shareid=(snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        butPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(TextUtils.isEmpty(txtFrom.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Location", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtTo.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Location", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtName.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Name", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtSeat.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Seat", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtRide.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Cost for ride", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtDate.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Date", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtDTime.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Departure Time", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtATime.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Arrival Time", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtVm.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Arrival Time", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        rid.setFrom(txtFrom.getText().toString().trim());
                        rid.setTo(txtTo.getText().toString().trim());
                        rid.setName(txtName.getText().toString().trim());
                        rid.setSeat(txtSeat.getText().toString().trim());
                        rid.setRide(txtRide.getText().toString().trim());
                        rid.setDate(txtDate.getText().toString().trim());
                        rid.setDTime(txtDTime.getText().toString().trim());
                        rid.setATime(txtATime.getText().toString().trim());
                        rid.setVm(txtVm.getText().toString().trim());

                        boolean success=validation(Integer.parseInt(txtSeat.getText().toString().trim()),Integer.parseInt(txtRide.getText().toString().trim()));

                        if(success==true)
                        {
                            shareadd.child(rid.getName()+String.valueOf(shareid)).setValue(rid);
                            Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                            clearControls();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Try again with correct information",Toast.LENGTH_SHORT).show();
                        }


                    }
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Invalid Vehicle Model", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void clearControls(){
        txtFrom.setText("");
        txtTo.setText("");
        txtName.setText("");
        txtSeat.setText("");
        txtRide.setText("");
        txtDate.setText("");
        txtDTime.setText("");
        txtATime.setText("");
        txtVm.setText("");
        txtAdId.setText(String.valueOf(shareid)+rid.getName());

    }

    public boolean validation(int SEATS,int COST)

    {
        if(SEATS<=0)
        {
            txtSeat.requestFocus();
            txtSeat.setError("Invalid no of seats. Try Again !");
            return false;
        }
        else if(COST<=0)
        {
            txtRide.requestFocus();
            txtSeat.setError("Invalid amount of cost. Try Again !");
            return false;
        }
        else {
            return true;
        }

    }

}