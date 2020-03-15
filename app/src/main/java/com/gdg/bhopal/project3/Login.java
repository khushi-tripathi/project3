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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
EditText pwd,email;
TextView samp;
String username,userEmail;
Button sub;
Intent i =null,p=null;
    Db_helper db_helper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    db_helper = new Db_helper(this);
    pwd = (EditText) findViewById(R.id.pass);
    email = (EditText) findViewById(R.id.mail);
    sub = (Button) findViewById(R.id.Submit);
    samp = (TextView)findViewById(R.id.sample);
    sub.setOnClickListener(new View.OnClickListener() {
                               public void onClick(View view) {
                                    try {
                                        int c = 0;
                                        ArrayList<ClgForm> clgForms;
                                        clgForms = db_helper.getAllForm();
                                        for (ClgForm f:clgForms
                                             ) {samp.setText(samp.getText()+"   "+f.name+","+f.pwd);
                                        }

                                        for (ClgForm cf : clgForms
                                        ) {
                                            if (cf.email.equals(email) && cf.pwd.equals(pwd)) {
                                                i = new Intent(Login.this, LoginPage.class);
                                                username = cf.name;
                                                userEmail = cf.email;
                                                c = 1;
                                                break;
                                            }
                                        }
                                        if (c == 1) {
                                            //i = new Intent(MainActivity.this, Registeration.class);
                                            //i.putExtra("option", opt);
                                            Toast.makeText(getApplicationContext(), "Login Successfully!!!", Toast.LENGTH_LONG).show();
                                            i.putExtra("name", username);
                                            i.putExtra("email", userEmail);
                                            startActivity(i);
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Error Occur !!", Toast.LENGTH_LONG).show();
                                        }
                                    }catch (Exception e){
                                        Toast.makeText(getApplicationContext(), "Exception !! "+e.toString(), Toast.LENGTH_LONG).show();
                                    }
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
