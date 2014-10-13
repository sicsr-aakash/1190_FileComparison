package com.mburman.fileexplore;

import java.io.File;

import java.util.Scanner;
import java.util.StringTokenizer;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CompareFiles extends Activity {

	TextView loadFile1, loadFile2, stats;
	String fname1, fname2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compare_files);
		loadFile1 = (TextView) findViewById(R.id.loadFile1);
		loadFile2 = (TextView) findViewById(R.id.loadFile2);
		stats = (TextView) findViewById(R.id.stats);
		Intent myIntent = getIntent();
		fname1 = myIntent.getStringExtra("file1");
		fname2 = myIntent.getStringExtra("file2");
		String h1 = "<h1>File1</h1>";
		loadFile1.append(Html.fromHtml(h1));
		loadFile1.append("\n");
		String h2 = "<h1>File2</h1>";
		loadFile2.append(Html.fromHtml(h2));
		loadFile2.append("\n");
		int sameCnt = 0;
		int diffCnt = 0;

		try {

			Scanner scanFileOne = new Scanner(new File(fname1));
			
			//File 1
			while(scanFileOne.hasNextLine()){
				String str = scanFileOne.nextLine();
				StringTokenizer st1 = new StringTokenizer(str);
				Log.v("str", str);
				while(st1.hasMoreTokens()){
					String tk = st1.nextToken();
					int flag=0;
					Log.v("tk", tk);
					Scanner scanFileTwo = new Scanner(new File(fname2));
					while(scanFileTwo.hasNext()){
						String next=scanFileTwo.next();
						Log.v("scanFileTwo.hasNext()",next );
						if(tk.equals(next)){
							flag=1;
							sameCnt++;
							break;
						}
						
					}
					if(flag==1){
						loadFile1.append(tk);
						loadFile1.append(" ");
					}
					else{
						String source = "<b><font color='red'>" + tk
								+ "</font></b>";
						loadFile1.append(Html.fromHtml(source));
						loadFile1.append(" ");
						diffCnt++;
					}
				}
				loadFile1.append("\n");
				
			}
	
			//File 2
		
			Scanner scanFile2 = new Scanner(new File(fname2));
			while(scanFile2.hasNextLine()){
				String str = scanFile2.nextLine();
				StringTokenizer st2 = new StringTokenizer(str);
			
				while(st2.hasMoreTokens()){
					String tk = st2.nextToken();
					int flag=0;
					Scanner scanFile1 = new Scanner(new File(fname1));
					while(scanFile1.hasNext()){
						if(tk.equals(scanFile1.next())){
							flag=1;
							break;
						}
						
					}
					if(flag==1){
						loadFile2.append(tk);
						loadFile2.append(" ");
					}
					else{
						String source = "<b><font color='red'>" + tk
								+ "</font></b>";
						loadFile2.append(Html.fromHtml(source));
						loadFile2.append(" ");
						diffCnt++;
					}
				}
				loadFile2.append("\n");
				
			}
	
			stats.setText("Same Words : " + sameCnt + " Different Words : "
					+ diffCnt);
		
		} catch (Exception e) {
		}
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
