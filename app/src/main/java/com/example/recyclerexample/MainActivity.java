package com.example.recyclerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrecycler;
    CardView mycardview;
    ArrayList<UserData> myarraylist = new ArrayList<UserData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrecycler = (RecyclerView) findViewById(R.id.recycler_main);

        myarraylist.add(new UserData("Rizul","60,000.06"));
        myarraylist.add(new UserData("Kunal","17539.02"));
        myarraylist.add(new UserData("Rizul","65412.25"));
        myarraylist.add(new UserData("Rizul","65214.32"));
        myarraylist.add(new UserData("Rizul","65896.02"));
        myarraylist.add(new UserData("Rizul","98541.02"));

        UserDataAdpater myadapter = new UserDataAdpater(this,myarraylist);
        LinearLayoutManager mylinearlayout = new LinearLayoutManager(this);
        myrecycler.setLayoutManager(mylinearlayout);
        myrecycler.setAdapter(myadapter);







    }
}
