package com.example.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText name, age;
    Button addStd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        addStd = findViewById(R.id.addStdBtn);
        addStd.setOnClickListener(v->{
            StudentModel stdModel = null;
            try {
                stdModel = new StudentModel(name.getText().toString(), Integer.parseInt(age.getText().toString()), true);
                Toast.makeText(AddStudent.this, "Student added!", Toast.LENGTH_SHORT).show();
            } catch(Exception e) {
                Toast.makeText(AddStudent.this, "Error", Toast.LENGTH_SHORT).show();
            }
            DBHelper dbHelper = new DBHelper(AddStudent.this);
            dbHelper.addStudent(stdModel);
        });
    }
}