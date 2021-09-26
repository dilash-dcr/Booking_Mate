package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Share_request extends AppCompatActivity {

    EditText name,adid,reqestname,yourname,contactNumber,address;
    Button submit;
    DatabaseReference dbrequest;
    Requests req;
    String reqid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_request);

        name=findViewById(R.id.etNameSV);
        adid=findViewById(R.id.etshareIADID);
        reqestname=findViewById(R.id.etshareID);
        yourname=findViewById(R.id.etUserIDSV);
        contactNumber=findViewById(R.id.etContactNoSV);
        address=findViewById(R.id.etaddress);

        submit=findViewById(R.id.btnSubmitrequestSV);
        req=new Requests();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbrequest= FirebaseDatabase.getInstance().getReference().child("RideRequests");

                try{

                    if(TextUtils.isEmpty(name.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Name is empty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(adid.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"AD ID is empty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(reqestname.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Requester User Name is empty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(yourname.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Your User Name is empty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(contactNumber.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Contact Number is empty",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(address.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Address is empty",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        req.setName(name.getText().toString().trim());
                        req.setAdID(adid.getText().toString().trim());
                        req.setRequesterUserName(reqestname.getText().toString().trim());
                        req.setYourUserName(yourname.getText().toString().trim());
                        req.setContactNumber(contactNumber.getText().toString().trim());
                        req.setMeetingPoint(address.getText().toString().trim());

                        reqid=req.getRequesterUserName()+req.getYourUserName();

                        dbrequest.child(reqid).setValue(req);
                        Toast.makeText(getApplicationContext(),"Request Submission was successful ",Toast.LENGTH_SHORT).show();

                    }

                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"There was a Error Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}