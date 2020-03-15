package com.gdg.bhopal.project3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Registeration extends AppCompatActivity {
    EditText name,email,pass,age,dob,address,mob,course,school;
    RadioButton male,female;
    SharedPreferences mypref=null;
    Db_helper  dbHelper=null;
    Button submitBtn;
    ClgForm form;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbHelper = new Db_helper(this);
        mypref=getSharedPreferences("MYPREF",MODE_PRIVATE);
       // getIntent().getStringExtra("name");
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        pass =(EditText)findViewById(R.id.pwd);
        age =(EditText)findViewById(R.id.age) ;
        dob=(EditText)findViewById(R.id.dob);
        address = (EditText)findViewById(R.id.add);
        mob = (EditText)findViewById(R.id.mno);
        course =(EditText) findViewById(R.id.course);
        school = (EditText)findViewById(R.id.scl);
        male = (RadioButton)findViewById(R.id.male);
        female = (RadioButton)findViewById(R.id.female);
        submitBtn = (Button)findViewById(R.id.btt);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String email1 = email.getText().toString();
                String pwd1 = pass.getText().toString();
                String age1 = age.getText().toString();
                String dob1 = dob.getText().toString();
                String mno1 = mob.getText().toString();
                String address1 = address.getText().toString();
                String course1 = course.getText().toString();
                String school1 = school.getText().toString();
                String gender=null;
                if(male.isChecked()){
                    gender="Male";
                }
                if(female.isChecked()){
                    gender="Female";
                }
                int age2 = Integer.valueOf(age1);
                form = new ClgForm(name1,email1,pwd1,dob1,address1,mno1,course1,school1,gender,age2);
                boolean isInserted = dbHelper.insertForm(form);
                if(isInserted){
                    Toast.makeText(getApplicationContext(),"Form registered successfully!!!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"*Not Registered*  Erroc occured!!!",Toast.LENGTH_LONG).show();
                }
                SharedPreferences.Editor editor = mypref.edit();
                editor.putString("name",name1);
                editor.putString("email",email1);
                editor.putString("pwd",pwd1);
                editor.putString("mno",mno1);
                editor.putString("address",address1);
                editor.putString("course",course1);
                editor.putString("gender",gender);
                editor.putString("school",school1);
                editor.putString("dob",dob1);

                editor.putInt("age",age2);
                editor.commit();
                Intent i = new Intent(Registeration.this,MainActivity.class);
                //i.putExtra("name",nameEdt.getText().toString());
                // i.putExtra("feedback",gf);
                //i.putExtra("feed",gf);
                startActivity(i);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    //String name= getIntent().getStringExtra("option");
    //op.setText(op.getText() + " "+name);
}

