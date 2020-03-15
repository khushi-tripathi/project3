package com.gdg.bhopal.project3;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowName extends AppCompatActivity {

    TextView thankyouTV;
    ArrayList<ClgForm> gfList;
    ShowNameAdapter fadapter;
    RecyclerView feedbackRCV;
    SharedPreferences mypref=null;
    Db_helper dbHelper =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_name);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mypref=getSharedPreferences("MYPREF",MODE_PRIVATE);
        // thankyouTV = (TextView)findViewById(R.id.thankyouTV);
        // initialize the array list
        gfList = new ArrayList<ClgForm>();

        /*String n = mypref.getString("name","guest");
        int a = mypref.getInt("age",18);
        String occupation = mypref.getString("occupation","student");
        String sug = mypref.getString("suggestion","Good");
        int rat = mypref.getInt("rating",2);
        String qual = mypref.getString("qualification","Graduate");

        Feed g2 = new Feed(n,occupation,rat,qual,sug,a,false);
        gfList.add(g2);*/
        dbHelper = new Db_helper(this);
        gfList = dbHelper.getAllForm();
        fadapter = new ShowNameAdapter(gfList);
        feedbackRCV = (RecyclerView)findViewById(R.id.ShowNameRecyclerView);
        feedbackRCV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        feedbackRCV.setAdapter(fadapter);
        fadapter.notifyDataSetChanged();



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
