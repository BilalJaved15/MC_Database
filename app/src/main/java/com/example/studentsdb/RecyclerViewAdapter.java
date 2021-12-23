package com.example.studentsdb;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
        Button editBtn;
        Button deleteBtn;
        StudentModel data;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewStdName = itemView.findViewById(R.id.stdName);
            textViewStdAge = itemView.findViewById(R.id.stdAge);
            editBtn = itemView.findViewById(R.id.editBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            editBtn.setOnClickListener(v-> {
                Intent intent = new Intent(activity, EditStudent.class);
                intent.putExtra("id", new String("" + data.getId()));
                intent.putExtra("name", data.getName());
                intent.putExtra("age", new String("" + data.getAge()));
                activity.startActivity(intent);
            });
            deleteBtn.setOnClickListener(v->{
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Delete Student")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper dbHelper = new DBHelper(activity);
                                dbHelper.deleteStudent(data);
                                notifyDataSetChanged();
                                ViewStudents.Relaunch(activity);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setMessage("Are you sure you want to delete this student?")
                        .show();

            });
        }
    }
}
