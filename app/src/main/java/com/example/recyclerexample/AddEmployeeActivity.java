package com.example.recyclerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class AddEmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    EditText id,name,age,make,plate,model,type;
    Button mybutton;
    int x = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        id = findViewById(R.id.editTextEmpID);
        name = findViewById(R.id.editTextEmpName);
        age = findViewById(R.id.editTextEmpAge);
        make = findViewById(R.id.editTextVehicleMake);
        plate = findViewById(R.id.editTextVehiclePlate);
        type = findViewById(R.id.editTextVehicleType);
        model = findViewById(R.id.editTextVehicleModel);
        mybutton = findViewById(R.id.buttonemployee);

        mybutton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        createEmployee();
        Intent myintent = new Intent(this,MainActivity.class);
        startActivity(myintent);




    }

    public void createEmployee()
    {
        Integer empid = Integer.parseInt( id.getText().toString());
        Integer empage = Integer.parseInt( age.getText().toString());
        String empname = name.getText().toString();
        String vmake = make.getText().toString();
        String vplate = plate.getText().toString();
        String vmodel = model.getText().toString();
        String vtype = type.getText().toString();


        Vehicle tempvehicle = new Vehicle("any",x+1,vmake,vplate,vmodel,true,vtype);
        Employee tempobject = new Employee(empid,empname,empage,tempvehicle);

        final UserDatabase uData = UserDatabase.getInstance(this);
        Gson gson = new Gson();

        Employee emp = gson.toJson(tempobject,Employee.class);

        uData.daoObjct().insert(tempobject);
        Toast.makeText(AddEmployeeActivity.this,"Added",Toast.LENGTH_SHORT).show();


    }
}
