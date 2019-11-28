package com.example.recyclerexample;

import android.content.Context;
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


    public UserDataAdpater(Context context, List<Employee> myaaraylist) {
        this.context = context;
        this.myaaraylist = myaaraylist;
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

    public void setMyaaraylist(ArrayList<Employee> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

    Employee mydata = myaaraylist.get(position);
    Vehicle myvehicle = mydata.getVehicle();
    holder.name.setText(mydata.getName());
        holder.salary.setText(myvehicle.getMake());



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

        TextView name, salary;
        CardView mycardview;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            mycardview = itemView.findViewById(R.id.newcard);
            name = (TextView)itemView.findViewById(R.id.textView2);
            salary = (TextView)itemView.findViewById(R.id.textView3);
        }
    }


}
