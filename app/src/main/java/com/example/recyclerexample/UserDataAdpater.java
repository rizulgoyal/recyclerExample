package com.example.recyclerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class UserDataAdpater extends RecyclerView.Adapter<UserDataAdpater.ViewHolder> {

    private Context context;
    private ArrayList<UserData> myaaraylist;

    public UserDataAdpater(Context context, ArrayList<UserData> myaaraylist) {
        this.context = context;
        this.myaaraylist = myaaraylist;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<UserData> getMyaaraylist() {
        return myaaraylist;
    }

    public void setMyaaraylist(ArrayList<UserData> myaaraylist) {
        this.myaaraylist = myaaraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    UserData mydata = myaaraylist.get(position);
    holder.name.setText(mydata.getName());
    holder.salary.setText(mydata.getSalary());


    }

    @Override
    public int getItemCount() {
        return myaaraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, salary;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);


            name = (TextView)itemView.findViewById(R.id.textView2);
            salary = (TextView)itemView.findViewById(R.id.textView3);
        }
    }
}
