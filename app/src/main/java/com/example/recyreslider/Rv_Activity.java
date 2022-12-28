package com.example.recyreslider;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Rv_Activity extends RecyclerView.Adapter<Rv_Activity.ViewHolder> {

    View view;
    Context context;

    public Rv_Activity(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Rv_Activity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.activity_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rv_Activity.ViewHolder holder, int position) {
        holder.textView.setText("Position :- "+position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}