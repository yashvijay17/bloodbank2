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


public class user_profile extends ActionBarActivity implements View.OnClickListener{
 ImageButton askforblood;
    ImageButton bloodreq;
    ImageButton medhistory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        askforblood=(ImageButton)findViewById(R.id.img1);
        bloodreq=(ImageButton)findViewById(R.id.img2);
        askforblood.setOnClickListener(this);
        bloodreq.setOnClickListener(this);
        medhistory=(ImageButton)findViewById(R.id.img3);
       medhistory.setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
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

            case R.id.img1:
                Intent i=new Intent(this,ask_for_blood_user.class);
                startActivity(i);
                break;
            case R.id.img2:
                Intent d=new Intent(this,user_blood_requests.class);
                startActivity(d);
                break;
            case R.id.img3:
                Intent a=new Intent(this,medical_history.class);
                startActivity(a);
                break;

            default: break;
        }

    }
}
