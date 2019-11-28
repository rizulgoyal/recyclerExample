package com.example.recyclerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecycler;
    CardView mycardview;
    ArrayList<UserData> myarraylist = new ArrayList<UserData>();

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrecycler = (RecyclerView) findViewById(R.id.recycler_main);



        //data from database and json

        final UserDatabase uData = UserDatabase.getInstance(this);

        List<Employee> usr1 = uData.daoObjct().getUserDetails();

        if(usr1.size() != 0)
        {
            uData.clearAllTables();
        }


        String temp1 = loadJSONFromAsset();
        Gson gson = new Gson();

        try {
            JSONArray jsonarray = new JSONArray(temp1);

            for(int i =0 ; i<=jsonarray.length();i++)
            {

                String temps = jsonarray.get(i).toString();
                Employee emp = gson.fromJson(temps,Employee.class);
                uData.daoObjct().insert(emp);

            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }


        List<Employee> usr =  uData.daoObjct().getUserDetails();





        //end of data from json






        myarraylist.add(new UserData("Rizul","60,000.06"));
        myarraylist.add(new UserData("Kunal","17539.02"));
        myarraylist.add(new UserData("Rizul","65412.25"));
        myarraylist.add(new UserData("Rizul","65214.32"));
        myarraylist.add(new UserData("Rizul","65896.02"));
        myarraylist.add(new UserData("Rizul","98541.02"));


        UserDataAdpater myadapter = new UserDataAdpater(this,usr);

        LinearLayoutManager mylinearlayout = new LinearLayoutManager(this);
        myrecycler.setLayoutManager(mylinearlayout);
        myrecycler.setAdapter(myadapter);









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_addemployee,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_employee:
                Intent myintent = new Intent(this,AddEmployeeActivity.class);
                startActivity(myintent);
                Toast.makeText(MainActivity.this,"Added",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_employee:
                Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = MainActivity.this.getAssets().open("sample.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
