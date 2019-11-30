package com.example.recyclerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EmployeeDetailsActivity extends AppCompatActivity {

    TextView mytextemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        Bundle data = getIntent().getExtras();

        Employee emp1 = (Employee) data.getParcelable("empobject");

        mytextemp = findViewById(R.id.textViewDetailsEmployee);
        mytextemp.setText(emp1.getName());



    }
}
