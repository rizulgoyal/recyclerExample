package com.example.recyclerexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class UserDataAdpater extends RecyclerView.Adapter<UserDataAdpater.ViewHolder> {

    private Context context;
    private List<Employee> myaaraylist;


    public UserDataAdpater(Context context) {
        this.context = context;

    }




    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Employee> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(List<Employee> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrow,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {

    Employee mydata = myaaraylist.get(position);

    Vehicle myvehicle = mydata.getVehicle();
    holder.name.setText("Employee Name: "+mydata.getName());
    holder.id.setText("Employee ID: "+mydata.getId().toString());
    holder.age.setText("Employee Age: "+mydata.getAge().toString()+" Years");


        if(myvehicle == null)
    {
        holder.type.setText("No Vehicle");
        holder.type.setTextColor(Color.RED);
        holder.type.setTextSize(20);

        holder.plate.setVisibility(View.GONE);
        holder.make.setVisibility(View.GONE);
        holder.model.setVisibility(View.GONE);


    }
    else {
        holder.type.setText("Vehicle Type: "+myvehicle.getType());
            holder.make.setText("Vehicle Make: "+myvehicle.getMake());
            holder.model.setText("Vehicle Model: "+myvehicle.getModel());
            holder.plate.setText("Vehicle Plate: "+myvehicle.getPlate());

        }




        holder.mycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"position = "+position,Toast.LENGTH_LONG).show();

            }
        });

    }





    @Override
    public int getItemCount() {
        return myaaraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, age, id, make, model, plate, type;
        CardView mycardview;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mycardview = itemView.findViewById(R.id.newcard);
            id = (TextView)itemView.findViewById(R.id.textView2);
            name = (TextView)itemView.findViewById(R.id.textView3);
            age = (TextView)itemView.findViewById(R.id.textView5);
            make = (TextView)itemView.findViewById(R.id.textViewn2);
            model = (TextView)itemView.findViewById(R.id.textViewn3);
            plate = (TextView)itemView.findViewById(R.id.textViewn4);
            type = (TextView)itemView.findViewById(R.id.textViewn1);



        }
    }


}
