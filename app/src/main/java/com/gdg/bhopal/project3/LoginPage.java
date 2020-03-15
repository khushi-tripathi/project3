package com.gdg.bhopal.project3;

import android.content.Intent;
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

public class LoginPage extends AppCompatActivity {
RadioButton firstopt,second;
TextView namee,mail;
Intent i ;
Button btn;
String nam,mail1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firstopt = (RadioButton) findViewById(R.id.first);
        second = (RadioButton) findViewById(R.id.second);
        btn = (Button) findViewById(R.id.btnn);
        namee = (TextView)findViewById(R.id.uname);
        mail = (TextView)findViewById(R.id.uemail);
        nam =  getIntent().getStringExtra("name");
        mail1 =  getIntent().getStringExtra("email");
        namee.setText(namee.getText()+" "+nam);
        mail.setText(mail.getText()+" "+mail1);

        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v) {
                                       if(firstopt.isChecked()){
                                           i = new Intent(LoginPage.this,ShowName.class);
                                           Toast.makeText(getApplicationContext(),"Show name !!",Toast.LENGTH_LONG).show();
                                       }else if (second.isChecked()){
                                           i = new Intent(LoginPage.this,AllDetails.class);
                                           Toast.makeText(getApplicationContext(),"All Details  !!",Toast.LENGTH_LONG).show();

                                       }else{
                                           Toast.makeText(getApplicationContext(),"Error Occur !!",Toast.LENGTH_LONG).show();
                                       }
                                       startActivity(i);
                                   }
                               }


        );

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
