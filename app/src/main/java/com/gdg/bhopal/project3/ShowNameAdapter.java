package com.gdg.bhopal.project3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowNameAdapter extends RecyclerView.Adapter<ShowNameAdapter.FormViewHolder>  {
    ArrayList<ClgForm> gdgFeedbackList;
    Context context;
    static int count =0;
    TextView name,email,pass,age,dob,address,mob,course,school;
    public ShowNameAdapter(ArrayList<ClgForm>feedbackList){

        gdgFeedbackList = feedbackList;
        /*ClgForm g =
                new ClgForm("krishna","krishna12@gmail.com","krish","19-09-2010","no address","8765432","k ","Elite h.s.school","Femaile",19);
        gdgFeedbackList.add(g);*/
    }

    class FormViewHolder extends  RecyclerView.ViewHolder{

        TextView name,id;
        public FormViewHolder( View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.n11);
                id = (TextView)itemView.findViewById(R.id.id1);
        }
    }
    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.showname,parent,false);
        return new FormViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FormViewHolder holder, int position) {
        count++;
        ClgForm gf = gdgFeedbackList.get(position);
        holder.name.setText(gf.name);
        holder.id.setText(count);
    }

    @Override
    public int getItemCount() {
        return gdgFeedbackList.size();
    }
}


