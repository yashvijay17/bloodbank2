package com.example.srishti.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class option_signup extends ActionBarActivity implements View.OnClickListener {
    ImageButton user;
    ImageButton hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_signup);

        user=(ImageButton)findViewById(R.id.uss);
       hospital=(ImageButton)findViewById(R.id.hoss);
        user.setOnClickListener(this);
        hospital.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option_signup, menu);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.uss:
                Intent i=new Intent(this,Signin.class);
                startActivity(i);
                break;

            case R.id.hoss:
                Intent ii=new Intent(this,signin_hospital.class);
                startActivity(ii);
                break;
            default: break;
        }
    }
}
