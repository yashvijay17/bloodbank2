package com.example.srishti.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.net.MalformedURLException;
import android.os.AsyncTask;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceList;
import com.microsoft.windowsazure.mobileservices.http.NextServiceFilterCallback;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilter;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterRequest;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;

import static com.example.srishti.myapplication.R.id.hos_add;
import static com.example.srishti.myapplication.R.id.hos_id;
import static com.example.srishti.myapplication.R.id.hos_name;
import static com.example.srishti.myapplication.R.id.rr;


public class signin_hospital extends ActionBarActivity implements View.OnClickListener{

    ImageButton signup;
    ImageButton cancelup;
    private ToDoItemAdapter mAdapter;
    private EditText mTextNewToDo;
    private MobileServiceClient mClient;
    private MobileServiceTable<ToDoItem> mToDoTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_hospital);

        signup=(ImageButton)findViewById(rr);
        cancelup=(ImageButton)findViewById(R.id.cans);
        signup.setOnClickListener(this);
        cancelup.setOnClickListener(this);
        try {
// Create the Mobile Service Client instance, using the provided
// Mobile Service URL and key
            mClient = new MobileServiceClient("MobileServiceUrl","AppKey",this).withFilter(new ProgressFilter());


            // Get the Mobile Service Table instance to use
            mToDoTable = mClient.getTable(ToDoItem.class);
        } catch (MalformedURLException e) {
            createAndShowDialog(new Exception("There was an error creating the Mobile Service. Verify the URL"), "Error");
        }
    }

    public void addItem(View view) {

        // Create a new item
        final ToDoItem item = new ToDoItem();
        EditText name;
        EditText add;
        EditText id;

        name = (EditText)findViewById(R.id.hos_name);
        add = (EditText)findViewById(R.id.hos_add);
        id= (EditText)findViewById(R.id.hos_id);

        item.setText(name.toString());
        item.setComplete(add.toString());
        item.setId(id.toString());

		// Insert the new item
		new AsyncTask<Void, Void, Void>() {

	        @Override
	        protected Void doInBackground(Void... params) {
	            try {
	                mToDoTable.insert(item).get();

	                    runOnUiThread(new Runnable() {
	                        public void run() {
	                            mAdapter.add(item);
	                        }
	                    });

	            } catch (Exception exception) {
	                createAndShowDialog(exception, "Error");
            }
	            return null;
	        }
	    }.execute();


        mTextNewToDo.setText("");
    }

    /**
     * Creates a dialog and shows it
     *
     * @param exception
     *            The exception to show in the dialog
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(Exception exception, String title) {
        createAndShowDialog(exception.toString(), title);
    }

    /**
     * Creates a dialog and shows it
     *
     * @param message
     *            The dialog message
     * @param title
     *            The dialog title
     */
    private void createAndShowDialog(String message, String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(message);
        builder.setTitle(title);
        builder.create().show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signin_hospital, menu);
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

            case R.id.rr :

                showmsg6();
                break;

            case R.id.cans:
                EditText name;
                EditText add;
                EditText id;

                name = (EditText)findViewById(R.id.hos_name);
                add = (EditText)findViewById(R.id.hos_add);
                id= (EditText)findViewById(R.id.hos_id);

                name.setText("");
                add.setText("");
                id.setText("");

            default: break;
        }

    }

    private void showmsg6()
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
