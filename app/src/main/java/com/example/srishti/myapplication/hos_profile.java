package com.example.srishti.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class hos_profile extends ActionBarActivity implements View.OnClickListener {
    ImageButton askforbloodd;
    ImageButton bloodbankstatus;
    ImageButton orgevents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hos_profile);


        askforbloodd=(ImageButton)findViewById(R.id.img4);
        bloodbankstatus=(ImageButton)findViewById(R.id.img5);
        askforbloodd.setOnClickListener(this);
        bloodbankstatus.setOnClickListener(this);
        orgevents=(ImageButton)findViewById(R.id.img6);
        orgevents.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hos_profile, menu);
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

            case R.id.img4:
                Intent i=new Intent(this,ask_for_blood_hos.class);
                startActivity(i);
                break;
            case R.id.img6:
                Intent m=new Intent(this,hos_organize_events.class);
                startActivity(m);
                break;


            default: break;
        }
    }
}
