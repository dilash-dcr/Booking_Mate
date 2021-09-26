package com.example.travelpartner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    ArrayList<Model> mList;
    Context context;

    public RecyclerViewAdapter(Context context , ArrayList<Model> mList){
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.from.setText(model.getFrom());
        holder.to.setText(model.getTo());
        holder.adId.setText(model.getAdId());
        holder.name.setText(model.getName());
        holder.seat.setText(model.getSeat());
        holder.ride.setText(model.getRide());
        holder.date.setText(model.getDate());
        holder.DTime.setText(model.getDTime());
        holder.ATime.setText(model.getATime());
        holder.Vm.setText(model.getVm());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView from, to, adId, name, seat, ride, date, DTime, ATime, Vm;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            from = itemView.findViewById(R.id.TpFrom);
            to = itemView.findViewById(R.id.TpTo);
            adId = itemView.findViewById(R.id.TpAdId);
            name = itemView.findViewById(R.id.TpName);
            seat = itemView.findViewById(R.id.TpSeat);
            ride = itemView.findViewById(R.id.TpRide);
            date = itemView.findViewById(R.id.TpDate);
            DTime = itemView.findViewById(R.id.TpDepTime);
            ATime = itemView.findViewById(R.id.TpATime);
            Vm = itemView.findViewById(R.id.TpVModel);
        }
    }

}