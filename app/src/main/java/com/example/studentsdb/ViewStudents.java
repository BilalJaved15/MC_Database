package com.example.studentsdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewStudents extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    List<StudentModel> stdList = new ArrayList<StudentModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        DBHelper dbHelper = new DBHelper(ViewStudents.this);
        stdList = dbHelper.getAllStudents();

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(stdList, ViewStudents.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stdList = new DBHelper(this).getAllStudents();
        adapter = new RecyclerViewAdapter(stdList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        stdList = new DBHelper(this).getAllStudents();
        adapter = new RecyclerViewAdapter(stdList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public static void Relaunch(Activity context){
        context.finish();
        context.overridePendingTransition(0, 0);
        context.startActivity(context.getIntent());
        context.overridePendingTransition(0, 0);
    }
}