package com.example.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditStudent extends AppCompatActivity {

    EditText name, age;
    Button editBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        name = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        editBtn = findViewById(R.id.editStdBtn);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        age.setText(intent.getStringExtra("age"));
        StudentModel std = new StudentModel(name.getText().toString(), Integer.parseInt(age.getText().toString()), true);
        std.setId(Integer.parseInt(intent.getStringExtra("id")));
        editBtn.setOnClickListener(v->{
            std.setName(name.getText().toString());
            std.setAge(Integer.parseInt(age.getText().toString()));
            DBHelper dbHelper = new DBHelper(this);
            dbHelper.updateStudent(std);
            Toast.makeText(this, "Student Updated", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}