package com.example.studentsdb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<StudentModel> students;
    Activity activity;

    public RecyclerViewAdapter(List<StudentModel> stdList, Activity mAct) {
        this.students = stdList;
        this.activity = mAct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.data=students.get(position);
        holder.textViewStdName.setText(holder.data.getName());
        holder.textViewStdAge.setText(String.valueOf(holder.data.getAge()));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewStdName;
        TextView textViewStdAge;
        StudentModel data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStdName = itemView.findViewById(R.id.stdName);
            textViewStdAge = itemView.findViewById(R.id.stdAge);
        }
    }
}
