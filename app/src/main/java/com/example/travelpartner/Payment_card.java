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

public class Payment_card extends AppCompatActivity {

    EditText name,uid,bid,amount,cardNumber,cardName,expDate, cards,cardpayID;
    Button cardPayment;
    String paymentID;

    DatabaseReference dbcardpayment;

    Payments pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_card);

        name=findViewById(R.id.payment_name);
        uid=findViewById(R.id.payment_uid);
        bid=findViewById(R.id.payment_bid);
        amount=findViewById(R.id.payment_amount);
        cardNumber=findViewById(R.id.payment_cname);
        cardName=findViewById(R.id.payment_nameinc);
        expDate=findViewById(R.id.payment_year);
        cards =findViewById(R.id.payment_csv);


        cardPayment=findViewById(R.id.btn_cardpayment);

        pay=new Payments();

        cardPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbcardpayment=FirebaseDatabase.getInstance().getReference().child("CardPayments");

                try {

                        if(TextUtils.isEmpty(name.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid Name ",Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(uid.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid User ID ",Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(bid.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(amount.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(cardNumber.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(cardName.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                        }
                        else if(TextUtils.isEmpty(expDate.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(),"Enter A valid value to this field ",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            pay.setName(name.getText().toString().trim());
                            pay.setUid(uid.getText().toString().trim());
                            pay.setBid(bid.getText().toString().trim());
                            pay.setAmount(Double.parseDouble(amount.getText().toString().trim()));
                            pay.setCnumber(cardNumber.getText().toString().trim());
                            pay.setOwoname(cardName.getText().toString().trim());
                            pay.setExp(expDate.getText().toString().trim());
                            pay.setCsv(Integer.parseInt(cards.getText().toString().trim()));

                            paymentID=pay.getBid()+pay.getUid();

                            dbcardpayment.child(paymentID).setValue(pay);

                            boolean success=validation(Double.parseDouble(amount.getText().toString().trim()),cardNumber.getText().toString().trim(),cards.getText().toString().trim());


                            if(success==true) {
                                
                                Toast.makeText(getApplicationContext(), "Payment Was successfull", Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(), "Your Payment ID is your Booking ID + User ID", Toast.LENGTH_LONG).show();
                                clearFeilds1();
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
           }

        });
    }

    public void clearFeilds1()
    {
        name.setText("");
        uid.setText("");
        bid.setText("");
        amount.setText("");
        cardNumber.setText("");
        cardName.setText("");
        expDate.setText("");
        cards.setText("");
    }

    public boolean validation(Double Amount,String CardNumber,String CSV)
    {
        if(Amount<=0)
        {
            amount.requestFocus();
            amount.setError("Invalid amount");
            return  false;
        }
        else if(CardNumber.length()!=16)
        {
            cardNumber.requestFocus();
            cardNumber.setError("Card number shoul incllude 16 numbers");
            return false;
        }
        else if(CSV.length()!=3)
        {
            cards.requestFocus();
            cards.setError("CSV should include 3 numbres");
            return  false;
        }
        else
        {
            return  true;
        }
    }

    }