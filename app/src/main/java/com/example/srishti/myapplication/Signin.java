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


public class Signin extends ActionBarActivity implements View.OnClickListener {



    ImageButton signinn;
    ImageButton cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        signinn=(ImageButton)findViewById(R.id.reg);
        cancel=(ImageButton)findViewById(R.id.can);
        signinn.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signin, menu);
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
    public  void  onClick(View v)
    {


        switch(v.getId()){

            case R.id.reg:
                showmsg7();
                break;

            case R.id.can:
                EditText name;
                EditText pass;
                EditText bg;
                EditText age;
                EditText weight;



                name = (EditText)findViewById(R.id.ed1);
                pass = (EditText)findViewById(R.id.ed2);
                 bg= (EditText)findViewById(R.id.ed3);
                age = (EditText)findViewById(R.id.ed4);
                weight = (EditText)findViewById(R.id.ed5);
                name.setText("");
                pass.setText("");
                bg.setText("");
                age.setText("");
                weight.setText("");

            default: break;
        }

}

    private void showmsg7()
    {
        AlertDialog.Builder dialogbuilder= new AlertDialog.Builder(this);
        dialogbuilder.setTitle("Registered");
        dialogbuilder.setMessage("You have been registered!");
        dialogbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Registered!", Toast.LENGTH_SHORT).show();
                //I want the new Activity to start only after user clicks ok.
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog= dialogbuilder.create();
        alertDialog.show();


    }




}
