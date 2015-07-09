package com.example.srishti.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener
{
ImageButton login;
ImageButton register;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=(ImageButton)findViewById(R.id.imgbtn1);
        register=(ImageButton)findViewById(R.id.imgbtn2);
    login.setOnClickListener(this);
        register.setOnClickListener(this);

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


    @Override
    public void onClick(View v)
    {
        switch(v.getId()){

            case R.id.imgbtn2:
                Intent i=new Intent(this,LoginNew.class);
                startActivity(i);
                break;

            case R.id.imgbtn1:
                Intent a=new Intent(this,option_signup.class);
                startActivity(a);
                break;
            default: break;
        }
    }
}
