package com.example.srishti.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class hos_organize_events extends ActionBarActivity implements View.OnClickListener {
    ImageButton org;
    ImageButton cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hos_organize_events);


        org=(ImageButton)findViewById(R.id.org);
        cancel=(ImageButton)findViewById(R.id.oe_cancel);
        org.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hos_organize_events, menu);
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

            case R.id.org:


                showmsg5();
                break;

            case R.id.oe_cancel:
                EditText n;
                EditText ha;
                EditText t;
                EditText d;
                EditText ed;

                n= (EditText)findViewById(R.id.oe_n);
                ha = (EditText)findViewById(R.id.oe_na);
                t= (EditText)findViewById(R.id.oe_t);
                d = (EditText)findViewById(R.id.oe_d);
                ed= (EditText)findViewById(R.id.oe_ed);
                n.setText("");
                ha.setText("");
                t.setText("");
                d.setText("");
                ed.setText("");
                           default: break;
        }
    }

    private void showmsg5()
    {
        AlertDialog.Builder dialogbuilder= new AlertDialog.Builder(this);
        dialogbuilder.setTitle("Post Event");
        dialogbuilder.setMessage("Your event has been posted!");
        dialogbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Posted!", Toast.LENGTH_SHORT).show();
                //I want the new Activity to start only after user clicks ok.
                Intent intent;
                intent = new Intent(getApplicationContext(), hos_profile.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog= dialogbuilder.create();
        alertDialog.show();


    }
}
