package com.mburman.fileexplore;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import android.widget.TextView;

public class MainActivity extends Activity {

	Button button1, button2, btnCompare;
	TextView editTextFile1, editTextFile2;
	String file1, file2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();

		Intent myIntent = getIntent();

		if (myIntent != null) {
			file1 = myIntent.getStringExtra("file1");
			file2 = myIntent.getStringExtra("file2");
			editTextFile2 = (TextView) findViewById(R.id.file2);
			editTextFile2.setText(file2);
		}
		// String fname = myIntent.getStringExtra("name");
		// Log.d("file",file);
		editTextFile1 = (TextView) findViewById(R.id.file1);
		editTextFile1.setText(file1);
	}

	public void addListenerOnButton() {

		button1 = (Button) findViewById(R.id.btnfile1);
		button2 = (Button) findViewById(R.id.btnfile2);
		btnCompare = (Button) findViewById(R.id.btnCompare);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.e("Error", "Not working");
				Intent intent = new Intent(getApplication(), FileExplore.class);

				startActivity(intent);

			}

		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Log.e("Error", "Not working");
				if (file1 != null) {
					Intent intent = new Intent(getApplication(),
							FileExplore1.class);
					intent.putExtra("file1", file1);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(),
							"Select File1 first !", Toast.LENGTH_LONG).show();
				}
			}

		});
		btnCompare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub


				if ((file1 != null & file2 != null) & (file2 != "")) {
					Intent intent = new Intent(getApplication(),
							CompareFiles.class);
					intent.putExtra("file1", file1);
					intent.putExtra("file2", file2);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(),
							"Select File1 and File2 !", Toast.LENGTH_SHORT)
							.show();
				}

			}
		});

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_help:
	        	
	        	new AlertDialog.Builder(this)
	        	.setTitle("Help")
	        	.setMessage("This application will compare the files word by word.\n\nColors in the file indicate the following :\n\nBlack : Same Words\n\nRed : Different Words")
	        	.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	    public void onClick(DialogInterface dialog, int which) { 
	        	        // Your code
	        	    }
	        	 })
	        	 .show();
	        	
	            
	            return true;
	        case R.id.action_aboutus:
	        	new AlertDialog.Builder(this)
	        	.setTitle("AboutUs")
	        	.setMessage("Application Version : 1.1\nDeveloped by : Farheen Panjwani(Symbiosis Institute of Computer Studies and Research")
	        	.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        	    public void onClick(DialogInterface dialog, int which) { 
	        	        // Your code
	        	    }
	        	 })
	        	 .show();
	        	
	            
	            
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compare_files, menu);
		return true;
	}


	
	
}
