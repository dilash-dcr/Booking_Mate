package com.example.travelpartner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.myviewHolder> {


    DatabaseReference dbRef;
    Context context;
    ArrayList<RentVehicle> list;

    public MyAdepter(Context context, ArrayList<RentVehicle> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.vehicle,parent,false);
        return  new myviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        RentVehicle rentvehicle = list.get(position);
        holder.VehicleType.setText(rentvehicle.getVehicleType());
        holder.VehicleModel.setText(rentvehicle.getVehicleModel());
        holder.AvailableSeat.setText(rentvehicle.getAvailableSeats());
        holder.VehiclePrice.setText(rentvehicle.getVehiclePrice());
        holder.Contact.setText(rentvehicle.getContact());
        holder.Description.setText(rentvehicle.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewHolder extends RecyclerView.ViewHolder {

        TextView VehicleType,VehicleModel,AvailableSeat,VehiclePrice,Contact,Description;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            VehicleType = itemView.findViewById(R.id.VPrice);
            VehicleModel = itemView.findViewById(R.id.VModel);
            AvailableSeat = itemView.findViewById(R.id.VSeats);
            VehiclePrice = itemView.findViewById(R.id.VPrice);
            Contact = itemView.findViewById(R.id.VContact);
            Description = itemView.findViewById(R.id.VDes);
        }
    }
}