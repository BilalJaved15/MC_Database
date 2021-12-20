package com.example.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addStd, viewStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addStd = findViewById(R.id.addStd);
        viewStd = findViewById(R.id.viewStd);
        addStd.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, AddStudent.class);
            startActivity(intent);
        });
        viewStd.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ViewStudents.class);
            startActivity(intent);
        });
    }
}