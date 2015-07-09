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


public class ask_for_blood_hos extends ActionBarActivity implements View.OnClickListener {
    ImageButton post;
    ImageButton cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_blood_hos);

        post=(ImageButton)findViewById(R.id.hos_post);
        cancel=(ImageButton)findViewById(R.id.hos_can);
        post.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ask_for_blood_hos, menu);
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


        switch (v.getId()) {
            case R.id.hos_post:


                showmsg3();
                break;


            case R.id.hos_can:
                EditText name;
                EditText re;
                EditText bg;
                EditText ph;

                name = (EditText) findViewById(R.id.pn);
                re = (EditText) findViewById(R.id.hn);
                bg = (EditText) findViewById(R.id.bgr);
                ph = (EditText) findViewById(R.id.h_phone);
                name.setText("");
                re.setText("");
                bg.setText("");
                ph.setText("");
        }
    }

    private void showmsg3()
    {
        AlertDialog.Builder dialogbuilder= new AlertDialog.Builder(this);
        dialogbuilder.setTitle("Post");
        dialogbuilder.setMessage("Your request has been posted!");
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
