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


public class medical_history extends ActionBarActivity implements View.OnClickListener{
    ImageButton up;
    ImageButton cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);

        up=(ImageButton)findViewById(R.id.update);
        cancel=(ImageButton)findViewById(R.id.med_cancel);
        up.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medical_history, menu);
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

            case R.id.update:


                showmsg2();
                break;

            case R.id.med_cancel:
                EditText n;
                EditText a;
                EditText w;
                EditText d;
                EditText rs;
                EditText bg;

                n= (EditText)findViewById(R.id.mh_n);
                a = (EditText)findViewById(R.id.mh_a);
                w= (EditText)findViewById(R.id.mh_w);
                d = (EditText)findViewById(R.id.mh_d);
                rs= (EditText)findViewById(R.id.mh_rs);
                bg = (EditText)findViewById(R.id.mh_bg);
                n.setText("");
                a.setText("");
                w.setText("");
                d.setText("");
                rs.setText("");
                bg.setText("");


            default: break;
        }
    }


    private void showmsg2()
    {
        AlertDialog.Builder dialogbuilder= new AlertDialog.Builder(this);
        dialogbuilder.setTitle("Update");
        dialogbuilder.setMessage("Your medical history has been updated!");
        dialogbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_SHORT).show();
                //I want the new Activity to start only after user clicks ok.
                Intent intent;
                intent = new Intent(getApplicationContext(), user_profile.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog= dialogbuilder.create();
        alertDialog.show();


    }
}
