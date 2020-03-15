package com.gdg.bhopal.project3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.FormViewHolder>  {
    ArrayList<ClgForm> gdgFeedbackList;
    Context context;
    TextView name,email,pass,age,dob,address,mob,course,school;
    public CollegeAdapter(ArrayList<ClgForm>feedbackList){

        gdgFeedbackList = feedbackList;
        ClgForm g =
                new ClgForm("krishna","krishna12@gmail.com","krish","19-09-2010","no address","8765432","k ","Elite h.s.school","Femaile",19);
        gdgFeedbackList.add(g);
    }

    class FormViewHolder extends  RecyclerView.ViewHolder{

        TextView name,email,age,dob,gend,address,mob,course,school;
        public FormViewHolder( View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.namee);
            email =(TextView)itemView.findViewById(R.id.emaill);
            age =(TextView)itemView.findViewById(R.id.agee);
            dob =(TextView)itemView.findViewById(R.id.dobb);
            address =(TextView)itemView.findViewById(R.id.address);
            mob = (TextView)itemView.findViewById(R.id.mnoo);
            course = (TextView)itemView.findViewById(R.id.coursee);
            school = (TextView)itemView.findViewById(R.id.scll);
            gend = (TextView)itemView.findViewById(R.id.genderr);
        }
    }
    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.display,parent,false);
        return new FormViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FormViewHolder holder, int position) {
        ClgForm gf = gdgFeedbackList.get(position);
        holder.name.setText(gf.name);
        holder.age.setText(gf.age);
        holder.dob.setText(gf.dob);
        holder.course.setText(gf.course);
        holder.address.setText(gf.address);
        holder.email.setText(gf.email);
        holder.gend.setText(gf.gender);
        holder.mob.setText(gf.mob);
        holder.school.setText(gf.school);
    }

    @Override
    public int getItemCount() {
        return gdgFeedbackList.size();
    }
}


