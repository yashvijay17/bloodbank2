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


public class LoginNew extends ActionBarActivity implements View.OnClickListener {
    ImageButton llogin;
    ImageButton cancell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);

        llogin=(ImageButton)findViewById(R.id.log);
        cancell=(ImageButton)findViewById(R.id.cc);
        llogin.setOnClickListener(this);
        cancell.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_new, menu);
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
    public  void onClick(View v)
    {
        switch(v.getId()){

            case R.id.log:


              showmsg12();

                break;

            case R.id.cc:
                EditText name;
                EditText pass;
                EditText id;
                name = (EditText)findViewById(R.id.username);
                pass = (EditText)findViewById(R.id.passw);
               id = (EditText)findViewById(R.id.h_id);
                name.setText("");
                pass.setText("");
                id.setText("");
            default: break;
        }
    }

    private void showmsg12()
    {
        AlertDialog.Builder dialogbuilder= new AlertDialog.Builder(this);
        dialogbuilder.setTitle("Logged");
        dialogbuilder.setMessage("Your have been succesfully logged in!");
        dialogbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Logged in!", Toast.LENGTH_SHORT).show();
                //I want the new Activity to start only after user clicks ok.
                Intent intent;

                EditText id1;
                id1 = (EditText) findViewById(R.id.h_id);

                if (id1.getText().toString().trim().length() == 0) {
                    intent = new Intent(getApplicationContext(), user_profile.class);
                    startActivity(intent);
                }
                else
                {
                    intent = new Intent(getApplicationContext(), hos_profile.class);
                    startActivity(intent);

                }
            }
        });
        AlertDialog alertDialog= dialogbuilder.create();
        alertDialog.show();


    }


}
