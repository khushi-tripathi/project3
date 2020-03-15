package com.gdg.bhopal.project3;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton login,sign;
    Intent i;
    String opt = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sign = (RadioButton) findViewById(R.id.sign);
        login = (RadioButton) findViewById(R.id.login);
        Button submitBtn = (Button)findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View view) {
                                             if(login.isChecked()){
                                                 opt = "Login";
                                                 i = new Intent(MainActivity.this, Login.class);
                                             }else if(sign.isChecked()){
                                                 opt = "Sign";
                                                 i = new Intent(MainActivity.this, Registeration.class);
                                             }
                                             else{
                                                 opt = "incrct";
                                                 Toast.makeText(getApplicationContext(),"Error Occur !!",Toast.LENGTH_LONG).show();
                                             }
                                             if(!(opt.equals("incrct"))) {
                                                 i.putExtra("option",opt);
                                                 startActivity(i);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
