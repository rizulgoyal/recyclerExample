package com.example.recyclerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
        showDialog(AddEmployeeActivity.this,"Are you sure you want to submit?");

        //Intent myintent = new Intent(this,MainActivity.class);
        //startActivity(myintent);






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


        if (empname.equals(""))
        {
            showtextDialog(AddEmployeeActivity.this,"Please add Employee Name to complete the Employee Form");
        }
        else {


            Vehicle tempvehicle = new Vehicle("any", x + 1, vmake, vplate, vmodel, true, vtype);
            Employee tempobject = new Employee(empid, empname, empage, tempvehicle);

            final UserDatabase uData = UserDatabase.getInstance(this);
            //Gson gson = new Gson();


            uData.daoObjct().insert(tempobject);

            Toast.makeText(AddEmployeeActivity.this, "Added obj", Toast.LENGTH_SHORT).show();
        }

    }

    public void showDialog(final Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.dialogtext);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.customButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();
                finish();
            }
        });

        dialog.show();

    }

    public void showtextDialog(final Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.dialogtext);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.customButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();

            }
        });

        dialog.show();

    }
}
